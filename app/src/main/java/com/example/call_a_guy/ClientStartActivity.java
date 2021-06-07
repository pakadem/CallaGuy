package com.example.call_a_guy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ClientStartActivity extends AppCompatActivity {
    private EditText text_client_id;
    private Button btn_back, btn_login, btn_client_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_start);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ClientStartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        text_client_id = findViewById(R.id.text_client_id);
        String text_client = text_client_id.getText().toString();
        text_client_id.setText(text_client);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textmessage = text_client_id.getText().toString();
                Intent intent = new Intent(ClientStartActivity.this, ClientViewActivity.class);
                intent.putExtra("text_client_ID", textmessage);
                startActivity(intent);
            }
        });

        btn_client_register = findViewById(R.id.btn_client_register);
        btn_client_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ClientStartActivity.this, ClientRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}