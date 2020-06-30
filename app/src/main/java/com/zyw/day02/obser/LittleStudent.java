package com.zyw.day02.obser;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;


//观察者
public class LittleStudent implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Log.d("LittleStudent", "update: "+arg.toString());
    }
}
