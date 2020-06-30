package com.zyw.day02.obser;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        //Observable o:被观察者
        //arg:被观察者传递过来的信息
        Log.d("Teacher", "update: "+arg.toString());
    }
}
