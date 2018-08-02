package com.assigment.nytimespromobi.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtil {

    private static final String PREF_NAME = "APP_PREFS";
    private static final String STORY_API_KEY = "STORY_API_KEY";

    private PreferenceUtil() {

    }

    private static SharedPreferences getAppPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static String getStoryApiKey(Context context) {
        return getAppPreferences(context).getString(STORY_API_KEY, "");
    }

    public static void setStoryApiKey(Context context, String apiKey) {
        getAppPreferences(context).edit().putString(STORY_API_KEY, apiKey).commit();
    }

}
