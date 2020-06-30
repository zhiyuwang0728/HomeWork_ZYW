package com.zyw.day02.template;

import android.util.Log;

public abstract class AbstractComputer {
    String TAG = "AbstractComputer";

    public void start(){
        //1.按下电源
        powerOn();
        //2.检测硬件
        checkHardware();
        //3.载入操作系统
        loadOs();
        //4.登录
        login();

        //开机成功
        Log.d(TAG, "start: 开机成功!");
    }

    protected abstract void login();

    protected void loadOs() {
        Log.d(TAG, "loadOs: 载入操作系统");
    }

    private void checkHardware(){
        Log.d(TAG, "checkHardware:检测硬件 ");
    };

    private void powerOn() {
        Log.d(TAG, "powerOn:按下电源 ");
    }
}
