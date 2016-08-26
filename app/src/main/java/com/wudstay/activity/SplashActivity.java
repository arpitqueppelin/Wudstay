package com.wudstay.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

import com.wudstay.R;

public class SplashActivity extends BaseActivity {

    private SplashActivity ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(ctx, R.color.splash_header));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intentHome = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intentHome);
                finish();

            }
        }, 5000);
    }
}
