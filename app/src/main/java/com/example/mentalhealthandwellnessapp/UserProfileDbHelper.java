package com.example.mentalhealthandwellnessapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// UserProfileDbHelper.java
public class UserProfileDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "user_profile.db";
    private static final int DATABASE_VERSION = 1;

    public UserProfileDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle upgrades if needed
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String SQL_CREATE_USER_PROFILE_TABLE = "CREATE TABLE " +
                UserProfileContract.UserProfileEntry.TABLE_NAME + " (" +
                UserProfileContract.UserProfileEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                UserProfileContract.UserProfileEntry.COLUMN_NAME + " TEXT NOT NULL," +
                UserProfileContract.UserProfileEntry.COLUMN_AGE + "INTEGER NOT NULL" + ");";
        db.execSQL(SQL_CREATE_USER_PROFILE_TABLE);
    }

}

