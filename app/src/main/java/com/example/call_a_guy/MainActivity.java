package com.example.call_a_guy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_search, btn_artisan, btn_client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent( MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        btn_artisan = findViewById(R.id.btn_artisan);
        btn_artisan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent( MainActivity.this, ArtisanStartActivity.class);
                startActivity(intent);
            }
        });


        btn_client = findViewById(R.id.btn_client);
        btn_client.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent( MainActivity.this, ClientStartActivity.class);
                startActivity(intent);
            }
        });

    }
}