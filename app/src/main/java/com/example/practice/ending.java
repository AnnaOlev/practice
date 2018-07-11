package com.example.practice;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ending extends AppCompatActivity {
    public long day;
    public String name, end, tip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        end= getIntent().getStringExtra("ending");
        name= getIntent().getStringExtra("name");
        day=getIntent().getLongExtra("date", day);
        tip = getIntent().getStringExtra("type");

        choiceEnding(); //choice of ending
    }

    public void HomeCLick(View view) { //transition to records
        Intent intent8;
        intent8 = new Intent (ending.this, scores.class);
        intent8.putExtra("status","end");
        intent8.putExtra("name", name);
        intent8.putExtra("day",day);
        startActivity(intent8);
    }

public void choiceEnding()
{
    if(end.equals("bank"))
    {
        ImageView imageView = findViewById(R.id.endImage);
        ConstraintLayout mlayout = findViewById(R.id.endlay);
        mlayout.setBackgroundResource(R.drawable.backend);
        if (tip.equals("normal"))
            imageView.setImageResource(R.drawable.rip);
        else
            imageView.setImageResource(R.drawable.geekrip);
        Toast toast = Toast.makeText(getApplicationContext(), "Твоя жизнь снова оказалась на дне ", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        MediaPlayer player;
        player = MediaPlayer.create(this, R.raw.dark);
        player.start();
    }
    if(end.equals("run"))
    {
        ImageView imageView = findViewById(R.id.endImage);
        if (tip.equals("normal"))
            imageView.setImageResource(R.drawable.ubeg);
        else
            imageView.setImageResource(R.drawable.geekubeg);
        Toast toast = Toast.makeText(getApplicationContext(), "Моя жизнь слишком проста для твоих сложных проблем ", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        MediaPlayer player;
        player = MediaPlayer.create(this, R.raw.hell1);
        player.start();
    }
}

}