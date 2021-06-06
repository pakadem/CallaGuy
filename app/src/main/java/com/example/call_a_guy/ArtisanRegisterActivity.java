package com.example.call_a_guy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ArtisanRegisterActivity extends AppCompatActivity {
    DatabaseHelper DB;
    EditText name, surname, email, phone, skill, location;
    private Button btn_back, btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artisan_register);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  Intent intent = new Intent(ArtisanRegisterActivity.this, ArtisanStartActivity.class);
                 startActivity(intent);
            }
        });

        DB = new DatabaseHelper(this);
        name = (EditText)findViewById(R.id.name);
        surname = (EditText)findViewById(R.id.surname);
        email = (EditText)findViewById(R.id.email);
        phone = (EditText)findViewById(R.id.phone);
        skill = (EditText)findViewById(R.id.skill);
        location = (EditText)findViewById(R.id.location);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        createArtisan();
    }

    public void createArtisan()
    {
        btn_submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean Isinserted = DB.insertArtisanData(  name.getText().toString(),
                                                                    surname.getText().toString(),
                                                                    email.getText().toString(),
                                                                    phone.getText().toString(),
                                                                    skill.getText().toString(),
                                                                    location.getText().toString()
                        );
                        if (Isinserted==true){
                            Toast.makeText(ArtisanRegisterActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(ArtisanRegisterActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
        );
    }
}