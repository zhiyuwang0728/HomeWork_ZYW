package com.zyw.day02.build;

import java.util.Currency;

public abstract class Computer {
    public String mCpu;
    public String mDisplay;//显示器
    public String mOs;//操作系统

    public void setCpu(String cpu){
        this.mCpu = cpu;
    }
    public void setDisplay(String display){
        this.mDisplay = display;
    }
    public abstract void setOs();

    @Override
    public String toString() {
        return "Computer{" +
                "mCpu='" + mCpu + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOs='" + mOs + '\'' +
                '}';
    }
}
