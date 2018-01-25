package com.cdac.projectdemo.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        buttonSignUp.setOnClickListener(this);
        linearLayoutAccountAlready = (LinearLayout) findViewById(R.id.linearLayoutAccountAlready);
        linearLayoutSkipRegistration = (LinearLayout) findViewById(R.id.linearLayoutSkipRegistration);
        linearLayoutAccountAlready.setOnClickListener(this);
        linearLayoutSkipRegistration.setOnClickListener(this);

        SharedPreferenceManager.setApplicationContext(SignUpActivity.this);

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
                                    if(editTextAddress.getText().toString().length() > 0) {
                                        User user = new User();
                                        user.setUserId(System.currentTimeMillis() + "");
                                        user.setFirstName(editTextFirstName.getText().toString());
                                        user.setLastName(editTextLastName.getText().toString());
                                        user.setEmailId(editTextEmailId.getText().toString());
                                        user.setPassword(editTextPassword.getText().toString());
                                        user.setDateOfBirth(editTextDOB.getText().toString());
                                        user.setAddress(editTextAddress.getText().toString());
                                        SharedPreferenceManager.storeUserObjectInSharedPreference(user);

                                        Intent intent = new Intent(SignUpActivity.this, HomePageActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                                        startActivity(intent);
                                        finish();
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
