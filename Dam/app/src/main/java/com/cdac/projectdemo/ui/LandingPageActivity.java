package com.cdac.projectdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.cdac.projectdemo.R;

public class LandingPageActivity extends AppCompatActivity {

    private LinearLayout linearLayoutSkipRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayoutSkipRegistration = (LinearLayout) findViewById(R.id.linearLayoutSkipRegistration);
        linearLayoutSkipRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingPageActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });


    }
}
