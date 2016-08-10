package com.example.e450c.myapplicationdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e450c.myapplicationdemo.R;
import com.example.e450c.myapplicationdemo.adapter.Myadapter;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    private LayoutInflater layoutInflater;

    private ListView lv;
    private Button btn;
    private List a;
    private int listPosition;
    private int scrollTop;
    private int lastposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Toast.makeText(Main5Activity.this,"第五个",Toast.LENGTH_SHORT).show();
        btn = (Button) findViewById(R.id.btn);
        lv =(ListView) findViewById(R.id.lv);
        initData();
        layoutInflater = LayoutInflater.from(this);
        Myadapter adapter = new Myadapter(a,this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                lv.setSelection(5);
                lv.setSelectionFromTop(listPosition,scrollTop);
            }
        });
        lv.setAdapter(adapter);
        lv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    listPosition = lv.getFirstVisiblePosition();
                }


                return false;
            }
        });

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                    if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE){

                        View v = lv.getChildAt(0);
                        scrollTop = (v==null)?0:v.getTop();
                        Toast.makeText(Main5Activity.this,listPosition+"--"+scrollTop,Toast.LENGTH_LONG).show();
                    }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Toast.makeText(Main5Activity.this, firstVisibleItem+"", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void initData() {
        a = new ArrayList();
        for (int i = 0;i<=50;i++){
            a.add(i,i+"");
        }
    }


}
