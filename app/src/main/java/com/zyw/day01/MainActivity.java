package com.zyw.day01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zyw.day01.single.Single;
import com.zyw.day01.single.Single1;
import com.zyw.day01.single.Single3;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Single instance = Single.getInstance();
        Single instance1 = Single.getInstance();
        Log.d(TAG, "onCreate: "+"饿汉-地址值："+instance.toString()+"饿汉-地址值："+instance1.toString());

        Single1 instance2 = Single1.getInstance();
        Single1 instance3 = Single1.getInstance();
        Log.d(TAG, "onCreate: "+"懒汉-地址值"+instance2.toString()+"懒汉-地址值："+instance3.toString());

        Single3 instance4 = Single3.getInstance();
        Single3 instance5 = Single3.getInstance();

        Log.d(TAG, "onCreate: "+"双重校验-地址值："+instance4.toString()+"双重校验-地址值："+instance5.toString());

        int data = instance4.getData();
        Log.d(TAG, "onCreate: "+data);


    }
}
