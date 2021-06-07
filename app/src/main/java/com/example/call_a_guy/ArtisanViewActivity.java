package com.example.call_a_guy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ArtisanViewActivity extends AppCompatActivity {
    DatabaseHelper DB;
    EditText name, surname, email, phone, skill, location;
    Button btn_back, btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artisan_view);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ArtisanViewActivity.this, ArtisanStartActivity.class);
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

        viewUser();
    }

    public void viewUser() {
        Cursor res = DB.getUser(2);
        if (res.getCount() == 0) {
            showMessage("Error", "Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("ID:" + res.getString(0) + "\n");
            buffer.append("NAME:" + res.getString(1) + "\n");
            buffer.append("SURNAME:" + res.getString(2) + "\n");
            buffer.append("MARKS:" + res.getString(3) + "\n\n");
        }
        showMessage("Data", buffer.toString());
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

}