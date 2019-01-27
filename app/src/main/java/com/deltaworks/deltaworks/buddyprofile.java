package com.deltaworks.deltaworks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.Toast;

public class buddyprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddyprofile);
        final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.6F);

        ImageButton buddybutton = (ImageButton) findViewById(R.id.buddybutton);
        buddybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Toast.makeText(getApplicationContext(),"Your request has been sent!" ,  Toast.LENGTH_SHORT).show();
            }
        });
    }
}
