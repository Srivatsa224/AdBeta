package com.example.sriva.adbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DualLogin extends AppCompatActivity {
    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_login);
        b1=(Button)findViewById(R.id.buttonSignup);
        b2=(Button)findViewById(R.id.buttonSignup2);
        // Setting onClick Event for Dealer Button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DualLogin.this, DealerReg.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DualLogin.this, BrandSuccess.class);
                startActivity(i);
            }
        });

    }


}
