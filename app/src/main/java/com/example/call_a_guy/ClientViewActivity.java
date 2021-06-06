package com.example.call_a_guy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ClientViewActivity extends AppCompatActivity {
    DatabaseHelper DB;
    EditText username, name, surname, phone, location;
    Button btn_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_view);

        username = (EditText)findViewById(R.id.username);
        name = (EditText)findViewById(R.id.name);
        surname = (EditText)findViewById(R.id.surname);
        phone = (EditText)findViewById(R.id.phone);
        location = (EditText)findViewById(R.id.location);
        btn_submit = (Button) findViewById(R.id.btn_submit);
    }
}