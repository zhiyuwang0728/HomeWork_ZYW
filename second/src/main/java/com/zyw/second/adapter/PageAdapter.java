package com.zyw.second.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {
    private final List<Fragment> data;

    public PageAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data=data;
    }

    @Override
    public Fragment getItem(int i) {
        return data.get(i);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
