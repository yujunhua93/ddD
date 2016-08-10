package com.example.e450c.myapplicationdemo.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.example.e450c.myapplicationdemo.R;

/**
 * Created by e450c on 2016/5/18.
 */
public class NetViewAttr {

    private int netcolor;
    private int overlaycolor;
    private int textcolor;
    private int overlayAlpha;
    private int tagSize;


    public NetViewAttr(Context context, AttributeSet attrs,int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NetView,defStyleAttr,0);
        netcolor = a.getInt(R.styleable.NetView_netColor,context.getResources().getColor(R.color.colorPrimaryDark));
        overlaycolor = a.getInt(R.styleable.NetView_overLayAlpha,context.getResources().getColor(R.color.colorYellow));
        textcolor = a.getInt(R.styleable.NetView_textColor,context.getResources().getColor(R.color.colorPrimary));
        overlayAlpha = a.getInteger(R.styleable.NetView_overLayAlpha,130);
        tagSize = a.getInteger(R.styleable.NetView_tagSize,20);
        a.recycle();

    }

    public int getNetcolor() {
        return netcolor;
    }

    public int getOverlaycolor() {
        return overlaycolor;
    }

    public int getOverlayAlpha() {
        return overlayAlpha;
    }

    public int getTextcolor() {
        return textcolor;
    }

    public int getTagSize() {
        return tagSize;
    }
}
