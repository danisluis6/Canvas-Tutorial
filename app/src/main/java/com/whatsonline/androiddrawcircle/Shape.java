package com.whatsonline.androiddrawcircle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.widget.ImageView;

/**
 * @Question: How do android screen coordinates work?
 * @Run: https://stackoverflow.com/questions/11483345/how-do-android-screen-coordinates-work
 * Implement
 *
 * @
 */

public class Shape {

    private Bitmap bmp;
    private ImageView img;
    private static Activity mActivity;
    private static Context mContext;
    private  static int screenWidth;
    private static int screenHeight;

    public Shape(Context mContext, MainActivity mActivity, Bitmap bmp, ImageView img, int width,
        int height) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.bmp = bmp;
        this.img = img;
        screenWidth = width;
        screenHeight = height;
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
        /*
         * Analysis: How many point do you need to specify before drawing?
         *
         */
        Paint paint = new Paint();
        Point point1 = new Point(0,0);
        Point point2 = new Point(screenWidth, 0);
        Point point3 = new Point(0, screenHeight);

        Path path = new Path();
        path.moveTo(point1.x, point1.y);
        path.lineTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        path.lineTo(point1.x, point1.y);
        path.close();
        paint.setColor(Color.parseColor("#BAB399"));

        // Step 6: => Expected: => drawPath()
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        // Step 7:
        canvas.drawBitmap(finalBitmap, rect, rect, paint);
        
        return output;
    }
}