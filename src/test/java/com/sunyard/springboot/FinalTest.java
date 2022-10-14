package com.sunyard.springboot;

import java.util.*;
import java.util.stream.Collectors;

public class FinalTest {
    private final List<Integer> list;

    public FinalTest(List<Integer> list) {
        this.list = list;
    }


    public static void main(String[] args) {
        say(null);

    }

    public static void say(Integer num1) {
        if (1 == num1) {
            System.out.println(1);
        }
    }



   static class Product{

    }
}
