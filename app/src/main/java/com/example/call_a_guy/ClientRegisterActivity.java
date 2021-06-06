package com.example.call_a_guy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClientRegisterActivity extends AppCompatActivity {
    DatabaseHelper DB;
    EditText username, name, surname, phone, location;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_register);

        DB = new DatabaseHelper(this);
        username = (EditText)findViewById(R.id.username);
        name = (EditText)findViewById(R.id.name);
        surname = (EditText)findViewById(R.id.surname);
        phone = (EditText)findViewById(R.id.phone);
        location = (EditText)findViewById(R.id.location);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        createClient();
    }

    public void createClient()
    {
        btn_submit.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean Isinserted = DB.insertClientData(
                                                username.getText().toString(),
                                                                name.getText().toString(),
                                                                surname.getText().toString(),
                                                                phone.getText().toString(),
                                                                location.getText().toString()
                                                        );
                    if (Isinserted==true){
                        Toast.makeText(ClientRegisterActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(ClientRegisterActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        );
    }
}