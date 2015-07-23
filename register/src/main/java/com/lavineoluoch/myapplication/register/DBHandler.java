package com.lavineoluoch.myapplication.register;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 7/21/2015.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "registration.db";
    private static final String TABLE_NAME = "Users";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_FIRSTNAME = "FirstName";
    private static final String COLUMN_SURNAME = "Surname";
    private static final String COLUMN_USERNAME = "Username";
    private static final String COLUMN_PASSWORD = "Password";

    //Constructor required to pass information to super class
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }


    //Called first time DB is used
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_FIRSTNAME + " VARCHAR, "+
                COLUMN_SURNAME + " VARCHAR, " +
                COLUMN_USERNAME + " VARCHAR, " +
                COLUMN_PASSWORD + " VARCHAR " +
                ")";

            db.execSQL(query);

    }

    //Called any time DB is upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    //Add new row to DB
    public void addUser(User user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRSTNAME,user.get_firstName());
        values.put(COLUMN_SURNAME,user.get_surName());
        values.put(COLUMN_USERNAME,user.get_username());
        values.put(COLUMN_PASSWORD,user.get_password());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();

    }
}
