package com.zyw.day02.template;

import android.util.Log;

public class Coder extends AbstractComputer {
    @Override
    protected void login() {
        Log.d("Coder", "login: 码农输入了 128位密码");
    }
}
