package com.example.george.firstproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

/**
 * Created by George on 10/31/16.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Student> students;
    private LayoutInflater layoutInflater;
    private TextView idTextView;
    private TextView nameTextView;
    private TextView sexTextView;
    private TextView birthdayTextView;
    private TextView emailTextView;
    private TextView locationTextView;

    MyAdapter(Context context, List<Student> students){
        this.context = context;
        this.students = students;
        layoutInflater = LayoutInflater.from(this.context);
    }
    @Override
    public int getCount(){
        return students.size();
    }

    @Override
    public Object getItem(int location){
        return students.get(location);
    }

    @Override
    public long getItemId(int location){
        return location;
    }

    @Override
    public View getView(int location, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.student_listview,null);
        }

        idTextView = (TextView) convertView.findViewById(R.id.idTextView);
        nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
        sexTextView = (TextView) convertView.findViewById(R.id.sexTextView);
        birthdayTextView = (TextView) convertView.findViewById(R.id.birthdayTextView);
        emailTextView = (TextView) convertView.findViewById(R.id.emailTextView);
        locationTextView = (TextView) convertView.findViewById(R.id.locationTextView);

        idTextView.setText("学号:" + students.get(location).getId());
        nameTextView.setText("姓名: " + students.get(location).getName());
        sexTextView.setText("性别: " +students.get(location).getSex());
        birthdayTextView.setText("生日: " + students.get(location).getBirthday());
        emailTextView.setText("邮箱: " + students.get(location).getEmail());
        locationTextView.setText("家庭住址: " + students.get(location).getHomeLocation());

        return convertView;
    }
}
