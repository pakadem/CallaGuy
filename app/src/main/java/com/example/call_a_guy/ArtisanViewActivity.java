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

public class ArtisanViewActivity extends AppCompatActivity {
    DatabaseHelper DB;
    EditText text_artisan_name, text_artisan_surname, text_artisan_email, text_artisan_phone, text_artisan_skill, text_artisan_location;
    private TextView artisan_ID;
    String artisan_ID_intent;
    Button btn_back, btn_submit, btn_artisan_view_update, btn_artisan_view_delete;

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
        btn_artisan_view_update = (Button) findViewById(R.id.btn_artisan_view_update);
        btn_artisan_view_delete = (Button) findViewById(R.id.btn_artisan_view_delete);

        artisan_ID_intent = getIntent().getStringExtra("text_artisan_ID");
        int artisan_ID_int =Integer.parseInt(artisan_ID_intent);
        artisan_ID = findViewById(R.id.text_artisan_ID);
        artisan_ID.setText(artisan_ID_intent);


        viewUser(artisan_ID_int);
        updateArtisanData(artisan_ID_intent);
        deleteArtisanData(artisan_ID_intent);
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

    public void updateArtisanData(String artisan_ID_intent)
    {

        btn_artisan_view_update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //String client_ID = Integer.toString(client_ID_intent);
                        boolean IsUpdate= DB.updateArtisanData( artisan_ID_intent,
                                                                text_artisan_name.getText().toString(),
                                                                text_artisan_surname.getText().toString(),
                                                                text_artisan_email.getText().toString(),
                                                                text_artisan_phone.getText().toString(),
                                                                text_artisan_skill.getText().toString(),
                                                                text_artisan_location.getText().toString()
                                                        );
                        if(IsUpdate==true)
                        {
                            Toast.makeText(ArtisanViewActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(ArtisanViewActivity.this, "Data not updated", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void deleteArtisanData(String artisan_ID_int){
        btn_artisan_view_delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = DB.deleteArtisanData(artisan_ID_int);
                        if (deletedRows > 0) {
                            Toast.makeText(ArtisanViewActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ArtisanViewActivity.this, "Data not deleted", Toast.LENGTH_SHORT).show();
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