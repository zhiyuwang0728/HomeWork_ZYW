package com.zyw.day01.single;

import android.util.Log;

public class Single3 {

    private static volatile Single3 single3 = null;
    int a;
    private Single3() {
        a=10;
    }

    public static Single3 getInstance() {

        if (single3 == null) {
            synchronized (Single3.class) {
                if (single3 == null) {
                    single3 = new Single3();
                }
            }
        }
        return single3;
    }

    public int getData(){

        return a;
    }
}
