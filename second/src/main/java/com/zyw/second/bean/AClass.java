package com.zyw.second.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class AClass {

    @Id
    Long id;
    String name;
    String sex;
    String age;
    String className;
    @Generated(hash = 1200889778)
    public AClass(Long id, String name, String sex, String age, String className) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.className = className;
    }

    public AClass(String name, String sex, String age, String className) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.className = className;
    }

    @Generated(hash = 908428796)
    public AClass() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getClassName() {
        return this.className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
}
