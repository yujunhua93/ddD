package com.example.e450c.myapplicationdemo.widgets;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by e450c on 2016/8/10.
 */
public class MyScrollerView extends  ScratchView {

    public interface  ScrollViewListener{

        void onScrollChanged(MyScrollerView myScrollerView,int x,int y,int oldx,int oldy);
    }

    public ScrollViewListener scrollViewListener = null ;

    public MyScrollerView(Context context) {
        super(context);
    }



    public MyScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollViewListener != null){
            scrollViewListener.onScrollChanged(this,l,t,oldl,oldt);
        }
    }
}
