package com.example.call_a_guy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ClientViewActivity extends AppCompatActivity {
    DatabaseHelper DB;
    EditText username, name, surname, phone, location;
    Button btn_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_view);

        DB = new DatabaseHelper(this);
        username = (EditText)findViewById(R.id.username);
        name = (EditText)findViewById(R.id.name);
        surname = (EditText)findViewById(R.id.surname);
        phone = (EditText)findViewById(R.id.phone);
        location = (EditText)findViewById(R.id.location);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        getClientData();
    }

    public void getClientData() {
        String email = "pakadem";
        String res = DB.getClientData(email);
//        if (res.getCount() == 0) {
//            //showMessage("Error","Nothing found");
//            return;
//        }

//        StringBuffer buffer = new StringBuffer();
//        while (res.moveToNext()) {
//            buffer.append("ID:" + res.getString(0) + "\n");
//            buffer.append("NAME:" + res.getString(1) + "\n");
//            buffer.append("SURNAME:" + res.getString(2) + "\n");
//            buffer.append("MARKS:" + res.getString(3) + "\n\n");
//        }
        //showMessage("Data",buffer.toString());
    }

}