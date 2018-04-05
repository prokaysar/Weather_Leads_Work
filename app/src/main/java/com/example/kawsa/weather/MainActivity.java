package com.example.kawsa.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private int[] weatherIcon ={
        R.mipmap.clouds,
                R.mipmap.lightning,
                R.mipmap.rain,
                R.mipmap.rainy_night,
                R.mipmap.snow,
                R.mipmap.storm,
                R.mipmap.sun
    };
    private String[] weather;
    private String[] weatherDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);

        weather = getResources().getStringArray(R.array.weatherName);
        weatherDesc = getResources().getStringArray(R.array.weatherDesc);

        Weather adapter = new Weather(this,weather,weatherIcon);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,WeatherDescription.class);
                intent.putExtra("icon",weatherIcon[position]);
                intent.putExtra("name",weather[position]);
                intent.putExtra("desc",weatherDesc[position]);
                startActivity(intent);
            }
        });

    }
}
