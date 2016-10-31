package com.example.george.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

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
        sIDTextView = (TextView)findViewById(R.id.sIDTextView);
        sNameTextView = (TextView)findViewById(R.id.sNameTextView);
        sexTextView = (TextView)findViewById(R.id.sexTextView);
        birthdayTextView = (TextView)findViewById(R.id.birthdayTextView);
        emailTextView = (TextView)findViewById(R.id.emailTextView);
        locationTextView = (TextView)findViewById(R.id.locationTextView);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        List<Student> students = databaseHandler.getAllStudents();
        for(Student student : students){
            sIDTextView.setText("学号: " + student.getId());
            sNameTextView.setText("姓名: " + student.getName());
            sexTextView.setText("性别: " + student.getSex());
            birthdayTextView.setText("出生日期: " + student.getBirthday());
            emailTextView.setText("邮箱: " + student.getEmail());
            locationTextView.setText("地址: " + student.getHomeLocation());
        }


    }
}
