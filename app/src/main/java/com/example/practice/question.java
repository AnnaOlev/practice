package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Random;

public class question extends AppCompatActivity {
    TextView quest;
    Button answer1, answer2, answer3, answer4;
    public String an1, an2, an3, an4, ques, indqv, result, trues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XmlPullParser parser;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        quest = (TextView) findViewById(R.id.quest);
        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);
        Intent intent = getIntent();
        result = intent.getStringExtra("hemisphere");
        if (result.equals("left"))
        {
            parser = getResources().getXml(R.xml.normal_left_ques);
        }
        else
        {
            parser = getResources().getXml(R.xml.normal_right_quest);
        }
        final Random random = new Random();
        int numq = random.nextInt(20);
        String strq = Integer.toString(numq);


        try {
            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG) {
                    if (parser.getName().equals("question" + strq)) {
                        an1 = parser.getAttributeValue(0);
                        an2 = parser.getAttributeValue(1);
                        an3 = parser.getAttributeValue(2);
                        an4 = parser.getAttributeValue(3);
                        ques = parser.getAttributeValue(4);
                        indqv = parser.getAttributeValue(5);
                        break;
                    }
                }
                parser.next();

            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        quest.setText(ques);
        answer1.setText(an1);
        answer2.setText(an2);
        answer3.setText(an3);
        answer4.setText(an4);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void ReturnCick(View view) {
        switch(view.getId()) {
           case R.id.answer1:
               trueQvest(indqv, "1");
                break;
            case R.id.answer2:
                trueQvest(indqv, "2");
                break;
            case R.id.answer3:
                trueQvest(indqv, "3");
                break;
            case R.id.answer4:
                trueQvest(indqv, "4");
                break;
        }
        Intent intent7;
        intent7 = new Intent (question.this, game.class);
        intent7.putExtra("hemisphere",result);
        intent7.putExtra("right",trues);
        intent7.putExtra("stat", "prod");
        startActivity(intent7);
    }
    public void trueQvest(String ind, String answer) {
        if (ind.equals(answer)) {
            trues="yes";
            Toast toast = Toast.makeText(getApplicationContext(), "Ты ответил верно!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            trues="no";
            Toast toast = Toast.makeText(getApplicationContext(), "Упс. Ты ошибся.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
}

