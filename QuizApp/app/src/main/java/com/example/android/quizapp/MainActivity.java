package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RadioButton quest1;
    private RadioButton quest2;
    private RadioButton quest3;
    private RadioButton quest4;
    private RadioButton quest5;
    private RadioButton quest6;
    private RadioButton quest7;
    private RadioButton quest8;
    private RadioButton quest9;
    private RadioButton quest10;
    private ArrayList<RadioButton> mAnsKey;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quest1 = (RadioButton) findViewById(R.id.question1_choice4);
        quest2 = (RadioButton) findViewById(R.id.question2_choice2);
        quest3 = (RadioButton) findViewById(R.id.question3_choice4);
        quest4 = (RadioButton) findViewById(R.id.question4_choice3);
        quest5 = (RadioButton) findViewById(R.id.question5_choice1);
        quest6 = (RadioButton) findViewById(R.id.question6_choice1);
        quest7 = (RadioButton) findViewById(R.id.question7_choice4);
        quest8 = (RadioButton) findViewById(R.id.question8_choice3);
        quest9 = (RadioButton) findViewById(R.id.question9_choice2);
        quest10 = (RadioButton) findViewById(R.id.question10_choice1);
        mAnsKey = new ArrayList<>();
        addAnswerKey();

    }

    public void addAnswerKey() {
        mAnsKey.add(quest1);
        mAnsKey.add(quest2);
        mAnsKey.add(quest3);
        mAnsKey.add(quest4);
        mAnsKey.add(quest5);
        mAnsKey.add(quest6);
        mAnsKey.add(quest7);
        mAnsKey.add(quest8);
        mAnsKey.add(quest9);
        mAnsKey.add(quest10);
    }

    public void submitAnswers(View view) {

        for (RadioButton model : mAnsKey) {
            if (model.isChecked()) {
                count += 1;
            }
        }
        try {
            if (count >= 7) {
                Toast.makeText(this, getResources().getString(R.string.text_pass) +" "+ count, Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, getResources().getString(R.string.text_failed) +" "+count, Toast.LENGTH_LONG).show();

            }

        } finally {
            count = 0;
        }

    }
}
