package com.zyw.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.greendaodemo.db.AClassDao;
import com.zyw.second.adapter.DataAdapter;
import com.zyw.second.app.MyApp;
import com.zyw.second.bean.AClass;
import com.zyw.second.presenter.IPresenter;
import com.zyw.second.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BClassActivity extends AppCompatActivity {

    @BindView(R.id.mTool)
    Toolbar mTool;
    @BindView(R.id.mRecycler)
    RecyclerView mRecycler;
    private DataAdapter dataAdapter;
    private List<AClass> dataA;
    private List<AClass> classA;
    private AClassDao aClassDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bclass);
        ButterKnife.bind(this);
        aClassDao = MyApp.getInstance().getDaoSession().getAClassDao();
        dataA = new ArrayList<>();

        initView();
    }

    private void initView() {
        mTool.setTitle("");
        setSupportActionBar(mTool);

        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        dataAdapter = new DataAdapter(this);
        mRecycler.setAdapter(dataAdapter);
        List<AClass> list = aClassDao.queryBuilder().list();
        for (AClass da : list) {
            if (da.getClassName().equals("B")) {
                dataA.add(da);
            }
        }

        dataAdapter.addData(dataA);
    }

}
