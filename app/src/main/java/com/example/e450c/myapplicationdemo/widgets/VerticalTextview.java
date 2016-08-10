package com.example.e450c.myapplicationdemo.widgets;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.example.e450c.myapplicationdemo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Created by e450c on 2016/7/26.
 */
public class VerticalTextview extends TextSwitcher implements TextSwitcher.ViewFactory{


    public static final int FLAG_START_AUTO_SCROLL = 0;

    public static final int FLAG_STOP_AUTO_SCROLL = 1;

    private Context context;
    //字体间距
    private int Padding = 5;
    //滚动内容列表
    private ArrayList<String> textList;
    //字号
    private float textSize = 16;
    //字体颜色
    private int textColor = Color.BLACK;
    //当前展示的条目的位置
    private int currentId = -1;

    private Handler handler;
    private OnItemClickListener onItemClickListener;





    public VerticalTextview(Context context) {
        super(context);
        this.context = context;
    }

    public VerticalTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    /**
     * 设置滚动数据内容
     * @param textList
     */
    public void setTextList(ArrayList<String> List) {
        textList = new ArrayList<String>();
        textList.clear();
        textList.addAll(List);
        currentId = -1;
    }

    public void setText(float textSize, int padding, int textColor) {
        this.textSize = textSize;
        this.Padding = padding;
        this.textColor = textColor;
    }


    public void setAnimTime(long duration) {
        setFactory(this);
        Animation in = new TranslateAnimation(0,0,duration,0);
        in.setDuration(duration);
        in.setInterpolator(new AccelerateInterpolator());
        Animation out = new TranslateAnimation(0,0,0,-duration);
        out.setDuration(duration);
        out.setInterpolator(new AccelerateInterpolator());
        setInAnimation(in);
        setOutAnimation(out);
    }

    @Override
    public View makeView() {
        TextView t = new TextView(context);
        t.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
        t.setMaxLines(1);
        t.setPadding(this.Padding,this.Padding,this.Padding,this.Padding);
        t.setTextColor(textColor);
        t.setTextSize(textSize);
        t.setClickable(true);

        t.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null && textList.size() >0 && currentId != -1){
                    onItemClickListener.onItemClick(currentId % textList.size());
                }



            }
        });
        return t;
    }

    public void startScroll(){
        handler.sendEmptyMessage(FLAG_START_AUTO_SCROLL);
    }

    public void stopScroll(){
        handler.sendEmptyMessage(FLAG_STOP_AUTO_SCROLL);

    }



    public void setTextStillTime(final long time){
            handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what){
                        case FLAG_START_AUTO_SCROLL:
                            if (textList.size()>0){
                                currentId++;
                                setText(textList.get(currentId % textList.size()));
                            }
                            handler.sendEmptyMessageDelayed(FLAG_START_AUTO_SCROLL,time);
                            break;
                        case FLAG_STOP_AUTO_SCROLL:
                            handler.removeMessages(FLAG_START_AUTO_SCROLL);
                            break;
                    }
                    super.handleMessage(msg);
                }


            };
    }

    public void setOnItemClickListener(OnItemClickListener OnItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener{

            void onItemClick(int position);
    }

}
