package com.example.e450c.myapplicationdemo.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.e450c.myapplicationdemo.R;
import com.example.e450c.myapplicationdemo.animation.ThreeDRotationAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Main15Activity extends AppCompatActivity {
    @InjectView(R.id.iv_icon)
    ImageView icon;
    @InjectView(R.id.iv_wallet)
    ImageView wallet;
    @InjectView(R.id.button)
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);
        ButterKnife.inject(this);


    }

    @OnClick(R.id.button)
    public void click(){
        Animation dropAnimation = AnimationUtils.loadAnimation(this,R.anim.drop_down);
        ThreeDRotationAnimation animation = new ThreeDRotationAnimation();
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(800);
        animationSet.addAnimation(dropAnimation);
        animationSet.addAnimation(animation);
        icon.startAnimation(animationSet);

        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,1f);
        valueAnimator.setDuration(800);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float faction = animation.getAnimatedFraction();
                if (faction>=0.75){
                    valueAnimator.cancel();
                    startWallet();
                }
            }
        });
        valueAnimator.start();
    }

    private void startWallet() {
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(wallet,"scaleX",1,1.1f,0.9f,1);
        objectAnimatorX.setDuration(600);
        ObjectAnimator objectAnimationY = ObjectAnimator.ofFloat(wallet,"scaleY",1,0.75f,1.25f,1);
        objectAnimationY.setDuration(600);
        AnimatorSet as = new AnimatorSet();
        as.setInterpolator(new LinearInterpolator());
        as.playTogether(objectAnimatorX, objectAnimationY);
        as.start();
    }
}
