//姓名:赵宇杰 班级:软英1401 学号:20145031
package com.example.george.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Toast toast;
    private EditText sID;
    private EditText sName;
    private RadioGroup sexRadioGroup;
    private RadioButton sexRadioButton;
    private DatePicker datePicker;
    private EditText email;
    private Spinner provinceSpinner;
    private EditText location;
    private Button subButton;
    private Button cancelButton;
    private Button loadButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取需要操作的组件
        setContentView(R.layout.activity_main);
        sID = (EditText)findViewById(R.id.IdText);
        sName = (EditText)findViewById(R.id.nameText);
        sexRadioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        provinceSpinner = (Spinner)findViewById(R.id.provinceSpinner);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        email = (EditText)findViewById(R.id.emailText);
        location = (EditText)findViewById(R.id.locationText);
        //将当前日期设为生日的最大上限
        datePicker.setMaxDate(new Date().getTime());
        subButton = (Button) findViewById(R.id.submitButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        loadButton = (Button) findViewById(R.id.loadButton);

        //创建数据库
        final DatabaseHandler databaseHandler = new DatabaseHandler(this);
        databaseHandler.getWritableDatabase();

        subButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Student student = new Student();
                student.setId(Integer.parseInt(sID.getText().toString()));
                student.setName(sName.getText().toString());
                int selectedSex = sexRadioGroup.getCheckedRadioButtonId();
                sexRadioButton =(RadioButton)findViewById(selectedSex);
                student.setSex(sexRadioButton.getText().toString());
                student.setBirthday(datePicker.getYear() + "年" + datePicker.getMonth() + "月" + datePicker.getDayOfMonth() + "日");
                student.setEmail(email.getText().toString());
                student.setHomeLocation(provinceSpinner.getSelectedItem().toString() + "省" + location.getText().toString());

                databaseHandler.addStudent(student);
                toast = Toast.makeText(MainActivity.this,"成功将学生信息存入数据库",Toast.LENGTH_LONG);
                toast.show();
                cleanAll();


            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                cleanAll();
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    protected void cleanAll(){
        //重置输入选项
        sID.setText("");
        sName.setText("");
        sexRadioGroup.check(R.id.radioMale);
        email.setText("");
        location.setText("");
        provinceSpinner.setSelection(0);
        //将datapicker重置为当前日期
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year,month,day,null);
    }

}
