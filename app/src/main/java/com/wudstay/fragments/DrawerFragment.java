package com.wudstay.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wudstay.R;
import com.wudstay.activity.HomeActivity;
import com.wudstay.util.WudStayConstants;


public class DrawerFragment extends Fragment {

    public ActionBarDrawerToggle mDrawerToggle;
    private int selectedPos = -1;
    private DrawerLayout drawerlayout;
    private TextView notification_title, download_title;
    private TextView logout_title, userName, myAcc, cart_count_drawer;
    private ImageView userImage;
    private LinearLayout talk, name_text_layout, dear_user_text_layout;

    public DrawerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.left_slide_list_layout, container, false);

        selectedPos = -1;

        dear_user_text_layout = (LinearLayout) v.findViewById(R.id.dear_user_text_layout);
        final LinearLayout home = (LinearLayout) v.findViewById(R.id.home_menu_option);
        final LinearLayout notification = (LinearLayout) v.findViewById(R.id.notification_menu_option);
        final LinearLayout payment = (LinearLayout) v.findViewById(R.id.payment_menu_option);
        talk = (LinearLayout) v.findViewById(R.id.talk_menu_option);
        name_text_layout = (LinearLayout) v.findViewById(R.id.name_text_layout);
        final LinearLayout settings = (LinearLayout) v.findViewById(R.id.settings_menu_option);
        final LinearLayout complaint = (LinearLayout) v.findViewById(R.id.complaint_menu_option);

        ImageView home_icon = (ImageView) v.findViewById(R.id.home_icon);
        ImageView talk_icon = (ImageView) v.findViewById(R.id.talk_icon);
        ImageView notification_icon = (ImageView) v.findViewById(R.id.notification_icon);
        ImageView payment_icon = (ImageView) v.findViewById(R.id.payment_icon);
        ImageView complaint_icon = (ImageView) v.findViewById(R.id.complaint_icon);
        ImageView settings_icon = (ImageView) v.findViewById(R.id.settings_icon);

        TextView home_title = (TextView) v.findViewById(R.id.home_title);
        TextView talk_title = (TextView) v.findViewById(R.id.talk_title);
        TextView notification_title = (TextView) v.findViewById(R.id.notification_title);
        notification_title = (TextView) v.findViewById(R.id.notification_title);
        TextView payment_title = (TextView) v.findViewById(R.id.payment_title);
        TextView complaint_title = (TextView) v.findViewById(R.id.complaint_title);
        TextView settings_title = (TextView) v.findViewById(R.id.settings_title);


        userName = (TextView) v.findViewById(R.id.home_menu_UserName);
        myAcc = (TextView) v.findViewById(R.id.home_menu_MyAcc);
        userImage = (ImageView) v.findViewById(R.id.home_menu_UserImage);


        dear_user_text_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }

    @SuppressLint("NewApi")
    public void setUp(final DrawerLayout drawerlayout) {

        this.drawerlayout = drawerlayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerlayout, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @SuppressLint("NewApi")
            @Override
            public void onDrawerClosed(View drawerView) {
                ActivityManager am = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
                ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
                super.onDrawerClosed(drawerView);
                if (selectedPos != -1) {
                    switch (selectedPos) {
                        case 0:
                            if (!cn.getShortClassName().equals(".activity.HomeActivity")) {
                                navigateToHome();
                            } else {
                                drawerlayout.closeDrawers();
                            }
                            break;
                        case 1:
                            if (!cn.getShortClassName().equals(".activity.AvailOffersActivity")) {
                                navigateToOffers();
                            } else {
                                drawerlayout.closeDrawers();
                            }
                            break;
                        case 2:
                            if (!cn.getShortClassName().equals(".activity.CartActivity")) {
                                navigateToCart();
                            } else {
                                drawerlayout.closeDrawers();
                            }
                            break;
                        case 3:
                            if (!cn.getShortClassName().equals(".activity.DownloadManagerActivity")) {
                                navigateToDownloads();
                            } else {
                                drawerlayout.closeDrawers();
                            }
                            break;
                        case 4:
                            if (!cn.getShortClassName().equals(".activity.NotificationsActivity")) {
                                navigateToNotifications();
                            } else {
                                drawerlayout.closeDrawers();
                            }
                            break;
                        case 5:
                            if (!cn.getShortClassName().equals(".activity.GeneralActivity")) {
                                navigateToGeneralScreen();
                            } else {
                                drawerlayout.closeDrawers();
                            }
                            break;
                        case 6:
//                            if (!cn.getShortClassName().equals(".activity.AboutUsActivity")) {
                            navigateToContactUs();
//                            } else {
//                                drawerlayout.closeDrawers();
//                            }
                            break;
                        case 7:
                            if (!cn.getShortClassName().equals(".activity.SettingsActivity")) {
                                navigateToSettings();
                            } else {
                                drawerlayout.closeDrawers();
                            }
                            break;
                        case 8:
                            logout();
                            break;
                        default:
                            break;
                    }
                    selectedPos = -1;
                }
            }
        };

        drawerlayout.setDrawerListener(mDrawerToggle);

    }

    public String getFromPrefs(String key) {
        SharedPreferences prefs = getActivity().getSharedPreferences(WudStayConstants.PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getString(key, WudStayConstants.DEFAULT_VALUE);
    }

    private void navigateToHome() {
        drawerlayout.closeDrawers();
        for (int i = 0; i < WudStayConstants.ACTIVITIES.size(); i++) {
            if (WudStayConstants.ACTIVITIES.get(i) != null)
                WudStayConstants.ACTIVITIES.get(i).finish();
        }
        getActivity().finish();
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }

    private void navigateToGeneralScreen() {
        drawerlayout.closeDrawers();
        removeActivity("com.saregama.bulkstore.activity.GeneralActivity");
    }

    private void navigateToCart() {
        drawerlayout.closeDrawers();
        removeActivity("com.saregama.bulkstore.activity.CartActivity");
    }

    private void navigateToNotifications() {
        drawerlayout.closeDrawers();
        removeActivity("com.saregama.bulkstore.activity.NotificationsActivity");
    }

    private void navigateToContactUs() {
        drawerlayout.closeDrawers();
        removeActivity("com.saregama.bulkstore.activity.AboutUsActivity");
    }

    private void navigateToOffers() {
        drawerlayout.closeDrawers();
        removeActivity("com.saregama.bulkstore.activity.AvailOffersActivity");
    }

    private void navigateToDownloads() {
        drawerlayout.closeDrawers();
        removeActivity("com.saregama.bulkstore.activity.DownloadManagerActivity");
    }

    private void navigateToSettings() {
        drawerlayout.closeDrawers();
            removeActivity("com.saregama.bulkstore.activity.SettingsActivity");
    }

    private void removeActivity(String activity) {
        for (int i = 0; i < WudStayConstants.ACTIVITIES.size(); i++) {
            if (WudStayConstants.ACTIVITIES.get(i) != null && WudStayConstants.ACTIVITIES.get(i).toString().contains(activity)) {
                WudStayConstants.ACTIVITIES.get(i).finish();
                WudStayConstants.ACTIVITIES.remove(i);
                break;
            }
        }
    }

    private void logout() {
        drawerlayout.closeDrawers();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
