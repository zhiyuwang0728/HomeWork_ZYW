package com.zyw.day02.factory;

public class AppleFactory extends Factory {
    @Override
    public Product createProduct() {
        return new Apple();
    }
}
