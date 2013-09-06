package com.threedigital.weatherme;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayWeatherActivity extends Activity {
    public ImageButton bikeButton;
    public Button updatebutton;
    public ListView listView;
    public TextView textView;
    public ImageView imageView;

    public MyData data;


    public UserLocationManager mMyPersonalLocationManager;
    public ForecastAPIRequestObject myWeatherDataPopulator;
    public PopulateDataTask myFriendPopulateDataTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //goGetUserLocation();
        goGetWeatherData();

        ImageButton bikeButton = (ImageButton) findViewById(R.id.bikeButton);
        bikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setContentView(R.layout.weather);

            }
        });



    }



    {
}


    private void goGetWeatherData() {
        myFriendPopulateDataTask = new PopulateDataTask(this);

    }

    public void receiveWeatherData(MyData data) {
       TextView textView = (TextView) findViewById(R.id.TempView);
        textView.setText((String.valueOf(data.getmCurrentTemp())));




        Log.e("Lookatmydata", data.getmTodaysStatus());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}


