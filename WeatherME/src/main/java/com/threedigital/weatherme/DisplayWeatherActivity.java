package com.threedigital.weatherme;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayWeatherActivity extends Activity {
    public ImageButton bikeButton;
    public TextView textView;
    public ImageView TempImageView;
    public TextView textView2;
    public MyData data;


    public UserLocationManager mMyPersonalLocationManager;
    public ForecastAPIRequestObject myWeatherDataPopulator;
    public PopulateDataTask myFriendPopulateDataTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goGetWeatherData();



        ImageButton bikeButton = (ImageButton) findViewById(R.id.bikeButton);
        bikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), BikeActivity.class);
            intent.putExtra("temperature", String.valueOf(Math.round(Double.valueOf(data.getmCurrentTemp())) + "\u00b0"));
            intent.putExtra("precipProbability",String.valueOf(Math.round(Double.valueOf(data.getmPercipitation())) + "%"));
            intent.putExtra("windSpeed", String.valueOf(Math.round(Double.valueOf(data.getmWindSpeed()))));
            intent.putExtra("summary", String.valueOf(data.getmTodaysStatus()));
                startActivity(intent);




            }
        });
        //dont let them click until i have data.
//        bikeButton.setEnabled(false);


        }


    public Drawable findIcon(String input) {
        Drawable d;
        if(input.equals("clear-day")) {
            d = getResources().getDrawable(R.drawable.sunny);
        }else if(input.equals("clear-night")) {
            d = getResources().getDrawable(R.drawable.clear_night);
        }else if(input.equals("rain")) {
            d = getResources().getDrawable(R.drawable.rain);
        }else if(input.equals("snow")) {
            d = getResources().getDrawable(R.drawable.flurries);
        }else if(input.equals("sleet")) {
            d = getResources().getDrawable(R.drawable.sleet);
        }else if(input.equals("wind")) {
            d = getResources().getDrawable(R.drawable.windy);
        }else if(input.equals("fog")) {
            d = getResources().getDrawable(R.drawable.foggy);
        }else if(input.equals("cloudy")) {
            d = getResources().getDrawable(R.drawable.cloudy);
        }else if(input.equals("partly-cloudy-day")) {
            d = getResources().getDrawable(R.drawable.mostlycloudy);
        }else if(input.equals("partly-cloudy-night")) {
            d = getResources().getDrawable(R.drawable.partly_cloudy_night);
        }else {
            d = getResources().getDrawable(R.drawable.overcast);
        }
        return d;
    }



    private void goGetWeatherData() {
        myFriendPopulateDataTask = new PopulateDataTask(this);



    }

    public void receiveWeatherData(MyData data) {

        TextView textView = (TextView) findViewById(R.id.TempView);
        textView.setText(String.valueOf(Math.round(Double.valueOf(data.getmCurrentTemp())) + "\u00b0"));

       
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(String.valueOf(data.getmTodaysStatus()));



        Log.e("Look at my data", data.getmTodaysStatus());
//       bikeButton.setEnabled(true);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



}


