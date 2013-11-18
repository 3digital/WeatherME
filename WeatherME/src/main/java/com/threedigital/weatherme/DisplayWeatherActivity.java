package com.threedigital.weatherme;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.threedigital.weatherme.MyData.getmIcon;
import static com.threedigital.weatherme.MyData.getmTodaysStatus;
import static com.threedigital.weatherme.R.drawable;
import static com.threedigital.weatherme.R.layout.activity_main;
import static java.lang.String.valueOf;

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
        setContentView(activity_main);
        goGetWeatherData();


        ActionBar bar = getActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));



        ImageButton bikeButton = (ImageButton) findViewById(R.id.bikeButton);
        bikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), BikeActivity.class);
            intent.putExtra("temperature", valueOf(Math.round(MyData.getmCurrentTemp()) + "\u00b0"));
            intent.putExtra("precipProbability", valueOf(Math.round(MyData.getmPercipitation()) + "%"));
            intent.putExtra("windSpeed", valueOf(Math.round(MyData.getmWindSpeed())));
            intent.putExtra("summary", valueOf(getmTodaysStatus()));


                startActivity(intent);


            }
        });

        }
    public Drawable findmIcon(String s) {

        Drawable d;

        if(s.equals("clear-night")) {
            d = getResources().getDrawable(drawable.clear_night);
        }else if(s.equals("rain")) {
            d = getResources().getDrawable(drawable.rain);
        }else if(s.equals("snow")) {
            d = getResources().getDrawable(drawable.flurries);
        }else if(s.equals("sleet")) {
            d = getResources().getDrawable(drawable.sleet);
        }else if(s.equals("wind")) {
            d = getResources().getDrawable(drawable.windy);
        }else if(s.equals("fog")) {
            d = getResources().getDrawable(drawable.foggy);
        }else if(s.equals("cloudy")) {
            d = getResources().getDrawable(drawable.cloudy);
        }else if(s.equals("partly-cloudy-day")) {
            d = getResources().getDrawable(drawable.mostlycloudy);
        }else if(s.equals("partly-cloudy-night")) {
            d = getResources().getDrawable(drawable.partly_cloudy_night);

        }else {
            d = getResources().getDrawable(drawable.clear);
        }

        return d;
    }





    private void goGetWeatherData() {
        myFriendPopulateDataTask = new PopulateDataTask(this);



    }

    public void receiveWeatherData() {

        ImageView imageView = (ImageView)findViewById(R.id.TempImageView);
        imageView.setImageDrawable(findmIcon(String.valueOf(getmIcon())));

        TextView textView = (TextView) findViewById(R.id.TempView);
        textView.setText(valueOf(Math.round(MyData.getmCurrentTemp()) + "\u00b0"));

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(valueOf(getmTodaysStatus()));
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



}


