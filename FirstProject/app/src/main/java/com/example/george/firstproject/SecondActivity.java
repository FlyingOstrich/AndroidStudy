package com.example.george.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView sIDTextView;
    private TextView sNameTextView;
    private TextView sexTextView;
    private TextView birthdayTextView;
    private TextView emailTextView;
    private TextView locationTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        sIDTextView = (TextView)findViewById(R.id.sIDTextView);
        sNameTextView = (TextView)findViewById(R.id.sNameTextView);
        sexTextView = (TextView)findViewById(R.id.sexTextView);
        birthdayTextView = (TextView)findViewById(R.id.birthdayTextView);
        emailTextView = (TextView)findViewById(R.id.emailTextView);
        locationTextView = (TextView)findViewById(R.id.locationTextView);

        sIDTextView.setText("学号: " + intent.getStringExtra("sID"));
        sNameTextView.setText("姓名: " + intent.getStringExtra("sName"));
        sexTextView.setText("性别: " + intent.getStringExtra("sex"));
        birthdayTextView.setText("出生日期: " + intent.getStringExtra("birthday"));
        emailTextView.setText("邮箱: " + intent.getStringExtra("email"));
        locationTextView.setText("地址: " + intent.getStringExtra("location"));

    }
}
