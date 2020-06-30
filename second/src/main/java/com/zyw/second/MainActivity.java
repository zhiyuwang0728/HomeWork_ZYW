package com.zyw.second;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.greendaodemo.db.AClassDao;
import com.zyw.second.app.MyApp;
import com.zyw.second.bean.AClass;
import com.zyw.second.presenter.IPresenter;
import com.zyw.second.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.mTool)
    Toolbar mTool;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private AClassDao aClassDao;
    private List<AClass> dataA;
    private List<AClass> dataB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        aClassDao = MyApp.getInstance().getDaoSession().getAClassDao();
        dataA = new ArrayList<>();
        dataB = new ArrayList<>();
        initPresenter();
        initView();
//        initDataBase();
    }

    private void initPresenter() {

        IPresenter iPresenter = new IPresenter(this);
        iPresenter.toModel();
    }

    private void initDataBase() {
        List<AClass> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AClass aClass = new AClass();
            aClass.setName("小红" + i);
            aClass.setSex("女");
            aClass.setAge("18岁");
            aClass.setClassName("A");
            data.add(aClass);
        }
        for (int i = 0; i < 10; i++) {
            AClass aClass = new AClass();
            aClass.setName("小明" + i);
            aClass.setSex("男");
            aClass.setAge("18岁");
            aClass.setClassName("B");
            data.add(aClass);
        }
        Log.d(TAG, "initDataBase: " + data.size());
        aClassDao.insertOrReplaceInTx(data);

//        aClassDao.deleteAll();
    }

    private static final String TAG = "MainActivity";

    private void initView() {

        mTool.setTitle("");
        setSupportActionBar(mTool);
        TextPaint paint = btnLogin.getPaint();
        paint.setFakeBoldText(true);

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String name = etUsername.getText().toString();
        String passowrd = etPassword.getText().toString();
        Log.d(TAG, "onViewClicked: " + name);
        Log.d(TAG, "onViewClicked: " + dataA.size() + "---" + dataB.size());
        //A班
        for (int i = 0; i < dataA.size(); i++) {
            if (dataA.get(i).getName().equals(name)&&passowrd.length()>0) {
                Intent intent = new Intent(MainActivity.this, AClassActivity.class);
                startActivity(intent);
            }
        }
        //B班
        for (int i = 0; i < dataB.size(); i++) {
            if (dataB.get(i).getName().equals(name)&&passowrd.length()>0) {
                Intent intent = new Intent(MainActivity.this, BClassActivity.class);
                startActivity(intent);

            }
        }

        if (passowrd.length() == 0) {
            showToast("密码不能为空");
        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(List<AClass> data) {

        Log.d(TAG, "onSuccess: " + data.size());

        for (AClass datas : data) {
            String className = datas.getClassName();
            if (className.equals("A")) {
                dataA.add(datas);
            } else if (className.equals("B")) {
                dataB.add(datas);
            } else {

            }
        }

        Log.d(TAG, "onSuccess: " + dataA.size() + "---" + dataB.size());
    }

    @Override
    public void onFail(String msg) {

    }
}
