package com.cdac.projectdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cdac.projectdemo.R;

public class SuccessPageActivity extends AppCompatActivity {

    private Button shopAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_page);
        shopAgain = (Button) findViewById(R.id.shopAgain);
        shopAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToShopByCategory();
            }
        });
    }

    private void navigateToShopByCategory() {
        Intent intent = new Intent(SuccessPageActivity.this, ShopByCategoryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SuccessPageActivity.this, HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
