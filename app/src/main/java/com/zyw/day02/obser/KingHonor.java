package com.zyw.day02.obser;

import java.util.Observable;

//被观察者
public class KingHonor extends Observable {

    //游戏更新
    public void gameUpdate(String msg){
        //需要通知所有的玩家
        //1.设置状态改变
        setChanged();
        //2.通知所有观察者
        notifyObservers(msg);
    }
}
