package com.server.firebase.booksellingappserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity
{


    private Button btnBook;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBook=(Button) findViewById(R.id.buttonBook);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                DatabaseReference database = FirebaseDatabase.getInstance().getReference();

                for (int i = 0; i < 8; i++) {

                    FirebaseApp firebaseInstance = FirebaseApp.getInstance();
                    Book book = new Book();
                    book.setId(i+"");
                    book.setName("Amzing");
                    book.setDesc("wowknksissnsisjsjsi");
                    database.child("booklist").child(book.getId()).setValue(book);
                }

            }
        });
    }
}
