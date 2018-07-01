package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Random;

public class question extends AppCompatActivity {
    TextView quest;
    Button ansver1;
    Button ansver2;
    Button ansver3;
    Button ansver4;
    public String an1;
    public String an2;
    public String an3;
    public String an4;
    public String ques;
    public String indpp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        quest = (TextView) findViewById(R.id.quest);
        ansver1 = (Button) findViewById(R.id.answer1);
        ansver2 = (Button) findViewById(R.id.answer2);
        ansver3 = (Button) findViewById(R.id.answer3);
        ansver4 = (Button) findViewById(R.id.answer4);
        final Random random = new Random();
        int numq = random.nextInt(5);
        String strq = Integer.toString(numq);

        XmlPullParser parser = getResources().getXml(R.xml.normal_left_ques);

        try {
            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG) {
                    if (parser.getName().equals("question" + strq)) {
                        an1 = parser.getAttributeValue(0);
                        an2 = parser.getAttributeValue(1);
                        an3 = parser.getAttributeValue(2);
                        an4 = parser.getAttributeValue(3);
                        ques = parser.getAttributeValue(4);
                        indpp = parser.getAttributeValue(5);
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
        ansver1.setText(an1);
        ansver2.setText(an2);
        ansver3.setText(an3);
        ansver4.setText(an4);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void ReturnCick(View view) {
        Intent intent7;
        intent7 = new Intent (question.this, game.class);
        startActivity(intent7);
    }
}
