package com.example.e450c.myapplicationdemo.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.example.e450c.myapplicationdemo.R;

/**
 * Created by e450c on 2016/7/25.
 */
public class FruitLoadingView extends View{

    private int shadowColor;

    private float maxHeight;

    private int fruitWidth;

    private float fruitHeight;

    private float animationDuration;

    private Drawable fruitDrawable;


    public FruitLoadingView(Context context) {
        super(context);
    }

    public FruitLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public FruitLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public FruitLoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if(attrs == null){
            return;
        }
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FruitLoadingView);

        shadowColor = a.getInt(R.styleable.FruitLoadingView_shadowColor, Color.BLACK);

        maxHeight = a.getDimension(R.styleable.FruitLoadingView_maxHeight,10f);

        fruitHeight = a.getDimension(R.styleable.FruitLoadingView_fruitHeight,-1);
    }
}
