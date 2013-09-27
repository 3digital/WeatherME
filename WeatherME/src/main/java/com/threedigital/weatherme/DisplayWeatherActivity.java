package com.threedigital.weatherme;


import android.app.Activity;
import android.content.Intent;
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

        int[] Images = new int[]{

            R.drawable.mostlycloudy, R.drawable.windy,
            R.drawable.mostlysunny,R.drawable.overcast,
            R.drawable.thundershowers,
        };

//        TempImageView.setImageDrawable(Images);

        ImageButton bikeButton = (ImageButton) findViewById(R.id.bikeButton);
        bikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), BikeActivity.class);
            intent.putExtra("temperature", String.valueOf(Math.round(Double.valueOf(data.getmCurrentTemp())) + "\u00b0"));
            intent.putExtra("precipProbability",String.valueOf(Math.round(Double.valueOf(data.getmPercipitation())) + "\u00b0"));
            intent.putExtra("windSpeed", String.valueOf(Math.round(Double.valueOf(data.getmWindSpeed()))));
            intent.putExtra("summary", String.valueOf(data.getmTodaysStatus()));
                startActivity(intent);




            }
        });
        //dont let them click until i have data.
//        bikeButton.setEnabled(false);


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


