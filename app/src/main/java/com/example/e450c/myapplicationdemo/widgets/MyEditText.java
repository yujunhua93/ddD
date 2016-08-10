package com.example.e450c.myapplicationdemo.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.e450c.myapplicationdemo.R;

/**
 * Created by e450c on 2016/6/28.
 */
public class MyEditText extends EditText{

    private Drawable mClearDrawable;

    private int colorAccent;


    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray array = context.getTheme()
                .obtainStyledAttributes(new int[] {android.R.attr.colorAccent});
        colorAccent = array.getColor(0,0xFF00FF);
        array.recycle();
        initCleanDrawable(context);

    }

    private void initCleanDrawable(Context context) {
        mClearDrawable = getCompoundDrawables()[2];
        if (null == mClearDrawable){
            mClearDrawable = getResources().getDrawable(R.drawable.ic_delete_01,context.getTheme());
        }
        DrawableCompat.setTint(mClearDrawable,colorAccent);
        mClearDrawable.setBounds(0,0,(int)getTextSize(),(int)getTextSize());
        setClearIconVisible(true);


    }

    private void setClearIconVisible(boolean b) {

        Drawable right = b?mClearDrawable:null;

    }


}
