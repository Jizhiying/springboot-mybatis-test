package com.sunyard.springboot.entity;

public class MyEntity extends TestEntity {
    private String msg;

    public MyEntity() {
        System.out.println("MyEntity无参构造器");

    }
    public MyEntity(String msg) {
        System.out.println("MyEntity有参构造器");
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
