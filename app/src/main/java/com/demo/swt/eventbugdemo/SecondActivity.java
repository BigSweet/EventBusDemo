package com.demo.swt.eventbugdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by pc on 2016/11/25.
 */

public class SecondActivity extends AppCompatActivity implements C.v {
    private Button mSecondButoon;
    private NestedScrollView scrollView;
    private C.p p;
    private Button buttontest;
    private TextView bottontextview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EventBus.getDefault().register(this);
        buttontest = (Button) findViewById(R.id.test);
        buttontest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetBehavior behavior = BottomSheetBehavior.from(findViewById(R.id.bottom_textview));
                if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });
        bottontextview = (TextView) findViewById(R.id.bottom_textview);
        mSecondButoon = (Button) findViewById(R.id.second_button);
        mSecondButoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MyInfoChange());
                finish();
            }
        });


        p = new P(this, this);

    }

    //第二个界面响应事件的方法
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void oninfoChange(MyInfoChange event) {
        p.gettoast();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void showtoast(String s) {
        Log.i("aly", s);
    }
}
