package com.whatsonline.androiddrawcircle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.widget.ImageView;


public class Shape {

    private Bitmap bmp;
    private ImageView img;

    public Shape(Bitmap bmp, ImageView img) {

        this.bmp = bmp;
        this.img = img;
        onDraw();
    }


    private void onDraw() {

        Canvas canvas = new Canvas();
        if (bmp.getWidth() == 0 || bmp.getHeight() == 0) {
            return;
        }

        int w = bmp.getWidth(), h = bmp.getHeight();

        Bitmap roundBitmap = getRoundedCroppedBitmap(bmp, w);

        img.setImageBitmap(roundBitmap);

    }

    public static Bitmap getRoundedCroppedBitmap(Bitmap bitmap, int radius) {

        // Step 1: Create a new object Bitmap
        Bitmap finalBitmap;

        /**
         * Step 2: Scale image into square with width = height (If original size > 1024)
         * Apply: Triangle and circle
         */

        if (bitmap.getWidth() != radius || bitmap.getHeight() != radius)
            finalBitmap = Bitmap.createScaledBitmap(bitmap, radius, radius, false);
        else
            finalBitmap = bitmap;

        // Step 3,3.7: Create Rect
        final Rect rect = new Rect(0, 0, finalBitmap.getWidth(), finalBitmap.getHeight());

        // Step 4: Create Canvas
        Bitmap output = Bitmap.createBitmap(finalBitmap.getWidth(),
                finalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        canvas.drawARGB(0, 0, 0, 0);

        // Step 5: Create Paint
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(Color.parseColor("#BAB399"));

        // Step 6: => Expected: Circle => available function drawCircle() => Apply no need to custom
        canvas.drawCircle(finalBitmap.getWidth() / 2 + 0.7f, finalBitmap.getHeight() / 2 + 0.7f, finalBitmap.getWidth() / 2 + 0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        // Step 7:
        canvas.drawBitmap(finalBitmap, rect, rect, paint);
        
        return output;
    }
}