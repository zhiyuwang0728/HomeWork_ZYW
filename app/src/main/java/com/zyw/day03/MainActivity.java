package com.zyw.day03;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.zyw.day03.adapter.PageAdapter;
import com.zyw.day03.fragment.DownFragment;
import com.zyw.day03.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.mTool)
    Toolbar mTool;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    @BindView(R.id.mTab)
    TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mTool.setTitle("");
        setSupportActionBar(mTool);

        List<Fragment> data = new ArrayList<>();
        data.add(new HomeFragment());
        data.add(new DownFragment());

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), data);
        mViewPager.setAdapter(pageAdapter);

        mTab.setupWithViewPager(mViewPager);

        mTab.getTabAt(0).setText("首页");
        mTab.getTabAt(1).setText("下载");

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    mTitle.setText("首页");
                } else {
                    mTitle.setText("下载");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
