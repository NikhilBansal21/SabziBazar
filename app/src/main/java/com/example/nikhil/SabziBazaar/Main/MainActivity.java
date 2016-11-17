package com.example.nikhil.SabziBazaar.Main;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nikhil.SabziBazaar.Main.adapter;
import com.example.nikhil.SabziBazaar.R;
import com.example.nikhil.SabziBazaar.Main.Corn;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    adapter ad;
    TextView tv;
    View updateview;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        tv = (TextView) findViewById(R.id.textViewwwwwwwwww);

        i =new Intent(MainActivity.this,Corn.class);

        final String[] heading = {"Corn", "Lattuga", "Peas", "Potato", "Tomato", "Capsicum","Artichoke","Carrot","Cucumber","Broccoli"};
        //integer
        final String[] Subheading = {"60", "70", "80", "100", "120", "200","150","125","130","145"};
        final int[] images = {R.drawable.corn, R.drawable.lattuga, R.drawable.peas, R.drawable.potato,
                R.drawable.tomato, R.drawable.capsicum,R.drawable.artichoke,R.drawable.carrot,R.drawable.cucumber,R.drawable.broccoli};


        ad = new adapter(this, heading, Subheading, images);
        listView.setAdapter(ad);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:

                        i.putExtra("headingkey",heading[position]);
                        i.putExtra("subheadingkey",Subheading[position]);
                        i.putExtra("imagekey",images[position]);
                        startActivity(i);
                        break;
                    case 1:
                        i.putExtra("headingkey",heading[position]);
                        i.putExtra("subheadingkey",Subheading[position]);
                        i.putExtra("imagekey",images[position]);
                        startActivity(i);
                        break;
                    case 2:
                        i.putExtra("headingkey",heading[position]);
                        i.putExtra("subheadingkey",Subheading[position]);
                        i.putExtra("imagekey",images[position]);
                        startActivity(i);
                        break;

                    case 3:
                        i.putExtra("headingkey",heading[position]);
                        i.putExtra("subheadingkey",Subheading[position]);
                        i.putExtra("imagekey",images[position]);
                        startActivity(i);
                        break;
                    case 4:

                        i.putExtra("headingkey",heading[position]);
                        i.putExtra("subheadingkey",Subheading[position]);
                        i.putExtra("imagekey",images[position]);
                        startActivity(i);
                        break;
                    case 5:
                        i.putExtra("headingkey",heading[position]);
                        i.putExtra("subheadingkey",Subheading[position]);
                        i.putExtra("imagekey",images[position]);
                        startActivity(i);
                        break;
                    case 6:
                        i.putExtra("headingkey",heading[position]);
                        i.putExtra("subheadingkey",Subheading[position]);
                        i.putExtra("imagekey",images[position]);
                        startActivity(i);
                        break;
                    case 7:
                        i.putExtra("headingkey",heading[position]);
                        i.putExtra("subheadingkey",Subheading[position]);
                        i.putExtra("imagekey",images[position]);
                        startActivity(i);
                        break;
//
                    case 8:

                        i.putExtra("headingkey",heading[position]);
                        i.putExtra("subheadingkey",Subheading[position]);
                        i.putExtra("imagekey",images[position]);
                        startActivity(i);
                        break;
                    case 9:
                        i.putExtra("headingkey",heading[position]);
                        i.putExtra("subheadingkey",Subheading[position]);
                        i.putExtra("imagekey",images[position]);
                        startActivity(i);
                        break;

                }


            }
        });



    }
}
