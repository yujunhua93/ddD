package com.example.e450c.myapplicationdemo.animation;


import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by e450c on 2016/8/23.
 */
public class ThreeDRotationAnimation extends Animation {

    private float mFromDegrees;

    private float mToDegrees;

    private float mCenterX;

    private float mCenterY;




    Camera camera = new Camera();



    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        mCenterX = width/2;
        mCenterY = height/2;
        setDuration(500);
        setInterpolator(new LinearInterpolator());


    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        Matrix matrix = t.getMatrix();
        camera.save();

        camera.rotateY(360 * interpolatedTime);
        camera.getMatrix(matrix);
        matrix.preTranslate(-mCenterX, -mCenterY);
        matrix.postTranslate(mCenterX, mCenterY);
        camera.restore();



    }
}
