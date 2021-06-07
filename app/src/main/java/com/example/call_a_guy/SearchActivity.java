package com.example.call_a_guy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {
    DatabaseHelper DB;
    EditText name, surname, email, phone, skill, location;
    private Button btn_back, btn_view_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        DB = new DatabaseHelper(this);
//        text_artisan_name = (EditText)findViewById(R.id.text_artisan_name);
//        text_artisan_surname = (EditText)findViewById(R.id.text_artisan_surname);
//        text_artisan_email = (EditText)findViewById(R.id.text_artisan_email);
//        text_artisan_phone = (EditText)findViewById(R.id.text_artisan_phone);
//        text_artisan_skill = (EditText)findViewById(R.id.text_artisan_skill);
//        text_artisan_location = (EditText)findViewById(R.id.text_artisan_location);
//        btn_artisan_reg_submit = (Button) findViewById(R.id.btn_artisan_reg_submit);
        btn_view_all = (Button) findViewById(R.id.btn_artisan_reg_submit);


        viewAll();
    }

    public void viewAll()
    {
        btn_view_all.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = DB.getAllData();
                        if(res.getCount() == 0){
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()) {
                            buffer.append("ID:"+res.getString(0)+"\n");
                            buffer.append("NAME:"+res.getString(1)+"\n");
                            buffer.append("SURNAME:"+res.getString(2)+"\n");
                        }
                        showMessage("Data",buffer.toString());


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