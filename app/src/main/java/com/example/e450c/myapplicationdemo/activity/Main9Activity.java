package com.example.e450c.myapplicationdemo.activity;

import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.e450c.myapplicationdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;

public class Main9Activity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;

    private ArrayList<View> pages = null;

    private MyPagerAdapter myPagerAdapter;

    private Button btn;

    private RelativeLayout rl;
    private ArrayList<String> titles = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        btn = (Button) findViewById(R.id.lastbtn);
        rl = (RelativeLayout) findViewById(R.id.rl);
        pages = new ArrayList<View>();
        titles = new ArrayList<String>();
        titles.add("第一个标题");
        titles.add("第二个标题");
        titles.add("第三个标题");
        titles.add("第四个标题");
        String url1 = "http://img5.imgtn.bdimg.com/it/u=2263402757,1324836240&fm=21&gp=0.jpg";
        String url2 =  "http://img5.imgtn.bdimg.com/it/u=257975592,4159138965&fm=21&gp=0.jpg";
        String url3 = "http://img1.imgtn.bdimg.com/it/u=4033491868,3189899599&fm=21&gp=0.jpg";
        String url4 = "http://img0.imgtn.bdimg.com/it/u=3199433449,2223803211&fm=21&gp=0.jpg";
        View view1 = LayoutInflater.from(this).inflate(R.layout.layout1,null);
        ImageView image1 = (ImageView) view1.findViewById(R.id.image1);
        Picasso.with(this).load(url1).into(image1);
        View view2 = LayoutInflater.from(this).inflate(R.layout.layout2,null);
        ImageView image2 = (ImageView) view2.findViewById(R.id.image2);
        Picasso.with(this).load(url2).into(image2);
        View view3 = LayoutInflater.from(this).inflate(R.layout.layout3,null);
        ImageView image3 = (ImageView) view3.findViewById(R.id.image3);
        Picasso.with(this).load(url3).into(image3);
        View view4 = LayoutInflater.from(this).inflate(R.layout.layout4,null);
        ImageView image4 = (ImageView) view4.findViewById(R.id.image4);
        Picasso.with(this).load(url4).into(image4);
        pages.add(view1);
        pages.add(view2);
        pages.add(view3);
        pages.add(view4);
        myPagerAdapter = new MyPagerAdapter();
        viewPager.setAdapter(myPagerAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rl,"show",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
            if (position == pages.size()-1){
                btn.setVisibility(View.VISIBLE);
            }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView(pages.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(pages.get(position));
            return pages.get(position);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }


}
