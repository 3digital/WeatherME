package com.threedigital.weatherme;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * Created by 3digital on 8/30/13.
 */
public class UserLocationManager extends DisplayWeatherActivity implements LocationListener {

    private DisplayWeatherActivity myFriendDisplayActivity;
    private PopulateDataTask myFriendPopulateDataTask;
    private LocationManager lm;
//    public UserLocationManager(DisplayWeatherActivity a) {
//        myWeatherDisplayActivity = a;


    public UserLocationManager(PopulateDataTask x){
        myFriendPopulateDataTask = x;
        lm = (LocationManager)myFriendPopulateDataTask.myFriendDisplayWeatherActivity.getSystemService(Context.LOCATION_SERVICE);

        try {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0 , 0, this);
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0, 0, this);
            lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);


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
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    @Override
    public Drawable findIcon(String input) {
        return super.findIcon(input);
    }
}

