package com.demo.swt.eventbugdemo;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by pc on 2016/11/25.
 */

class P implements C.p {
    private Activity activity;
    private C.v view;

    public P(Activity activity, C.v view) {
        this.activity = activity;
        this.view = view;
    }


    @Override
    public void gettoast() {
        Toast.makeText(activity, "发送_biubiu", Toast.LENGTH_LONG).show();
        view.showtoast("尼玛");
    }
}
