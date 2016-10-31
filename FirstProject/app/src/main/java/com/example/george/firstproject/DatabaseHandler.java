package com.example.george.firstproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * Created by George on 10/31/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper{
    //数据库版本
    private static final int DATABASE_VERSION = 1;

    //数据库名称
    private static final String DATABASE_NAME = "studentInformation";

    //表的名字
    private static final String TABLE_STUDENTS = "students";

    //每列的名字
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SEX = "sex";
    private static final String KEY_BIRTHDAY = "birthday";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_HOMELOCATION = "homeLocation";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_STUDENTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_SEX +
                " TEXT," + KEY_BIRTHDAY + " TEXT," + KEY_EMAIL + " TEXT," + KEY_HOMELOCATION + " TEXT" +")";
        Log.e("DatabaseHandler ", CREATE_CONTACTS_TABLE);
        database.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        //如果存在旧表就删除
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);

        //创建新表
        onCreate(database);
    }

    //往数据库添加新的学生
    public void addStudent(Student student){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, student.getId()+"");
        values.put(KEY_NAME, student.getName());
        values.put(KEY_SEX, student.getSex());
        values.put(KEY_BIRTHDAY, student.getBirthday());
        values.put(KEY_EMAIL, student.getEmail());
        values.put(KEY_HOMELOCATION, student.getHomeLocation());

        database.insert(TABLE_STUDENTS,null,values);
        database.close();
    }

    //得到某一学生
    public Student getStudent(int id) {
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.query(TABLE_STUDENTS, new String[]{ KEY_ID,
                KEY_NAME, KEY_SEX, KEY_BIRTHDAY, KEY_EMAIL, KEY_HOMELOCATION}, KEY_ID + "=?",
                new String[]{ String.valueOf(id)}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Student student = new Student(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
        return student;
    }

    //获取全部的学生
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<Student>();

        String selectQuery = "SELECT * FROM " + TABLE_STUDENTS;

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery,null);


        if(cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setName(cursor.getString(1));
                student.setSex(cursor.getString(2));
                student.setBirthday(cursor.getString(3));
                student.setEmail(cursor.getString(4));
                student.setHomeLocation(cursor.getString(5));

                studentList.add(student);
            }while (cursor.moveToNext());
        }

        return studentList;
    }


}
