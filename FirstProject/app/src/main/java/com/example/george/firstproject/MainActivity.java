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
        Button subButton = (Button) findViewById(R.id.submitButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);

        subButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
//                //获得输入信息
//                String showMessage = "";
//                showMessage += "姓名: " + sID.getText().toString() + "\n";
//                showMessage += "学号:" + sName.getText().toString() + "\n";
//                //确定选中的性别
//                int selectedSex = sexRadioGroup.getCheckedRadioButtonId();
//                sexRadioButton =(RadioButton)findViewById(selectedSex);
//                showMessage += "性别:" + sexRadioButton.getText().toString() + "\n";
//                //获取生日
//                showMessage += "出生日期: " + datePicker.getYear() + "年" + datePicker.getMonth() + "月" + datePicker.getDayOfMonth() + "日\n";
//
//                showMessage += "邮箱: " + email.getText().toString() + "\n";
//                showMessage += "家庭住址: " + provinceSpinner.getSelectedItem().toString() + "省" + location.getText().toString();
//
//                toast = Toast.makeText(MainActivity.this,showMessage,Toast.LENGTH_LONG);
//                toast.show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("sID",sID.getText().toString());
                intent.putExtra("sName",sName.getText().toString());
                int selectedSex = sexRadioGroup.getCheckedRadioButtonId();
                sexRadioButton =(RadioButton)findViewById(selectedSex);
                intent.putExtra("sex", sexRadioButton.getText().toString());
                intent.putExtra("birthday","" + datePicker.getYear() + "年" + datePicker.getMonth() + "月" + datePicker.getDayOfMonth() + "日");
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("location", provinceSpinner.getSelectedItem().toString() + "省" + location.getText().toString());
                startActivity(intent);

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
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
        });
    }


}
