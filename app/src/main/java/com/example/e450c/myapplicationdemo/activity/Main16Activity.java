package com.example.e450c.myapplicationdemo.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.e450c.myapplicationdemo.R;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment2;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment3;
import com.example.e450c.myapplicationdemo.fragments.BlankFragment4;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Main16Activity extends AppCompatActivity {

    @InjectView(R.id.vp_16)
    ViewPager viewPager;

    private List<Fragment> list;

    private mFragmentAdapter mFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        ButterKnife.inject(this);
        mFragmentAdapter = new mFragmentAdapter(getSupportFragmentManager());
        BlankFragment blankFragment = BlankFragment.newInstance();
        BlankFragment2 blankFragment2 = BlankFragment2.newInstance();
        BlankFragment3 blankFragment3 = BlankFragment3.newInstance();
        BlankFragment4 blankFragment4 = BlankFragment4.newInstance();
        list = new ArrayList<Fragment>();
        list.add(blankFragment);
        list.add(blankFragment2);
        list.add(blankFragment3);
        list.add(blankFragment4);
        viewPager.setAdapter(mFragmentAdapter);
        viewPager.setPageTransformer(true, new mPageTransForm());
        Window window = getWindow();
//设置透明状态栏,这样才能让 ContentView 向上
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//设置状态栏颜色
//        window.setStatusBarColor();
//为了设置全屏
        ViewGroup mContentView = (ViewGroup)findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 使其不为系统 View 预留空间.
            ViewCompat.setFitsSystemWindows(mChildView, false);

        }
    }


    class  mFragmentAdapter extends FragmentStatePagerAdapter{

        public mFragmentAdapter(FragmentManager fm) {
            super(fm);
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

    class mPageTransForm implements ViewPager.PageTransformer{

        @Override
        public void transformPage(View page, float position) {
                    int width = page.getWidth();
                    int height = page.getHeight();
                    if (position>0 && position<=1){
                        page.setTranslationX(-width * position);
                        page.setPivotX(width/2);
                        page.setPivotY(height/2);
                        page.setScaleX(1-position);
                        page.setScaleX(1-position);
                    }

        }
    }
}
