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
    EditText text_artisan_name, text_artisan_surname, text_artisan_email, text_artisan_phone, text_artisan_skill, text_artisan_location;
    Button btn_back, btn_artisan_reg_submit;

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
        text_artisan_name = (EditText)findViewById(R.id.text_artisan_name);
        text_artisan_surname = (EditText)findViewById(R.id.text_artisan_surname);
        text_artisan_email = (EditText)findViewById(R.id.text_artisan_email);
        text_artisan_phone = (EditText)findViewById(R.id.text_artisan_phone);
        text_artisan_skill = (EditText)findViewById(R.id.text_artisan_skill);
        text_artisan_location = (EditText)findViewById(R.id.text_artisan_location);
        btn_artisan_reg_submit = (Button) findViewById(R.id.btn_artisan_reg_submit);

        createArtisan();
    }

    public void createArtisan()
    {
        btn_artisan_reg_submit.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean Isinserted = DB.insertArtisanData(  text_artisan_name.getText().toString(),
                                                                text_artisan_surname.getText().toString(),
                                                                text_artisan_email.getText().toString(),
                                                                text_artisan_phone.getText().toString(),
                                                                text_artisan_skill.getText().toString(),
                                                                text_artisan_location.getText().toString()
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