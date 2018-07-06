package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class ending extends AppCompatActivity {
    public long day;
    public String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String ending;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        ending= getIntent().getStringExtra("ending");
        name= getIntent().getStringExtra("name");
        day=getIntent().getLongExtra("date", day);
        if(ending.equals("bank"))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Твоя жизнь снова оказалась на дне ", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        if(ending.equals("run"))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Моя жизнь слишком проста для твоих сложных проблем ", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    public void HomeCLick(View view) {
        Intent intent8;
        intent8 = new Intent (ending.this, scores.class);
        intent8.putExtra("status","end");
        intent8.putExtra("name", name);
        intent8.putExtra("day",day);
        startActivity(intent8);
    }

}
