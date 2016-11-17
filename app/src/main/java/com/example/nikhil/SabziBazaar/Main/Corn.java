package com.example.nikhil.SabziBazaar.Main;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikhil.SabziBazaar.Database.DatabaseHelper;
import com.example.nikhil.SabziBazaar.R;

/**
 * Created by nikhilbansal on 09/08/16.
 */
public class Corn extends Activity {
    private ImageView corn=null;
    private Button addcorn=null;
    private Button corncheck=null;
    DatabaseHelper mdb;
    private SQLiteDatabase db=null;
    private Cursor c=null;
    private byte[] img=null;
    private static final String DATABASE_NAME = "ImageDb.db";
    public static final int DATABASE_VERSION = 1;
    private TextView itemname;
    private TextView price;
    Intent in;
    String a,b;
    String producttext,pricetext="";
    String producttext1,pricetext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corn_lay);
        addcorn= (Button) findViewById(R.id.bask_corn);
        corncheck= (Button) findViewById(R.id.check_corn);
        corn= (ImageView) findViewById(R.id.corn);
        itemname= (TextView) findViewById(R.id.textViewname);
        price= (TextView) findViewById(R.id.textViewprice);

        String a="76";

        mdb=DatabaseHelper.getInstance(getApplicationContext());

        producttext=getIntent().getStringExtra("headingkey");
        pricetext=getIntent().getStringExtra("subheadingkey");
        final int b=getIntent().getIntExtra("imagekey",0);
        corn.setImageResource(b);

        itemname.setText(producttext);
        price.setText(pricetext);

        addcorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(addcorn==v){
                mdb.insertdata(producttext,pricetext);
                Toast.makeText(Corn.this, "Item added to the cart", Toast.LENGTH_SHORT).show();

            }

            }
        });


corncheck.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent i=new Intent(Corn.this,check_out.class);
        startActivity(i);

    }
});


    }

    @Override
    protected void onPause() {
        super.onPause();

        finish();


    }
}
