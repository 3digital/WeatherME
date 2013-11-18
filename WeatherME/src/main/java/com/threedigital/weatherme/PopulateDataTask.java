package com.threedigital.weatherme;

import android.app.WallpaperManager;
import android.location.Location;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;


/**
 * Created by 3digital on 9/3/13.
 */
public class PopulateDataTask extends AsyncTask<ForecastAPIRequestObject,Integer, MyData> {
   public DisplayWeatherActivity myFriendDisplayWeatherActivity;
     private  MyData data;


     public PopulateDataTask(DisplayWeatherActivity activity) {
        //This is the constructor.
        super();
        myFriendDisplayWeatherActivity = activity;
         DisplayWeatherActivity myFriendDisplayActivity = null;
         new UserLocationManager(myFriendDisplayActivity, this);
     }


     public void receiveUserLocation(Location location) {
         WallpaperManager resources = null;
         ForecastAPIRequestObject thisAPIRequest = new ForecastAPIRequestObject(location, resources);
         thisAPIRequest.setMyLocation(location);
         this.execute(thisAPIRequest);

     }

    @Override
    protected MyData doInBackground(ForecastAPIRequestObject... forecastAPIRequestObjects) {
        data = new MyData();
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet h = new HttpGet(forecastAPIRequestObjects[0].getAssembledUrl());
            HttpResponse httpResponse = httpClient.execute(h);
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                httpResponse.getEntity().writeTo(out);
                out.close();
                String responseString = out.toString();



                JSONObject rootJSON = new JSONObject(responseString);
                JSONObject currentlyJSON = rootJSON.getJSONObject("currently");
                currentlyJSON.getDouble("windSpeed");


                data.setmIcon(currentlyJSON.getString("icon"));
                data.setmWindSpeed(currentlyJSON.getDouble("windSpeed"));
                data.setmCurrentTemp(currentlyJSON.getDouble("temperature"));
                data.setmPercipitation(currentlyJSON.getDouble("precipProbability"));
                data.setmTodaysStatus(currentlyJSON.getString("summary"));
                

                //Parse the data from the api using JSONObject methods
                //and put the data in the MyData object


            } else {
                httpResponse.getEntity().getContent().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }





        return data;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(MyData data) {
        //get the result of doInBackground as a MyData object
        super.onPostExecute(data);
        myFriendDisplayWeatherActivity.receiveWeatherData();


    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

     }


 }

