package com.cdac.projectdemo.ui;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.adapters.CartAdapter;
import com.cdac.projectdemo.model.Cart;
import com.cdac.projectdemo.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextDOB;
    Calendar myCalendar;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmailId;
    private EditText editTextPassword;
    private Button buttonSignUp;
    private LinearLayout linearLayoutAccountAlready;
    private LinearLayout linearLayoutSkipRegistration;
    private EditText editTextAddress;
    private String userNode;
    private DatabaseReference database;
    private List<User> list = new ArrayList<User>();
    private ProgressDialog progressDialog;

    boolean flagForSignUp;
    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editTextDOB = (EditText) findViewById(R.id.editTextDOB);
        editTextDOB.setOnClickListener(this);
        myCalendar = Calendar.getInstance();


        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        editTextEmailId = (EditText) findViewById(R.id.editTextEmailId);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);

        imageViewBack=(ImageView)findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonSignUp.setOnClickListener(this);
        linearLayoutAccountAlready = (LinearLayout) findViewById(R.id.linearLayoutAccountAlready);
        linearLayoutSkipRegistration = (LinearLayout) findViewById(R.id.linearLayoutSkipRegistration);
        linearLayoutAccountAlready.setOnClickListener(this);
        linearLayoutSkipRegistration.setOnClickListener(this);

        SharedPreferenceManager.setApplicationContext(SignUpActivity.this);
        database = FirebaseDatabase.getInstance().getReference();

        // get all users to check user trying to register is already registered with email id or not.

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
            case R.id.editTextDOB:
                DatePickerDialog dlg = new DatePickerDialog(SignUpActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dlg.getDatePicker().setMaxDate(System.currentTimeMillis());
                dlg.show();
                break;


            case R.id.buttonSignUp:
                if (editTextFirstName.getText().toString().length() > 0) {
                    if (editTextLastName.getText().toString().length() > 0) {
                        if (editTextEmailId.getText().toString().length() > 0) {
                            if (isValidEmailAddress(editTextEmailId.getText().toString().trim())) {
                                if (editTextPassword.getText().toString().length() > 0 && editTextPassword.getText().toString().length() <= 6) {
                                    if (editTextAddress.getText().toString().length() > 0) {

                                        progressDialog = new ProgressDialog(SignUpActivity.this);
                                        progressDialog.setMessage("Please wait...");
                                        progressDialog.setCancelable(false);
                                        progressDialog.show();

                                        User user = new User();
                                        user.setUserId(System.currentTimeMillis() + "");
                                        user.setFirstName(editTextFirstName.getText().toString());
                                        user.setLastName(editTextLastName.getText().toString());
                                        user.setEmailId(editTextEmailId.getText().toString());
                                        user.setPassword(editTextPassword.getText().toString());
                                        user.setDateOfBirth(editTextDOB.getText().toString());
                                        user.setAddress(editTextAddress.getText().toString());

                                        // sending data to firebase

                                        if (list != null && list.size() > 0) {
                                            for (int i = 0; i < list.size(); i++) {
                                                User userFromServer = list.get(i);
                                                if (userFromServer.getEmailId().equalsIgnoreCase(user.getEmailId())) {
                                                    // User is already exists
                                                    flagForSignUp = false;
                                                    break;
                                                } else {
                                                    flagForSignUp = true;
                                                }
                                            }

                                            if (flagForSignUp == true) {
                                                progressDialog.cancel();
                                                createUserToFirebase(user);
                                                SharedPreferenceManager.storeUserObjectInSharedPreference(user);

                                                Intent intent = new Intent(SignUpActivity.this, HomePageActivity.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                                                startActivity(intent);
                                                finish();
                                            } else {
                                                progressDialog.cancel();
                                                Toast.makeText(SignUpActivity.this, "Email Id is already exists.", Toast.LENGTH_LONG).show();
                                            }

                                        } else {

                                            // No user is present in Firebase DB
                                            progressDialog.cancel();
                                            createUserToFirebase(user);
                                            SharedPreferenceManager.storeUserObjectInSharedPreference(user);

                                            Intent intent = new Intent(SignUpActivity.this, HomePageActivity.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                                            startActivity(intent);
                                            finish();


                                        }


                                    } else {
                                        editTextPassword.setError("Address field is empty");

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
                    } else {
                        editTextLastName.setError("Last Name Can't be empty");
                    }
                } else {
                    editTextFirstName.setError("First Name Can't be empty");
                }

                break;


            case R.id.linearLayoutAccountAlready:
                Intent intent4 = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent4);
                break;

            case R.id.linearLayoutSkipRegistration:
                Intent intent2 = new Intent(SignUpActivity.this, HomePageActivity.class);

                startActivity(intent2);
                finish();

                break;
        }
    }

    private void createUserToFirebase(User user) {

        userNode = "users/";
        database.child(userNode).child(user.getUserId()).setValue(user); // here, we can not use user id as its not firebase generated id, data in snapshot will come only after pushing data with firebase key.

    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        editTextDOB.setText(sdf.format(myCalendar.getTime()));
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}
