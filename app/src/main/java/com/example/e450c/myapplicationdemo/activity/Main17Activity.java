package com.example.e450c.myapplicationdemo.activity;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.e450c.myapplicationdemo.R;
import com.example.e450c.myapplicationdemo.adapter.MyRecycleApater;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment2;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment3;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment4;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Main17Activity extends AppCompatActivity {


    @InjectView(R.id.rv_17)
    RecyclerView recyclerView;

    private List<String> lists;

    private MyRecycleApater myRecycleApater;

    private List<Fragment> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        ButterKnife.inject(this);

        lists = new ArrayList<String>();


        BlankFragment blankFragment = BlankFragment.newInstance();
        BlankFragment2 blankFragment2 = BlankFragment2.newInstance();
        BlankFragment3 blankFragment3 = BlankFragment3.newInstance();
        BlankFragment4 blankFragment4 = BlankFragment4.newInstance();
        list = new ArrayList<Fragment>();
        list.add(blankFragment);
        list.add(blankFragment2);
        list.add(blankFragment3);
        list.add(blankFragment4);


        for(int i = 0;i<=100;i++){
            lists.add(i,""+i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecycleApater = new MyRecycleApater(this,lists,list,getSupportFragmentManager());
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(null,"alpha",0f,1f);
//        LayoutTransition mLayoutT = new LayoutTransition();
//        mLayoutT.setAnimator(LayoutTransition.APPEARING,objectAnimator);
//        recyclerView.setLayoutTransition(mLayoutT);
        recyclerView.setAdapter(myRecycleApater);

    }






}
