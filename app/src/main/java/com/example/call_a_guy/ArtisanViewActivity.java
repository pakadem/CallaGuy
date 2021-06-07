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

public class ArtisanViewActivity extends AppCompatActivity {
    DatabaseHelper DB;
    EditText text_artisan_name, text_artisan_surname, text_artisan_email, text_artisan_phone, text_artisan_skill, text_artisan_location;
    private TextView artisan_ID;
    String artisan_ID_intent;
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
        text_artisan_name = (EditText)findViewById(R.id.text_artisan_name);
        text_artisan_surname = (EditText)findViewById(R.id.text_artisan_surname);
        text_artisan_email = (EditText)findViewById(R.id.text_artisan_email);
        text_artisan_phone = (EditText)findViewById(R.id.text_artisan_phone);
        text_artisan_skill = (EditText)findViewById(R.id.text_artisan_skill);
        text_artisan_location = (EditText)findViewById(R.id.text_artisan_location);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        artisan_ID_intent = getIntent().getStringExtra("text_artisan_ID");
        int artisan_ID_int =Integer.parseInt(artisan_ID_intent);
        artisan_ID = findViewById(R.id.text_artisan_ID);
        artisan_ID.setText(artisan_ID_intent);


        viewUser(artisan_ID_int);
    }

    public void viewUser(int artisan_ID) {
        Cursor res = DB.getArtisanUser(artisan_ID);
        if (res.getCount() == 0) {
            showMessage("Error", "Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            text_artisan_name.setText(res.getString(1));
            text_artisan_surname.setText(res.getString(2));
            text_artisan_email.setText(res.getString(3));
            text_artisan_phone.setText(res.getString(4));
            text_artisan_skill.setText(res.getString(5));
            text_artisan_location.setText(res.getString(6));
        }
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

}