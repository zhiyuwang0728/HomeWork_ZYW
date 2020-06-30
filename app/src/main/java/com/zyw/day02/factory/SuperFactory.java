package com.zyw.day02.factory;

//万能工厂
public abstract class SuperFactory {
    public abstract  <A extends Product> A createProduct(Class<A> clz);
}
