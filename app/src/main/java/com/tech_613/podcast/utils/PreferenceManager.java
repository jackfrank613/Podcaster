package com.tech_613.podcast.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager extends Application {

    private static PreferenceManager mInstance;
    static SharedPreferences preferences;
    static SharedPreferences.Editor prefEditor;
    public static int theme;
    public static boolean check=true;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        preferences=getSharedPreferences("Podcast", Context.MODE_PRIVATE);
        prefEditor=preferences.edit();
        prefEditor.commit();
    }

    public static synchronized PreferenceManager getInstance(){
        return mInstance;
    }

    public static void setThem(int them)
    {
        prefEditor.putInt("theme",them);
        prefEditor.commit();
    }
    public static int getThem()
    {
        return preferences.getInt("theme",-1);
    }


}
