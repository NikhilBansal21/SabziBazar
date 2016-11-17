package com.example.nikhil.SabziBazaar.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.nikhil.SabziBazaar.R;
import com.example.nikhil.SabziBazaar.Database.DatabaseHelper;

/**
 * Created by nikhilbansal on 15/08/16.
 */
public class splash_screen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    DatabaseHelper.getInstance(getApplicationContext()).delete();
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(splash_screen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
}
