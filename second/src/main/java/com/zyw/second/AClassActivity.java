package com.zyw.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.zyw.second.adapter.DataAdapter;
import com.zyw.second.bean.AClass;
import com.zyw.second.presenter.IPresenter;
import com.zyw.second.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AClassActivity extends AppCompatActivity implements IView {

    @BindView(R.id.mTool)
    Toolbar mTool;
    @BindView(R.id.mRecycler)
    RecyclerView mRecycler;
    private DataAdapter dataAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aclass);
        ButterKnife.bind(this);
        initView();
        initPresenter();

    }

    private void initPresenter() {
        IPresenter iPresenter = new IPresenter(this);
        iPresenter.toModel();
    }

    private void initView() {
        mTool.setTitle("");
        setSupportActionBar(mTool);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        dataAdapter = new DataAdapter(this);
        mRecycler.setAdapter(dataAdapter);

    }

    @Override
    public void onSuccess(List<AClass> data) {
        List<AClass> dataA = new ArrayList<>();
        for (AClass datas : data) {
            if(datas.getClassName().equals("A")){
                dataA.add(datas);
            }
        }
        Log.d(TAG, "onSuccess: "+dataA.size());
        dataAdapter.addData(dataA);
    }

    private static final String TAG = "AClassActivity";

    @Override
    public void onFail(String msg) {

    }
}
