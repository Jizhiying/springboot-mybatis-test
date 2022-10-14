package com.sunyard.springboot;

import com.sunyard.springboot.entity.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindDataINAList {
    public static void main(String[] args) {
        //千万级list里查找一个数据
        List<User> list = initUserList();
        System.out.println("list大小为：" + list.size());
        Long startTime = System.currentTimeMillis();
        System.out.println("开始查找数据：" + startTime);
        Integer collect = list.stream().collect(Collectors.summingInt(User::getAge));

        Long endTime = System.currentTimeMillis();
        System.out.println("stream消耗时间为：" + String.valueOf(endTime - startTime));

        Integer collect2 = list.parallelStream().collect(Collectors.summingInt(User::getAge));
        Long endTime2 = System.currentTimeMillis();
        System.out.println("parallelSteam消耗时间为：" + String.valueOf(endTime2 - endTime));

        List<User> jizy666 = list.parallelStream().filter(user ->
             user.getName().equals("jizy6666666")).collect(Collectors.toList());

        Long endTime3 = System.currentTimeMillis();
        System.out.println(jizy666);
        System.out.println("查找时间为："+String.valueOf(endTime3-endTime2));

        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getName().equals("jizy666666")) {
                System.out.println("找到了，时间为："+String.valueOf(System.currentTimeMillis()-endTime3));
            }
        }
        System.out.println(String.valueOf(System.currentTimeMillis()-endTime3));



    }

    public static List<User> initUserList() {
        List list = new ArrayList<User>();
        for (int i = 0; i < 10000000; i++) {
            User user = new User();
            user.setName("jizy" + i);
            user.setAge(i);
            user.setGender(1);
            list.add(user);
        }
        return list;
    }
}
