package com.example.call_a_guy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArtisanStartActivity extends AppCompatActivity {

    private Button btn_back, btn_artisan_login, btn_artisan_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artisan_start);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ArtisanStartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_artisan_login = findViewById(R.id.btn_artisan_login);
        btn_artisan_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent( ArtisanStartActivity.this, ArtisanRegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_artisan_register = findViewById(R.id.btn_artisan_register);
        btn_artisan_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent( ArtisanStartActivity.this, ArtisanRegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}