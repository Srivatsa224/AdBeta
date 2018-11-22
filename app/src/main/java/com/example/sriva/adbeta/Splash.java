package com.example.sriva.adbeta;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends Activity {
    //timer for Splash screen
    private  static int SPLASH_TIME_OUT=10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Splash.this,DualLogin.class);

                startActivity(i);
                finish();
            }

        },SPLASH_TIME_OUT);
    }
}
