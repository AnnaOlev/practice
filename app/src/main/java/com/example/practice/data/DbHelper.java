package com.example.practice.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.practice.data.DBContract.YourScores;

public class DbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = DbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "scores.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_SCORES_TABLE = "CREATE TABLE " + YourScores.TABLE_NAME + " ("
                + DBContract.YourScores._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + YourScores.COLUMN_NAME + " TEXT NOT NULL, "
                + YourScores.COLUMN_DAYS + " INTEGER NOT NULL DEFAULT 0);";


        db.execSQL(SQL_CREATE_SCORES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
