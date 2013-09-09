package com.threedigital.weatherme;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import static java.lang.String.valueOf;

/**
 * Created by 3digital on 9/9/13.
 */
public class weather extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
    }

    public void receiveWeatherData(MyData data) {
        TextView textView = (TextView) findViewById(R.id.TempView);
        textView.setText((valueOf(data.getmCurrentTemp())));
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(valueOf(data.getmTodaysStatus()));

    }
}
