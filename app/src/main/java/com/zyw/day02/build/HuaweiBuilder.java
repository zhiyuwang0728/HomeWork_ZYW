package com.zyw.day02.build;

public class HuaweiBuilder extends Builder {
    Huawei mHuawei = new Huawei();
    @Override
    public Builder buildOs() {
        mHuawei.setOs();
        return this;
    }

    @Override
    public Builder buildDisplay(String display) {
        mHuawei.setDisplay(display);
        return this;
    }

    @Override
    public Builder buildCpu(String cpu) {
        mHuawei.setCpu(cpu);
        return this;
    }

    @Override
    public Computer build() {
        return mHuawei;
    }
}
