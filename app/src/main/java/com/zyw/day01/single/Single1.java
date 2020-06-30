package com.zyw.day01.single;

//懒汉：只有用的时候才会创建
//缺点：线程不安全多线程环境下运行的结果的是否确定返回的对象可能不是一个
public class Single1 {
    //1.创建自身的实例对象但是不能赋值
    private static Single1  single1=null;
    //2.构造私有化
    private Single1(){}
    //3.创建静态方法获取自身的对象
    public static Single1 getInstance(){

        if(single1==null){
            single1=new Single1();
        }

        return single1;
    }
}
