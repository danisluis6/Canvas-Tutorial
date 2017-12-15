package com.whatsonline.androiddrawcircle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {


  private ImageView imv1;
  private ImageView imv2;
  private ImageView imv3;
  private Context mContext;
  private LinearLayout layer1;
  private LinearLayout layer2;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    imv1 = (ImageView) findViewById(R.id.imv1);
    imv2 = (ImageView) findViewById(R.id.imv2);

    layer1 = (LinearLayout) findViewById(R.id.layer1);
    layer2 = (LinearLayout) findViewById(R.id.layer2);


    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int width = size.x;
    int height = size.y;

    final Bitmap icon1 = BitmapFactory.decodeResource(getResources(), R.drawable.talking);
    final Bitmap icon2 = BitmapFactory.decodeResource(getResources(), R.drawable.img);

    new Layer1(mContext, MainActivity.this, icon1, imv1, width, 400);
    new Layer2(mContext, MainActivity.this, icon2, imv2, width, 400);

  }
}
