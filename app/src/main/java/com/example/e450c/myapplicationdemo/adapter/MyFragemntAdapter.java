package com.example.e450c.myapplicationdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by e450c on 2016/8/29.
 */
public class MyFragemntAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> list;

    public MyFragemntAdapter(List<Fragment> list,FragmentManager fm) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}