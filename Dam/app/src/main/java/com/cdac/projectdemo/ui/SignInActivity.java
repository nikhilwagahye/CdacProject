package com.cdac.projectdemo.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmailId;
    private EditText editTextPassword;
    private Button buttonSignIn;
    private LinearLayout linearLayoutSignUpForAccount;
    private DatabaseReference database;
    private List<User> list = new ArrayList<User>();

    boolean flagForSuccessfulLogin;
    private ProgressDialog progressDialog;
    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editTextEmailId = (EditText) findViewById(R.id.editTextEmailId);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(this);

        imageViewBack=(ImageView)findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToLanding();
            }
        });

        linearLayoutSignUpForAccount = (LinearLayout) findViewById(R.id.linearLayoutSignUpForAccount);
        linearLayoutSignUpForAccount.setOnClickListener(this);

        SharedPreferenceManager.setApplicationContext(SignInActivity.this);


        database = FirebaseDatabase.getInstance().getReference();

        // get all users to check user trying to login.
        database.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    User user = noteDataSnapshot.getValue(User.class);
                    list.add(user);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Error", "Error");
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSignIn:
                if (editTextEmailId.getText().toString().length() > 0) {
                    if (isValidEmailAddress(editTextEmailId.getText().toString().trim())) {
                        if (editTextPassword.getText().toString().length() > 0 && editTextPassword.getText().toString().length() <= 6) {
                            progressDialog = new ProgressDialog(SignInActivity.this);
                            progressDialog.setMessage("Please wait...");
                            progressDialog.setCancelable(false);
                            progressDialog.show();
                            if (list != null && list.size() > 0) {
                                for (int i = 0; i < list.size(); i++) {
                                    User userFromServer = list.get(i);
                                    if (userFromServer.getEmailId().equalsIgnoreCase(editTextEmailId.getText().toString()) &&
                                            userFromServer.getPassword().equalsIgnoreCase(editTextPassword.getText().toString())) {
                                        // Email Id and Password matched
                                        // Login the user
                                        flagForSuccessfulLogin = true;
                                        handleLogin(userFromServer);
                                        progressDialog.cancel();
                                        break;
                                    }
                                }
                            }

                            if (flagForSuccessfulLogin == false) {
                                progressDialog.cancel();
                                Toast.makeText(SignInActivity.this, "User Name and Password does not exists. Please sign up.", Toast.LENGTH_LONG).show();
                            }

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

    private void handleLogin(User userFromServer) {
        SharedPreferenceManager.storeUserObjectInSharedPreference(userFromServer);
        Intent intent = new Intent(SignInActivity.this, HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    @Override
    public void onBackPressed() {
        navigateToLanding();
    }

    private void navigateToLanding() {
        Intent intent = new Intent(SignInActivity.this, LandingPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
