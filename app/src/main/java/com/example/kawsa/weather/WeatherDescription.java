package com.example.kawsa.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherDescription extends AppCompatActivity {
   private ImageView imageView;
    private TextView textHeader,textDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_description);

        imageView = findViewById(R.id.desc_image_id);
        textHeader = findViewById(R.id.desc_header_id);
        textDesc = findViewById(R.id.desc_text_id);

   Bundle bundle = getIntent().getExtras();



        if (bundle != null){
            String weatherName = bundle.getString("name");
            String weatherDesc = bundle.getString("desc");
            int icon = bundle.getInt("icon");
            textHeader.setText(weatherName);
            imageView.setImageResource(icon);
            textDesc.setText(weatherDesc);
        }

    }
}
