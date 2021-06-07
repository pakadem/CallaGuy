package com.example.call_a_guy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClientViewActivity extends AppCompatActivity {
    DatabaseHelper DB;
    EditText text_client_email, text_client_name, text_client_surname, text_client_phone, text_client_location;
    private TextView client_ID;
    String client_ID_intent;
    Button btn_back, btn_submit, btn_client_update, btn_client_DELETE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_view);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ClientViewActivity.this, ClientStartActivity.class);
                startActivity(intent);
            }
        });

        DB = new DatabaseHelper(this);
        text_client_email = (EditText)findViewById(R.id.text_client_email);
        text_client_name = (EditText)findViewById(R.id.text_client_name);
        text_client_surname = (EditText)findViewById(R.id.text_client_surname);
        text_client_phone = (EditText)findViewById(R.id.text_client_phone);
        text_client_location = (EditText)findViewById(R.id.text_client_location);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        client_ID_intent = getIntent().getStringExtra("text_client_ID");
        int client_ID_int =Integer.parseInt(client_ID_intent);
        client_ID = findViewById(R.id.text_client_ID);
        client_ID.setText(client_ID_intent);

        viewUser(client_ID_int);
        updateClientData();
        deleteClientData();
    }

    public void viewUser(int client_ID) {
        Cursor res = DB.getClientUser(client_ID);
        if (res.getCount() == 0) {
            showMessage("Error", "Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            text_client_name.setText(res.getString(1));
            text_client_surname.setText(res.getString(2));
            text_client_email.setText(res.getString(3));
            text_client_phone.setText(res.getString(4));
            text_client_location.setText(res.getString(5));
        }
    }

    public void updateClientData()
    {

        btn_client_update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //String client_ID = Integer.toString(client_ID_intent);
                        boolean IsUpdate= DB.updateClientData(
                                client_ID_intent,
                                text_client_name.getText().toString(),
                                text_client_surname.getText().toString(),
                                text_client_email.getText().toString(),
                                text_client_phone.getText().toString(),
                                text_client_location.getText().toString()
                        );
                        if(IsUpdate==true)
                        {
                            Toast.makeText(ClientViewActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(ClientViewActivity.this, "Data not updated", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void deleteClientData()
    {
        btn_client_DELETE.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = DB.deleteClientData(client_ID_intent);
                        if (deletedRows > 0) {
                            Toast.makeText(ClientViewActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ClientViewActivity.this, "Data not deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
}