package com.deltaworks.deltaworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.Toast;

public class homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        ImageButton login = (ImageButton) findViewById(R.id.login);
        ImageButton signup = (ImageButton) findViewById(R.id.signup);
        ImageButton google= (ImageButton) findViewById(R.id.google);
        final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.6F); //AlphaAnimation can be used as a fader.

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent loginpage = new Intent(getApplicationContext(),login.class);
                startActivity(loginpage);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Toast.makeText(getApplicationContext(), "Coming soon!", Toast.LENGTH_SHORT).show();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Toast.makeText(getApplicationContext(), "Coming soon!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
