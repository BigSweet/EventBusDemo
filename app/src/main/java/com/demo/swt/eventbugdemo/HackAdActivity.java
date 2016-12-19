package com.demo.swt.eventbugdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

public class HackAdActivity extends AppCompatActivity {


    private Handler mHandler = new Handler(Looper.getMainLooper());

    private Runnable mCallback = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.demo.swt.eventbugdemo",
                    "com.demo.swt.eventbugdemo.MainActivity"));
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler.postDelayed(mCallback, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mCallback);
    }
}
