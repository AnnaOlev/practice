package com.example.practice;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.practice.data.DBContract.YourScores;
import com.example.practice.data.DbHelper;

public class scores extends AppCompatActivity {
    public String stat, newName;
    public long newDate;
    private DbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        mDbHelper = new DbHelper(this);
        stat = getIntent().getStringExtra("status"); // getting status
        if (stat.equals("end")) { // end of game and adding score
            newName = getIntent().getStringExtra("name");
            newDate = getIntent().getLongExtra("day", newDate);
            insertScore();
        }

        if (stat.equals("continue")) { // game is not over
        }
        displayDatabaseInfo();
    }

    public void OneMoreReturnCLick(View view) { // go to main menu
        Intent intent11;
        intent11 = new Intent(scores.this, MainMenu.class);
        intent11.putExtra("novelty", stat);
        startActivity(intent11);
    }

    private void displayDatabaseInfo() {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                YourScores._ID,
                YourScores.COLUMN_NAME,
                YourScores.COLUMN_DAYS };

        Cursor cursor = db.query(
                YourScores.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                YourScores.COLUMN_DAYS + " DESC"); // order by number of days

        TextView displayTextView1 = (TextView) findViewById(R.id.info1);
        TextView displayTextView2 = findViewById(R.id.info2);

        try {

            int nameColumnIndex = cursor.getColumnIndex(YourScores.COLUMN_NAME);
            int dayColumnIndex = cursor.getColumnIndex(YourScores.COLUMN_DAYS);

            while (cursor.moveToNext()) {
                String currentName = cursor.getString(nameColumnIndex); // get current name
                int currentDay = cursor.getInt(dayColumnIndex); // get current number of days
                displayTextView1.append(( // display name
                        currentName + "\n"));
                displayTextView2.append((currentDay + "\n")); // display number of days
            }
        } finally { // closing cursor
            cursor.close();
        }
    }


    private void insertScore() { // adding new score
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(YourScores.COLUMN_NAME, newName);
        values.put(YourScores.COLUMN_DAYS, newDate);

        long newRowId = db.insert(YourScores.TABLE_NAME, null, values);

    }
}
