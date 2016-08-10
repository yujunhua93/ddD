package com.example.e450c.myapplicationdemo.activity;

import android.content.Context;
import android.net.Uri;
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


import java.util.List;

public class TabActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private String[] list = {"守望先锋", "英雄联盟", "足球先生", "战地", "炉石", "地下城与勇士"};
    private ViewPager vp;

    private List<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        vp = (ViewPager)findViewById(R.id.viewpager);
        for (int i = 0; i < list.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(list[i]));
        }
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        BlankFragment f1 = BlankFragment.newInstance("1","2");
        BlankFragment2 f2  = BlankFragment2.newInstance("3","4");
        ViewPagerAdapter viewPager= new ViewPagerAdapter(getSupportFragmentManager(),this,fragmentList,list);
        vp.setAdapter(viewPager);
        tabLayout.setupWithViewPager(vp);
    }





    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private String[] tabTitleArray;

        private List<Fragment> fragmentList;

        public ViewPagerAdapter(FragmentManager fm, Context context,
                                List<Fragment> fragmentList, String[] tabTitleArray) {
            super(fm);
            this.tabTitleArray = tabTitleArray;
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return tabTitleArray.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitleArray[position % tabTitleArray.length];
        }
    }
}
