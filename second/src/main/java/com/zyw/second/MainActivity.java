package com.zyw.second;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.zyw.second.adapter.PageAdapter;
import com.zyw.second.bean.ListBean;
import com.zyw.second.bean.TitleBean;
import com.zyw.second.fragment.MainFragment;
import com.zyw.second.presenter.MyPresenter;
import com.zyw.second.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyView {

    @BindView(R.id.mTab)
    TabLayout mTab;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initPresenter();
    }

    private static final String TAG = "MainActivity";

    private void initPresenter() {
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.toTitleModel();

    }


    @Override
    public void onTitleSuccess(List<TitleBean.DataBean> data) {

        Log.d(TAG, "onTitleSuccess: " + data.size());
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int id = data.get(i).getId();
            MainFragment mainFragment = new MainFragment();

            Bundle bundle = new Bundle();
            bundle.putInt("cid", id);
            mainFragment.setArguments(bundle);

            fragmentList.add(mainFragment);
        }

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(pageAdapter);

        mTab.setupWithViewPager(mViewPager);

        for (int i = 0; i < data.size(); i++) {
            String name = data.get(i).getName();
            mTab.getTabAt(i).setText(name);
        }


    }

    @Override
    public void onListSuccess(List<ListBean.DataBean.DatasBean> data) {

    }

    @Override
    public void onFail(String msg) {
        showToast(msg);
    }


    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
