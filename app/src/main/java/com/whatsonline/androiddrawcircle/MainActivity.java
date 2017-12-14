package com.whatsonline.androiddrawcircle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class MainActivity extends Activity {

  private ImageView img;
  private Context mContext;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    img = (ImageView) findViewById(R.id.img);

    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int width = size.x;
    int height = size.y;

    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.img);

    new Shape(getApplicationContext(),this, icon, img, width, height);
  }
}
