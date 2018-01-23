package com.cdac.projectdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cdac.projectdemo.R;




public class LandingPageActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout linearLayoutSkipRegistration;
    private Button buttonAlreadyCustomer;
    private Button buttonCreateAcccount;
    private Button firebaseButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayoutSkipRegistration = (LinearLayout) findViewById(R.id.linearLayoutSkipRegistration);
        linearLayoutSkipRegistration.setOnClickListener(this);
        buttonAlreadyCustomer = (Button) findViewById(R.id.buttonAlreadyCustomer);
        buttonAlreadyCustomer.setOnClickListener(this);
        buttonCreateAcccount = (Button) findViewById(R.id.buttonCreateAcccount);
        buttonCreateAcccount.setOnClickListener(this);
        firebaseButton=(Button)findViewById(R.id.firebaseButton);
        firebaseButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.linearLayoutSkipRegistration:
                Intent intent = new Intent(LandingPageActivity.this, HomePageActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonAlreadyCustomer:
                Intent intent1 = new Intent(LandingPageActivity.this, SignInActivity.class);
                startActivity(intent1);
                break;

            case R.id.buttonCreateAcccount:
                Intent intent2 = new Intent(LandingPageActivity.this, SignUpActivity.class);
                startActivity(intent2);
                break;
            case R.id.firebaseButton:
                Intent intent3 = new Intent(LandingPageActivity.this, FirebaseServerActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
