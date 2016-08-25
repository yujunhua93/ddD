package com.example.e450c.myapplicationdemo.activity;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.e450c.myapplicationdemo.R;

public class Main13Activity extends AppCompatActivity {

    private TextView textView;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

        button = (Button) findViewById(R.id.btn_13);

        textView = (TextView) findViewById(R.id.tv_13);

        final CountDownTimer c = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long l = millisUntilFinished/1000;
                textView.setText(l+"");
                System.out.println(l);
            }

            @Override
            public void onFinish() {
                textView.setText("0");
            }
        };


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.start();
            }
        });

    }
}
