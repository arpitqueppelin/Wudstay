package com.wudstay.activity;

import android.os.Bundle;

import com.wudstay.R;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDrawerAndToolbar("Home");
    }
}
