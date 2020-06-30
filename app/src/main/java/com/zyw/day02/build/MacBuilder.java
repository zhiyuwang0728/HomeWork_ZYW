package com.zyw.day02.build;

public class MacBuilder extends Builder {
     MacBook mMacBook = new MacBook();

    @Override
    public Builder buildOs() {
        mMacBook.setOs();
        return this;
    }

    @Override
    public Builder buildDisplay(String display) {
        mMacBook.setDisplay(display);
        return this;
    }

    @Override
    public Builder buildCpu(String cpu) {
        mMacBook.setCpu(cpu);
        return this;
    }

    @Override
    public Computer build() {
        return mMacBook;
    }
}
