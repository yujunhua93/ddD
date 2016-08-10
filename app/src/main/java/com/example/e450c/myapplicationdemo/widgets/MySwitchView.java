package com.example.e450c.myapplicationdemo.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by e450c on 2016/7/19.
 */
public class MySwitchView extends View {

    private Paint mPaint = new Paint();

    private Path mPath = new Path();

    private int mWidth,mHeight;

    private float sWidth,sHeight;

    private float sLeft,sRight,sTop,sBottom;

    private float sCenterX,sCenterY;

    public MySwitchView(Context context) {
        super(context);
    }

    public MySwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MySwitchView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthSize = (int) (heightSize*0.65f);
        setMeasuredDimension(heightSize,widthSize);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        sLeft = sTop = 0;
        sRight = mWidth;
        sBottom = mHeight/0.8f;
        sWidth = sRight - sLeft;
        sHeight = sBottom - sTop;
        sCenterX = (sRight + sLeft)/2;
        sCenterY = (sBottom + sTop)/2;
        RectF sRectF = new RectF(sLeft,sTop,sRight,sBottom);
        mPath.arcTo(sRectF,90,180);
        sRectF.left = sRight - sBottom;
        sRectF.right = sRight;
        mPath.arcTo(sRectF,270,180);
        mPath.close();




    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(0xffcccccc);
        canvas.drawPath(mPath,mPaint);
    }
}
