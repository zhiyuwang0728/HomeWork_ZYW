package com.zyw.day02.template;

import android.util.Log;

public class XiaobaiComputer extends AbstractComputer {
    @Override
    protected void login() {
        Log.d("xiaobai", "login:小白没有密码,直接进入桌面 ");
    }
}
