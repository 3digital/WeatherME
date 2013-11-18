package com.threedigital.weatherme;

import android.app.WallpaperManager;
import android.location.Location;

/**
 * Created by 3digital on 9/6/13.
 */
public class ForecastAPIRequestObject {

    private static Double mLatitude;
    private static Double mLongitude;
    private String mURL ="https://api.forecast.io/forecast/";
    private String mAPI_KEY="eaf82b417a09d7a708e8c90225cc7926";
    private WallpaperManager resources;

    public ForecastAPIRequestObject(Location myLocation, WallpaperManager resources) {
        this.resources = resources;
        this.setMyLocation(myLocation);
    }


    public void setMyLocation(Location myLocation) {
        mLatitude = myLocation.getLatitude();
        mLongitude = myLocation.getLongitude();
    }

    public String getAssembledUrl() {
        String myURL = mURL + mAPI_KEY + "/" + mLatitude.toString() + "," + mLongitude.toString();
        return myURL;
    }

    public Double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(Double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(Double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public String getmURL() {
        return mURL;
    }

    public void setmURL(String mURL) {
        this.mURL = mURL;
    }

    public String getmAPI_KEY() {
        return mAPI_KEY;
    }

    public void setmAPI_KEY(String mAPI_KEY) {
        this.mAPI_KEY = mAPI_KEY;
    }

    public void execute(String location) {

    }

    public String getAPI_GEONAMES_USERNAME() {
        String API_GEONAMES_USERNAME = "3digital";
        return API_GEONAMES_USERNAME;
    }



    public WallpaperManager getResources() {
        return resources;
    }
}

