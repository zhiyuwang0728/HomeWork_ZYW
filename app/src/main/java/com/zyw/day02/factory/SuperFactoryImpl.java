package com.zyw.day02.factory;

public class SuperFactoryImpl extends SuperFactory {
    @Override
    public <T extends Product> T createProduct(Class<T> clz) {
        //反射
        T o = null;
        try {
            //.newInstance(); 相当于是调用构造方法
             o= (T) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
