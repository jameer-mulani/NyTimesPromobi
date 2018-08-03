package com.assigment.nytimespromobi.app;

import android.app.Application;

import com.assigment.nytimespromobi.util.PreferenceUtil;

public class NYtimeApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PreferenceUtil.setStoryApiKey(this, "90eafe1e4500413e9423e6636018dd71");
    }
}
