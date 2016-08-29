package com.example.e450c.myapplicationdemo.activity;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.e450c.myapplicationdemo.R;
import com.example.e450c.myapplicationdemo.widgets.BlurBitmap;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Main14Activity extends AppCompatActivity {
    private ImageView imageview;
    private Bitmap mTempBitmap;
    private Bitmap finalTempBitmap;
    @InjectView(R.id.iv2_14)
    ImageView imageview2;
    @InjectView(R.id.iv3_14)
    ImageView imageview3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        ButterKnife.inject(this);
        imageview = (ImageView) findViewById(R.id.iv_14);
        mTempBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.loading);
        finalTempBitmap = BlurBitmap.blur(this,mTempBitmap);
        imageview.setImageBitmap(finalTempBitmap);
        RoundedBitmapDrawable drawableA = RoundedBitmapDrawableFactory.create(getResources(),id2Bitmap(this,R.drawable.loading));
        drawableA.setCircular(true);
        imageview2.setImageDrawable(drawableA);
        RoundedBitmapDrawable drawableB = RoundedBitmapDrawableFactory.create(getResources(),id2Bitmap(this,R.drawable.loading));
        drawableB.setCornerRadius(30L);
        imageview3.setImageDrawable(drawableB);
    }

    private Bitmap id2Bitmap(Context context, int loading) {
        return  BitmapFactory.decodeResource(context.getResources(),loading);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
