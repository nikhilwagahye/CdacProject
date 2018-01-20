package com.cdac.projectdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.model.User;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmailId;
    private EditText editTextPassword;
    private Button buttonSignIn;
    private LinearLayout linearLayoutSignUpForAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editTextEmailId = (EditText) findViewById(R.id.editTextEmailId);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(this);

        linearLayoutSignUpForAccount = (LinearLayout) findViewById(R.id.linearLayoutSignUpForAccount);
        linearLayoutSignUpForAccount.setOnClickListener(this);

        SharedPreferenceManager.setApplicationContext(SignInActivity.this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSignIn:
                if (editTextEmailId.getText().toString().length() > 0) {
                    if (isValidEmailAddress(editTextEmailId.getText().toString().trim())) {
                        if (editTextPassword.getText().toString().length() > 0 && editTextPassword.getText().toString().length() <= 6) {

                            User user = new User();
                            user.setUserId("1");
                            user.setEmailId(editTextEmailId.getText().toString());
                            user.setPassword(editTextPassword.getText().toString());
                            user.setDateOfBirth("22/04/1993");
                            user.setFirstName("Pallavi");
                            user.setLastName("Waghaye");

                            SharedPreferenceManager.storeUserObjectInSharedPreference(user);

                            Intent intent = new Intent(SignInActivity.this, HomePageActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        } else {
                            editTextPassword.setError("Password must be greater than 6 characters");
                        }
                    } else {
                        editTextEmailId.setError("Email Id must be valid");
                    }
                } else {
                    editTextEmailId.setError("Email Id Can't be empty");
                }
                break;


            case R.id.linearLayoutSignUpForAccount:
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
