package com.zyw.day03.fragment;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.zyw.day03.R;
import com.zyw.day03.bean.MsgEvent;
import com.zyw.day03.service.MyService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DownFragment extends Fragment {

    @BindView(R.id.mProgress)
    ProgressBar mProgress;
    @BindView(R.id.tv_progress)
    TextView tvProgress;
    @BindView(R.id.btn_down)
    Button btnDown;
    Unbinder unbinder;
    private MyService myService;

    String mPath = "/storage/emulated/0/zyw.apk";
    private String mUrl = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.download, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initPer();
        EventBus.getDefault().register(this);
        Intent intent = new Intent(getActivity(), MyService.class);
        getActivity().bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);


        return inflate;
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder binder = (MyService.MyBinder) service;
            myService = binder.getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void initPer() {
        int result = ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);

        if (result == PackageManager.PERMISSION_GRANTED) {
            //授权了
        } else {
            String[] arr = {
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            };
            ActivityCompat.requestPermissions(getActivity(), arr, 200);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 200 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //用户授权了
        } else {
            showToast("用户未授权");
        }
    }

    private void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_down)
    public void onViewClicked() {
        myService.downLoad(mPath, mUrl);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEvent(MsgEvent msgEvent) {

        if (msgEvent.getFlag() == 1) {
            mProgress.setMax((int) msgEvent.getContentLength());
            mProgress.setProgress(msgEvent.getProgress());
            int speed = (int) (msgEvent.getProgress() * 100 / msgEvent.getContentLength());
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            String format = decimalFormat.format(speed);
            tvProgress.setText(format + "%");
            if (msgEvent.getProgress() == msgEvent.getContentLength()) {
                showToast("下载完成");
            }
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
        getActivity().unbindService(serviceConnection);
    }


}
