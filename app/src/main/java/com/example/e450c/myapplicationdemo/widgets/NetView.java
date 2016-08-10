package com.example.e450c.myapplicationdemo.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by e450c on 2016/5/18.
 */
public class NetView extends View{

    private int count = 6;
    private NetViewAttr netViewAttr;

    private int netColor;
    private int netOverLayAlpha;


    private String[] titles = {"a","b","c","d","e","f"};

    private double[] data = {1,0.8,0.6,0.5,0.8,0.2};

    public NetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        netViewAttr = new NetViewAttr(context,attrs,defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        count = Math.min(titles.length,data.length);
        netColor = netViewAttr.getNetcolor();
        netOverLayAlpha =  netViewAttr.getOverlayAlpha();
        netViewAttr.getOverlaycolor();
        netViewAttr.getTagSize();
        netViewAttr.getTextcolor();

    }
}
