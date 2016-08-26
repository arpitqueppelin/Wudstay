package com.wudstay.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wudstay.R;
import com.wudstay.fragments.DrawerFragment;

/**
 * Created by Administrator on 22-Aug-16.
 */
public class BaseActivity extends AppCompatActivity{

    public DrawerLayout mDrawerLayout;
    private RelativeLayout notification_layout;

    public Toolbar setDrawerAndToolbar(String name) {
        Toolbar appbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(appbar);
        getSupportActionBar().setTitle("");
        final LinearLayout drawer_button = (LinearLayout) findViewById(R.id.drawerButton);
        notification_layout = (RelativeLayout) findViewById(R.id.notification_layout);
        TextView notification_quantity = (TextView) findViewById(R.id.notification_quantity);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                if (mDrawerLayout != null && !mDrawerLayout.isDrawerOpen(Gravity.RIGHT))
                    mDrawerLayout.openDrawer(Gravity.RIGHT);
                else if (mDrawerLayout != null)
                    mDrawerLayout.closeDrawers();
            }
        });
        DrawerFragment fragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);
        fragment.setUp(mDrawerLayout);
        return appbar;
    }

    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
