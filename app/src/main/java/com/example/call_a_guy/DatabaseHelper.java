package com.example.call_a_guy;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    int ID;
    String Name, Surname, Email, Phone, Location;
    public static final String DATABASE_NAME = "callaguy.db";

    public static final String CLIENT_TABLE_NAME = "client";
    public static final String CLIENT_COLUMN_ID = "ID";
    public static final String CLIENT_COLUMN_NAME = "NAME";
    public static final String CLIENT_COLUMN_SURNAME = "SURNAME";
    public static final String CLIENT_COLUMN_EMAIL = "EMAIL";
    public static final String CLIENT_COLUMN_PHONE = "PHONE";
    public static final String CLIENT_COLUMN_LOCATION = "LOCATION";

    public static final String ARTISAN_TABLE_NAME = "artisan";
    public static final String ARTISAN_COLUMN_ID = "ID";
    public static final String ARTISAN_COLUMN_NAME = "NAME";
    public static final String ARTISAN_COLUMN_SURNAME = "SURNAME";
    public static final String ARTISAN_COLUMN_EMAIL = "EMAIL";
    public static final String ARTISAN_COLUMN_PHONE = "PHONE";
    public static final String ARTISAN_COLUMN_SKILL = "SKILL";
    public static final String ARTISAN_COLUMN_LOCATION = "LOCATION";
    private HashMap hp;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1 = "create table " + CLIENT_TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT,EMAIL TEXT,PHONE TEXT,LOCATION TEXT)";
        String table2 = "create table " + ARTISAN_TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT,EMAIL TEXT,PHONE TEXT,SKILL TEXT,LOCATION TEXT)";

        db.execSQL(table1);
        db.execSQL(table2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CLIENT_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ARTISAN_TABLE_NAME);
        onCreate(db);

    }

    public boolean insertClientData(String Name, String Surname, String Email, String Phone, String Location) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CLIENT_COLUMN_NAME, Name);
        contentValues.put(CLIENT_COLUMN_SURNAME, Surname);
        contentValues.put(CLIENT_COLUMN_EMAIL, Email);
        contentValues.put(CLIENT_COLUMN_PHONE, Phone);
        contentValues.put(CLIENT_COLUMN_LOCATION, Location);

        long result = db.insert(CLIENT_TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insertArtisanData(String Name, String Surname, String Email, String Phone, String Skill, String Location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ARTISAN_COLUMN_NAME, Name);
        contentValues.put(ARTISAN_COLUMN_SURNAME, Surname);
        contentValues.put(ARTISAN_COLUMN_EMAIL, Email);
        contentValues.put(ARTISAN_COLUMN_PHONE, Phone);
        contentValues.put(ARTISAN_COLUMN_SKILL, Skill);
        contentValues.put(ARTISAN_COLUMN_LOCATION, Location);

        long result = db.insert(ARTISAN_TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String getClientData(String Email){
        Cursor cursor = null;
        String empName = "";
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            cursor = db.rawQuery("SELECT Name FROM client WHERE Email="+Email,null);
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                empName = cursor.getString(cursor.getColumnIndex("Name"));
            }
            return empName;
        }finally {
            cursor.close();
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+ ARTISAN_TABLE_NAME,null);

        return res;
    }

    Cursor getArtisanUser(int ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from artisan WHERE ID=" + ID,null);

        return res;
    }
    Cursor getClientUser(int ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from client WHERE ID=" + ID,null);

        return res;
    }

    public boolean updateClientData(String ID, String Name, String Surname, String Email, String Phone, String Location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CLIENT_COLUMN_ID, ID);
        contentValues.put(CLIENT_COLUMN_NAME, Name);
        contentValues.put(CLIENT_COLUMN_SURNAME, Surname);
        contentValues.put(CLIENT_COLUMN_EMAIL, Email);
        contentValues.put(CLIENT_COLUMN_PHONE, Phone);
        contentValues.put(CLIENT_COLUMN_LOCATION, Location);
        db.update(CLIENT_TABLE_NAME,contentValues,"ID=?",new String[] {ID});

        return true;
    }

    public boolean updateArtisanData(String ID, String Name, String Surname, String Email, String Phone, String Skill, String Location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ARTISAN_COLUMN_ID, ID);
        contentValues.put(ARTISAN_COLUMN_NAME, Name);
        contentValues.put(ARTISAN_COLUMN_SURNAME, Surname);
        contentValues.put(ARTISAN_COLUMN_EMAIL, Email);
        contentValues.put(ARTISAN_COLUMN_PHONE, Phone);
        contentValues.put(ARTISAN_COLUMN_SKILL, Skill);
        contentValues.put(ARTISAN_COLUMN_LOCATION, Location);
        db.update(ARTISAN_TABLE_NAME,contentValues,"ID=?",new String[] {ID});

        return true;
    }

    public Integer deleteClientData(String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(CLIENT_TABLE_NAME,"ID=?",new String[] {ID});

    }
    public Integer deleteArtisanData(String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(ARTISAN_TABLE_NAME,"ID=?",new String[] {ID});

    }
}

