package com.example.e450c.myapplicationdemo.activity;

import android.support.design.widget.TabLayout;
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

public class Main12Activity extends AppCompatActivity {

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private List<String> titles;

    private List<Fragment> fragments;

    private MyPagerAdatper myPagerAdatper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.vp_pager);
        titles = new ArrayList<String>();
        fragments = new ArrayList<Fragment>();
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        myPagerAdatper = new MyPagerAdatper(getSupportFragmentManager());

        titles.add("我的首页");
        titles.add("福尔摩斯");
        titles.add("下当今");
        titles.add("大长今");


        fragments.add(BlankFragment.newInstance());
        fragments.add(BlankFragment4.newInstance());
        fragments.add(BlankFragment2.newInstance());
        fragments.add(BlankFragment3.newInstance());

        for (int i =0 ; i<titles.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(titles.get(i)));
        }
        viewPager.setAdapter(myPagerAdatper);
        tabLayout.setupWithViewPager(viewPager);


    }


    class MyPagerAdatper extends FragmentStatePagerAdapter{

        public MyPagerAdatper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
