package com.zyw.day02.build;

public abstract class Builder {

    public abstract Builder buildOs();

    public abstract Builder buildDisplay(String display);

    public abstract Builder buildCpu(String cpu);

    public abstract Computer build();
}
