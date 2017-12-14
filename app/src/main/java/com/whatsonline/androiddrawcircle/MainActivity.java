package com.whatsonline.androiddrawcircle;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img=(ImageView) findViewById(R.id.img);

        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.img);

        new Shape(icon,img);
    }
}
