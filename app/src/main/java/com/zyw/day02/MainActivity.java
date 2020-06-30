package com.zyw.day02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zyw.day02.build.Computer;
import com.zyw.day02.build.HuaweiBuilder;
import com.zyw.day02.build.MacBuilder;
import com.zyw.day02.factory.Apple;
import com.zyw.day02.factory.Banana;
import com.zyw.day02.factory.SuperFactoryImpl;
import com.zyw.day02.obser.KingHonor;
import com.zyw.day02.obser.LittleStudent;
import com.zyw.day02.obser.Teacher;
import com.zyw.day02.template.ArmyComputer;
import com.zyw.day02.template.Coder;
import com.zyw.day02.template.XiaobaiComputer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private KingHonor mKingHonor;
    private Button click1;
    private Button click2;
    private Button click3;
    private Button click4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        observer();
    }

    private void observer() {

        mKingHonor = new KingHonor();
        LittleStudent littleStudent = new LittleStudent();
        Teacher teacher = new Teacher();

        //添加观察者
        mKingHonor.addObserver(littleStudent);
        mKingHonor.addObserver(teacher);
    }

    private void factory() {

        SuperFactoryImpl superFactory = new SuperFactoryImpl();
        Apple apple1 = superFactory.createProduct(Apple.class);
        Banana banana1 = superFactory.createProduct(Banana.class);
        apple1.print();
        banana1.print();
    }

    private void build() {

        Computer computer = new HuaweiBuilder()
                .buildCpu("华为cpu ")
                .buildDisplay("显示器")
                .buildOs()
                .build();

        Computer build = new MacBuilder()
                .buildCpu("Mac cpu")
                .buildDisplay("显示器")
                .buildOs()
                .build();
        Log.d(TAG, "build: " + computer.toString());
        Log.d(TAG, "build: " + build.toString());
    }

    private static final String TAG = "MainActivity";

    private void initView() {
        click1 = (Button) findViewById(R.id.click1);
        click2 = (Button) findViewById(R.id.click2);
        click3 = (Button) findViewById(R.id.click3);
        click4 = (Button) findViewById(R.id.click4);


        click1.setOnClickListener(this);
        click2.setOnClickListener(this);
        click3.setOnClickListener(this);
        click4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click1:
                mKingHonor.gameUpdate("哈哈哈123");
                break;
            case R.id.click2:
                build();
                break;
            case R.id.click3:
                factory();
                break;
            case R.id.click4:
                template();
                break;

        }
    }

    private void template() {
        new XiaobaiComputer().start();
        new Coder().start();
        new ArmyComputer().start();
    }
}
