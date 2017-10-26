package com.example.administrator.a05persontest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et_inputName;
    private RadioGroup rg_group;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.找到控件
        et_inputName = (EditText) findViewById(R.id.et_inputName);
        rg_group = (RadioGroup) findViewById(R.id.rg_group);
        Button bt_calc = (Button) findViewById(R.id.bt_calc);
        bt_calc.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        //2.判断输入的姓名不能为空
        String name = et_inputName.getText().toString().trim();
        if (TextUtils.isEmpty(name)){
            Toast.makeText(getApplicationContext(),"亲 请输入你的姓名",Toast.LENGTH_SHORT).show();
            return;
        }

        //3.性别必须选
        int sexVal = 0;
        switch (rg_group.getCheckedRadioButtonId()){
            case R.id.male:
                sexVal = 1;
                break;
            case R.id.female:
                sexVal = 2;
                break;
            case R.id.other:
                sexVal = 3;
                break;
            default:
                break;
        }
        if (0 == sexVal){
            Toast.makeText(getApplicationContext(),"请选择性别",Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, CalcTestActivity.class);
        startActivity(intent);
    }


}



