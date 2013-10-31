package com.threedigital.weatherme;

import android.app.WallpaperManager;

/**
 * Created by 3digital on 9/6/13.
 */
public class MyData {

    private static Double mCurrentTemp;
    private static Double mWindSpeed;
    private static Double mPercipitation;
    private static String mTodaysStatus;
    private static Object mIcon;
    private WallpaperManager resources;


    public static Double getmCurrentTemp() {
        return mCurrentTemp;
    }

    public void setmCurrentTemp(Double mCurrentTemp) {
        this.mCurrentTemp = mCurrentTemp;
    }

    public static Double getmWindSpeed() {
        return mWindSpeed;
    }

    public void setmWindSpeed(Double mWindSpeed) {
        this.mWindSpeed = mWindSpeed;
    }

    public static Double getmPercipitation() {
        return mPercipitation;
    }

    public void setmPercipitation(Double mPercipitation) {
        this.mPercipitation = mPercipitation;
    }

    public static String getmTodaysStatus() {
        return mTodaysStatus;
    }

    public void setmTodaysStatus(String mTodaysStatus) {
        this.mTodaysStatus = mTodaysStatus;
    }




    public char[] setmTodaysStatus() {
        return new char[0];
    }




    public void setmIcon(Object mIcon) {
        this.mIcon = mIcon;
    }

    public Object getmIcon() {
        return mIcon;
    }

    public WallpaperManager getResources() {
        return resources;
    }
}

