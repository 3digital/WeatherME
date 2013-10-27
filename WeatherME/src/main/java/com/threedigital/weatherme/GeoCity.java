package com.threedigital.weatherme;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

/**
 * Created by 3digital on 9/28/13.
 */
public class GeoCity  {

    private static Double latitude;
    private static Double longitude;
    private static String API_GEONAMES_USERNAME;

    protected int status;
    private HttpResponse response;
    protected JSONObject data;

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    private class FetchDataAsync extends AsyncTask<String, Void, HttpResponse> {


        AndroidHttpClient client;

        @Override
        protected HttpResponse doInBackground(String... urls) {
            String link = urls[0];
            HttpGet request = new HttpGet(link);
            client = AndroidHttpClient.newInstance("Android");
            HttpResponse response = null;

            try {
                response = client.execute(request);
                if( response.getStatusLine().getStatusCode() == HttpStatus.SC_OK ) {
                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                    response.getEntity().writeTo(output);
                    output.close();

                    String result = output.toString();

                    data = new JSONObject(result);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            client.close();
            return response;
        }

        protected void onPostExecute(HttpResponse res){
            if (res != null) {
                status = res.getStatusLine().getStatusCode();
                response = res;
            }
        }
    }

    public GeoCity(Double latitude, Double longitude, String API_GEONAMES_USERNAME){
        GeoCity.latitude = latitude;
        GeoCity.longitude = longitude;
        GeoCity.API_GEONAMES_USERNAME = API_GEONAMES_USERNAME;

        if (latitude != 0 && longitude != 0) {
            String geoNamesUrl = buildGeoNamesUrl(latitude, longitude);
            new FetchDataAsync().execute(geoNamesUrl);
        }
    }

    private String buildGeoNamesUrl(Double latitude, Double longitude) {


        String API_URL = "http://api.geonames.org/findNearbyPlaceNameJSON?";
        return API_URL + "lat=" + latitude.toString() + "&lng=" + longitude.toString() + "&username=" + API_GEONAMES_USERNAME;
    }

    public HttpResponse getGeoNamesResponse() {
        return response;
    }

    public JSONObject getGeoNamesData() {
        return data;
    }

    public int getGeoNamesStatus() {
        return status;
    }

}
