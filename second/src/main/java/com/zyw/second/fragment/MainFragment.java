package com.zyw.second.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zyw.second.R;
import com.zyw.second.adapter.DataAdapter;
import com.zyw.second.bean.ListBean;
import com.zyw.second.bean.TitleBean;
import com.zyw.second.presenter.MyPresenter;
import com.zyw.second.view.MyView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainFragment extends Fragment implements MyView {

    @BindView(R.id.mRecycler)
    RecyclerView mRecycler;
    Unbinder unbinder;
    private int cid;
    private MyPresenter myPresenter;
    private DataAdapter dataAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.main, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        Bundle arguments = getArguments();
        cid = arguments.getInt("cid");
        initView();
        initPresenter();

        return inflate;
    }

    private void initPresenter() {
        myPresenter = new MyPresenter(this);
        myPresenter.toListModel(cid);
    }

    private void initView() {

        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        dataAdapter = new DataAdapter(getActivity());
        mRecycler.setAdapter(dataAdapter);
    }

    @Override
    public void onTitleSuccess(List<TitleBean.DataBean> data) {

    }

    private static final String TAG = "MainFragment";

    @Override
    public void onListSuccess(List<ListBean.DataBean.DatasBean> data) {
        Log.d(TAG, "onListSuccess: " + data.size());
        dataAdapter.addData(data);
    }

    @Override
    public void onFail(String msg) {
        showToast(msg);
    }

    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser == true && mRecycler != null) {
            myPresenter.toListModel(cid);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
