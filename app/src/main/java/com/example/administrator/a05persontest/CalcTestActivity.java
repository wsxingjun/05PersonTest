package com.example.administrator.a05persontest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.administrator.a05persontest.R.layout.activity_test;

/**
 * Created by Administrator on 2017-10-26.
 */

public class CalcTestActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_test);
        //1.找到控件
        TextView tv_name = (TextView) findViewById(R.id.tv_name);
        TextView tv_sex = (TextView) findViewById(R.id.tv_sex);
        TextView tv_calcResult = (TextView) findViewById(R.id.tv_calcResult);


        //2.获取该Activity的inent对象
        Intent RecvIntent= getIntent();
        //3.取出传递来的数据
        String name = RecvIntent.getStringExtra("name");
        int sexVal = RecvIntent.getIntExtra("sexVal", 0);

        //4.设置数据
        tv_name.setText(name);

        String sexString = "";
        switch (sexVal){
            case 1:
                sexString = "男";
                break;
            case 2:
                sexString = "女";
                break;
            case 3:
                sexString = "人妖";
                break;
            default:
                break;
        }

        tv_sex.setText(sexString);

    }

}
