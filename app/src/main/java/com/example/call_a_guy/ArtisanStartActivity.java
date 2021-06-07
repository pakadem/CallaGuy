package com.example.call_a_guy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ArtisanStartActivity extends AppCompatActivity {
    private EditText text_artisan_id;
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

        text_artisan_id = findViewById(R.id.text_artisan_id);
        String text_artisan = text_artisan_id.getText().toString();
        text_artisan_id.setText(text_artisan);

        btn_artisan_login = findViewById(R.id.btn_artisan_login);
        btn_artisan_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textmessage = text_artisan_id.getText().toString();
                Intent intent = new Intent(ArtisanStartActivity.this, ArtisanViewActivity.class);
                intent.putExtra("text_artisan_ID", textmessage);
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