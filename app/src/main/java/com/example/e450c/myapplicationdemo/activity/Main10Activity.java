package com.example.e450c.myapplicationdemo.activity;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.e450c.myapplicationdemo.R;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment2;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment3;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment4;

import java.util.ArrayList;
import java.util.List;

import static com.example.e450c.myapplicationdemo.activity.Main9Activity.*;

public class Main10Activity extends AppCompatActivity {

    private List<Fragment> fragments;

    private MyFragmentAdatper myFragmentAdatper;

    private ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        initData();
    }

    private void initData() {
        myFragmentAdatper  = new MyFragmentAdatper(getSupportFragmentManager());


        fragments = new ArrayList<Fragment>();
        BlankFragment f1 = BlankFragment.newInstance();
        BlankFragment2 f2 = BlankFragment2.newInstance();
        BlankFragment3 f3 = BlankFragment3.newInstance();
        BlankFragment4 f4 = BlankFragment4.newInstance();
        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);
        fragments.add(f4);
        viewpager.setAdapter(myFragmentAdatper);
    }

    class MyFragmentAdatper extends FragmentStatePagerAdapter{

        public MyFragmentAdatper(FragmentManager fm) {
            super(fm);
        }



        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }


}
