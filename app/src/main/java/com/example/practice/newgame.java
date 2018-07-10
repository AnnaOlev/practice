package com.example.practice;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class newgame extends AppCompatActivity {

    private CheckBox ChekGeek;
    private CheckBox ChecNormal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newgame);
    }

    public void GameClick2 (View view) {

        ChekGeek= (CheckBox)findViewById(R.id.checkTypeGeek);
        ChecNormal=(CheckBox)findViewById(R.id.checkTypeNorm);

        if(!(ChecNormal.isChecked()&&ChekGeek.isChecked())) { //check for correctness
            if(ChekGeek.isChecked()||ChecNormal.isChecked()) {

                Intent intent5;  //transition to game
                EditText EditName = findViewById(R.id.editName);
                intent5 = new Intent(newgame.this, game.class);
                if (ChecNormal.isChecked())
                    intent5.putExtra("type", "normal");
                if (ChekGeek.isChecked())
                    intent5.putExtra("type", "geek");
                intent5.putExtra("name", EditName.getText().toString());
                intent5.putExtra("stat", "new");
                startActivity(intent5);
            }
        }
    }

    public void normalClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment1 myDialogFragment = new MyDialogFragment1();
        myDialogFragment.show(manager, "dialog");
    }

    public void geekClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment2 myDialogFragment = new MyDialogFragment2();
        myDialogFragment.show(manager, "dialog");
    }
}
