package com.deltaworks.deltaworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton login = (ImageButton) findViewById(R.id.logins);
        final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.6F); //AlphaAnimation can be used as a fader.

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent loginpage = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(loginpage);
            }
        });
    }
}
