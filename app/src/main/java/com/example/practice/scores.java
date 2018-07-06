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

import org.w3c.dom.Text;

public class scores extends AppCompatActivity {
    public String stat, newName;
    public long newDate;
    private DbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        mDbHelper = new DbHelper(this);
        stat = getIntent().getStringExtra("status");
        if (stat.equals("end")) {
            newName = getIntent().getStringExtra("name");
            newDate = getIntent().getLongExtra("day", newDate);
            insertScore();
        }

        if (stat.equals("continue")) {
        }
        displayDatabaseInfo();
    }

    public void OneMoreReturnCLick(View view) {
        Intent intent11;
        intent11 = new Intent(scores.this, MainMenu.class);
        intent11.putExtra("novelty", stat);
        startActivity(intent11);
    }

    private void displayDatabaseInfo() {
        // Создадим и откроем для чтения базу данных
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Зададим условие для выборки - список столбцов
        String[] projection = {
                YourScores._ID,
                YourScores.COLUMN_NAME,
                YourScores.COLUMN_DAYS };

        // Делаем запрос
        Cursor cursor = db.query(
                YourScores.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                YourScores.COLUMN_DAYS + " DESC");

        TextView displayTextView1 = (TextView) findViewById(R.id.info1);
        TextView displayTextView2 = findViewById(R.id.info2);

        try {
            // Узнаем индекс каждого столбца
            int idColumnIndex = cursor.getColumnIndex(YourScores._ID);
            int nameColumnIndex = cursor.getColumnIndex(YourScores.COLUMN_NAME);
            int dayColumnIndex = cursor.getColumnIndex(YourScores.COLUMN_DAYS);

            // Проходим через все ряды
            while (cursor.moveToNext()) {
                // Используем индекс для получения строки или числа
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                int currentAge = cursor.getInt(dayColumnIndex);
                // Выводим значения каждого столбца
                displayTextView1.append((
                        currentName + "\n"));
                displayTextView2.append((currentAge + "\n"));
            }
        } finally {
            // Всегда закрываем курсор после чтения
            cursor.close();
        }
    }


    private void insertScore() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(YourScores.COLUMN_NAME, newName);
        values.put(YourScores.COLUMN_DAYS, newDate);

        long newRowId = db.insert(YourScores.TABLE_NAME, null, values);

    }
}
