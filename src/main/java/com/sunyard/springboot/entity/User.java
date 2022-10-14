package com.sunyard.springboot.entity;

public class User implements Comparable{
    private String name;
    private Integer age;
    private Integer gender;
    private String address;

    public User() {
    }

    public User(String name, Integer age, Integer gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        return ((User) o).getAge() - age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int hashno = 7;
        hashno = 13 * hashno + name == null ? 0 : name.hashCode();
        return hashno;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj ==  null) {
            return false;
        }
        final User user = (User) obj;
        if (this == user) {
            return true;
        } else {
            return this.name.equals(((User) obj).getName()) && this.age.equals(((User) obj).getAge());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public  String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
