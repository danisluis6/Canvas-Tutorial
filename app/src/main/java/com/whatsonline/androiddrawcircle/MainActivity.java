package com.whatsonline.androiddrawcircle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {


  private LinearLayout topHeader;
  private ImageView imvHeader;
  private Context mContext;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    topHeader = (LinearLayout) findViewById(R.id.llTopHeader);
    imvHeader = (ImageView) findViewById(R.id.imvHeader);

    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int width = size.x;
    int height = size.y;

    Log.i("TAG", "Height layout: "+topHeader.getHeight());
    Log.i("TAG", "Height layout: "+imvHeader.getHeight());

    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.talking);
    new Shape(getApplicationContext(),this, icon, imvHeader, width, 600);
  }
}
