package com.example.george.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class SecondActivity extends AppCompatActivity  {
    private ListView listView;
    private  List<Student> students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        listView = (ListView) findViewById(R.id.listView);
        students = databaseHandler.getAllStudents();
        listView.setAdapter(new MyAdapter(this, students));
    }
}
