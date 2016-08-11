package com.example.e450c.myapplicationdemo.activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.e450c.myapplicationdemo.R;
import com.example.e450c.myapplicationdemo.widgets.MyScrollerView;

public class Main8Activity extends AppCompatActivity implements MyScrollerView.ScrollViewListener{

    private MyScrollerView myScrollerView;

    private ListView listView;

    private TextView textView;

    private ImageView imageView;

    private int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        myScrollerView = (MyScrollerView) findViewById(R.id.mysv);

        textView = (TextView) findViewById(R.id.textview);

        imageView = (ImageView) findViewById(R.id.imageview);

        listView = (ListView) findViewById(R.id.listview);

        imageView.setFocusable(true);
        imageView.setFocusableInTouchMode(true);
        imageView.requestFocus();
        initListener();
        initData();
    }

    private void initListener() {
        ViewTreeObserver vto = imageView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                height = imageView.getHeight();
                myScrollerView.setScrollViewListener(Main8Activity.this);
            }
        });

    }

    private void initData() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main8Activity.this,android.R.layout.simple_expandable_list_item_1,getResources().getStringArray(R.array.data));
        listView.setAdapter(adapter);
    }

    @Override
    public void onScrollChanged(MyScrollerView myScrollerView, int x, int y, int oldx, int oldy) {

        if (y<=0){
            textView.getBackground().setAlpha(0);
        }else if (y>0 && y<height){
            float scale = (float) y / height;
            int alpha = (int) (255 * scale);
            System.out.println("percent ="+ alpha);
            textView.getBackground().setAlpha(alpha);

        }else{
            textView.getBackground().setAlpha(255);
        }

                System.out.println("y ="+ y +"h ="+height);



    }
}
