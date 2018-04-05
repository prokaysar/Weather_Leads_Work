package com.example.kawsa.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Weather extends BaseAdapter {
    Context context;
    String[] weatherName;
    int[] weatherIcon;

    public Weather(Context context, String[] weatherName, int[] weatherIcon) {
        this.context = context;
        this.weatherName = weatherName;
        this.weatherIcon = weatherIcon;

    }

    @Override
    public int getCount() {
        return weatherName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_layout,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView weatherName = convertView.findViewById(R.id.textView);
        imageView.setImageResource(weatherIcon[position]);
        weatherName.setText(this.weatherName[position]);
        return convertView;
    }
}
