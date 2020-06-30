package com.zyw.day01.single;
//单例：对象始终保持一个
//饿汉：无论是否使用都创建实例  缺点：占内存
public class Single {

    //1. 创建本身的实例
    private  static Single single=new Single();
    //2.将构造私有化
    private Single(){}

    //3.创建静态方法返回自身对象
    public static Single getInstance(){
        return single;
    }

}
