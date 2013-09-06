package com.threedigital.weatherme;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * Created by 3digital on 8/30/13.
 */
public class UserLocationManager implements LocationListener {

    private DisplayWeatherActivity myFriendDisplayActivity;
    private PopulateDataTask myFriendPopulateDataTask;
    private LocationManager lm;
//    public UserLocationManager(DisplayWeatherActivity a) {
//        myWeatherDisplayActivity = a;


    public UserLocationManager (PopulateDataTask x){
        myFriendPopulateDataTask = x;
        lm =  (LocationManager)myFriendPopulateDataTask.myFriendDisplayWeatherActivity.getSystemService(Context.LOCATION_SERVICE);
        try {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0 , 0, this);


        }catch (Exception e) {
            e.printStackTrace();


        }
    }






    @Override
    public void onLocationChanged(Location loc) {

        lm.removeUpdates(this);
        myFriendPopulateDataTask.receiveUserLocation(loc);


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }



}

