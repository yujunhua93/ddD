package com.example.e450c.myapplicationdemo.activity;

import android.app.Notification;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.e450c.myapplicationdemo.R;
import com.example.e450c.myapplicationdemo.widgets.CountNumberView;
import com.example.e450c.myapplicationdemo.widgets.VerticalTextview;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {

    private RelativeLayout main;
    private ArrayList<String> titleList = new ArrayList<String>();
    private CountNumberView countNumberView;
    private VerticalTextview TextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        init();

//        countNumberView = (CountNumberView) findViewById(R.id.cnv);

//        countNumberView.showNumberWithAnimation(6543.33f,countNumberView.INTREGEX);

    }



    private void init() {
        TextView = (VerticalTextview) findViewById(R.id.text);
        titleList.add("你是天上最受宠的一架钢琴的近看的");
        titleList.add("我是丑人脸上的鼻涕");
        titleList.add("你发出完美的声音");
        titleList.add("我被默默揩去");
        titleList.add("你冷酷外表下藏着诗情画意啦啦啦啦啦啦");
        titleList.add("我已经够胖还吃东西");
        titleList.add("你踏着七彩祥云离去");
        titleList.add("我被留在这里");
        TextView.setTextList(titleList);
        TextView.setText(26, 5, Color.RED);//设置属性
        TextView.setTextStillTime(3000);//设置停留时长间隔
        TextView.setAnimTime(300);//设置进入和退出的时间间隔
        TextView.setOnItemClickListener(new VerticalTextview.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(Main6Activity.this, "点击了 : " + titleList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        TextView.startScroll();
    }
}
