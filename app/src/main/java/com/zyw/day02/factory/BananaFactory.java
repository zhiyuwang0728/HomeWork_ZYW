package com.zyw.day02.factory;

public class BananaFactory extends Factory {
    @Override
    public Product createProduct() {
        return new Banana();
    }
}
