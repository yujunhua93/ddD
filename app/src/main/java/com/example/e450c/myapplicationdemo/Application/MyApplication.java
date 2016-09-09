package com.example.e450c.myapplicationdemo.Application;

import android.app.Application;
import android.widget.Toast;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by e450c on 2016/9/2.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PushAgent mPushAgent = PushAgent.getInstance(this);
        mPushAgent.enable(new IUmengRegisterCallback() {
            @Override
            public void onRegistered(String s) {
                System.out.println("该设备的token"+s);
                Toast.makeText(getApplicationContext(),"该设备的token"+ s,Toast.LENGTH_LONG).show();
            }
        });
        PushAgent.getInstance(this).onAppStart();
    }
}
