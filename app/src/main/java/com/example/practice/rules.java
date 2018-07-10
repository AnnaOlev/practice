package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class rules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        setTitle("TabHost");

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setContent(R.id.linearLayout);
        tabSpec.setIndicator("1");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.linearLayout2);
        tabSpec.setIndicator("2");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setContent(R.id.linearLayout3);
        tabSpec.setIndicator("3");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag4");
        tabSpec.setContent(R.id.linearLayout4);
        tabSpec.setIndicator("4");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag5");
        tabSpec.setContent(R.id.linearLayout5);
        tabSpec.setIndicator("5");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);
    }

    public void RHomeClick(View view) {
        Intent intent10;
        intent10 = new Intent(rules.this, MainMenu.class);
        startActivity(intent10);
    }
}
