package com.zyw.day02.template;

import android.util.Log;

public class ArmyComputer extends AbstractComputer {
    @Override
    protected void login() {
        Log.d("ArmyComputer", "login: 指纹识别,虹膜识别,三组128位");
    }

    @Override
    protected void loadOs() {
        super.loadOs();
        Log.d(TAG, "loadOs: 军用电脑需要检测防火墙 ");
    }
}
