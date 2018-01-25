package com.cdac.projectdemo.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditUserDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextDOB;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private Button buttonUpdate;
    Calendar myCalendar;
    private User user;
    private EditText editTextAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_details);

        editTextDOB = (EditText) findViewById(R.id.editTextDOB);
        editTextDOB.setOnClickListener(this);
        myCalendar = Calendar.getInstance();
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);

        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(this);


        SharedPreferenceManager.setApplicationContext(EditUserDetailsActivity.this);
        user = SharedPreferenceManager.getUserObjectFromSharedPreference();
        if (user != null) {
            editTextFirstName.setText(user.getFirstName());
            editTextLastName.setText(user.getLastName());
            editTextDOB.setText(user.getDateOfBirth());
            editTextAddress.setText(user.getAddress());

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonUpdate:
                if (editTextFirstName.getText().toString().length() > 0) {
                    if (editTextLastName.getText().toString().length() > 0) {

                        user.setUserId(user.getUserId());
                        user.setFirstName(editTextFirstName.getText().toString());
                        user.setLastName(editTextLastName.getText().toString());
                        user.setEmailId(user.getEmailId());
                        user.setPassword(user.getEmailId());
                        user.setDateOfBirth(user.getUserId());
                        user.setAddress(editTextAddress.getText().toString());
                        SharedPreferenceManager.storeUserObjectInSharedPreference(user);
                        hideKeyBoard();

                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("result", "SUCCESS");
                        setResult(Activity.RESULT_OK, returnIntent);
                        finish();

                    } else {
                        editTextLastName.setError("Last Name Can't be empty");
                    }
                } else {
                    editTextFirstName.setError("First Name Can't be empty");
                }


                break;

            case R.id.editTextDOB:
                DatePickerDialog dlg = new DatePickerDialog(EditUserDetailsActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dlg.getDatePicker().setMaxDate(System.currentTimeMillis());
                dlg.show();
                break;

        }
    }

    public void hideKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
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
}
