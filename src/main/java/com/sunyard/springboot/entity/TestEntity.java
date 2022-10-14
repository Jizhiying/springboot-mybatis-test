package com.sunyard.springboot.entity;

public class TestEntity {
    public TestEntity() {
        System.out.println("TestEntity无参构造器");
    }

    public TestEntity(String custNo, String custName) {
        System.out.println("TestEntity有参构造器");
        this.custNo = custNo;
        this.custName = custName;
    }

    private String custNo;
    private String custName;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "custNo='" + custNo + '\'' +
                ", custName='" + custName + '\'' +
                '}';
    }
}
