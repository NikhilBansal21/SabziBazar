package com.example.nikhil.SabziBazaar.Main;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikhil.SabziBazaar.R;


public class adapter extends BaseAdapter {
    String[] data;
    String[] data1;
    int[] images;
    Context context;
    LayoutInflater inflater;


    public adapter(Context context,String[] s,String[] s1,int[] img)

    {

        this.context=context;
        this.data=s;
        this.data1=s1;
        this.images=img;
        inflater= ((Activity)context).getLayoutInflater();
    }


    @Override
    public int getCount() {
        return data.length;
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


        convertView=inflater.inflate(R.layout.customactivity,null);
        TextView tv= (TextView) convertView.findViewById(R.id.textView);
        TextView tv1= (TextView) convertView.findViewById(R.id.textView2);
        ImageView imgv= (ImageView) convertView.findViewById(R.id.imageView);

        tv.setText(data[position]);
        tv1.setText(data1[position]);
        imgv.setImageResource(images[position]);

        return convertView;
    }
}
