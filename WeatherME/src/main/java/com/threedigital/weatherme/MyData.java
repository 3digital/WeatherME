package com.threedigital.weatherme;

import android.app.WallpaperManager;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/**
 * Created by 3digital on 9/6/13.
 */
public class MyData extends Drawable {

    private static Double mCurrentTemp;
    private static Double mWindSpeed;
    private static Double mPercipitation;
    private static String mTodaysStatus;
    private static String mIcon;
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

    public static String getmIcon(){return mIcon;}

    public void  setmIcon(String mIcon){this. mIcon = mIcon;}









    public WallpaperManager getResources() {
        return resources;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}

