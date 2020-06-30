package com.zyw.day03.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zyw.day03.R;
import com.zyw.day03.adapter.DataAdapter;
import com.zyw.day03.bean.Bean;
import com.zyw.day03.presenter.MyPresenter;
import com.zyw.day03.view.MyView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment implements MyView {

    @BindView(R.id.mRecycler)
    RecyclerView mRecycler;
    Unbinder unbinder;
    private DataAdapter dataAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.home, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initView();
        initPresenter();
        return inflate;
    }

    private void initPresenter() {
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.toModel();
    }

    private void initView() {
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        dataAdapter = new DataAdapter(getActivity());
        mRecycler.setAdapter(dataAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSuccess(List<Bean.DataBean.DatasBean> data) {
        dataAdapter.addData(data);
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
