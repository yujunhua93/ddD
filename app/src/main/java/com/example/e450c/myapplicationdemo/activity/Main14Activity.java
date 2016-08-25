package com.example.e450c.myapplicationdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.e450c.myapplicationdemo.R;
import com.example.e450c.myapplicationdemo.widgets.BlurBitmap;

public class Main14Activity extends AppCompatActivity {
    private ImageView imageview;
    private Bitmap mTempBitmap;
    private Bitmap finalTempBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        imageview = (ImageView) findViewById(R.id.iv_14);
        mTempBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.loading);
        finalTempBitmap = BlurBitmap.blur(this,mTempBitmap);
        imageview.setImageBitmap(finalTempBitmap);

    }
}
