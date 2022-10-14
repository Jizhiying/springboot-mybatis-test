package com.sunyard.springboot;

import com.sunyard.springboot.entity.Jifen;
import com.sunyard.springboot.entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        List<User> list = Arrays.asList(new User("纪志颖",29,0,"南京"),
//                new User("张蓉娟",28,1,"南京"),
//                new User("纪福军",52,0,"如皋"),
//                new User("徐桂林",53,1,"如皋"),
//                new User("纪禹臣",5,0,"如皋"),
//                new User("纪显余",70,0,"袁桥"));
        //filter过滤  filter(T -> boolean)
//        List<User> collect = list.stream().filter(a1 -> a1.getAge() >= 50).collect(Collectors.toList());
//        System.out.println(collect);

        System.out.println(4 >> 1);

        List<User> list = Arrays.asList(new User("纪志颖",29,0,"南京"),
                new User("张蓉娟",28,1,"南京"),
                new User("张蓉娟",28,1,"南京"),
                new User("纪福军",52,0,"如皋"),
                new User("徐桂林",53,1,"如皋"),
                new User("纪禹臣",5,0,"如皋"),
                new User("纪禹臣",3,0,"如皋"),
                new User("纪显余",70,0,"袁桥"));

        List<User> 积分清零 = list.stream().filter(user -> user.getAddress().equals("积分清零")).collect(Collectors.toList());

        Map<String, List<User>> collect3 = list.stream().collect(Collectors.groupingBy(User::getName));//分组后的记录



        List<User> resultList = new ArrayList<>();



        //distinct 去重  对对象去重，要重写类的equls和hashcode方法
        List<User> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
        List<User> collect1 = collect.stream().sorted().collect(Collectors.toList());
//        collect.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
//        Comparator.comparingInt(User::getAge);
        System.out.println(collect1);

        IntSummaryStatistics collect2 = list.stream().collect(Collectors.summarizingInt(User::getAge));
        System.out.println(collect2);

        //limit 返回前n个元素
        List<User> limitList = collect1.stream().limit(2).collect(Collectors.toList());
        System.out.println(limitList);


        //映射 map(T -> R)

        List<String> mapList = list.stream().map(user -> user.getName()).distinct().collect(Collectors.toList());
        System.out.println(mapList);

        //查找  allMatch(T -> boolean)
        //查找list中是否所有人岁数大于18
        boolean b = list.stream().allMatch(user -> user.getAge() > 18);
        System.out.println(b);

        // anyMatch 是否存在一个  noneMatch 不存在

        //findFirst() 在并行流中，findAny就是随机查找的，串行流中查找的第一个 findAny()
        Optional<User> first = list.stream().findFirst();
        System.out.println(first);

        Optional<User> any = list.stream().findAny();
        System.out.println(any);

        //归纳计算

        //求总和，我理解的就是集合的大小
        long count = list.stream().count();
        int size = list.size();
        System.out.println(count+","+size);

        //求某一属性的最大值或最小值
        Optional<User> maxAge = list.stream().collect(Collectors.maxBy(Comparator.comparing(User::getAge)));
        System.out.println(maxAge.get().getAge());

        Optional<User> minAge = list.stream().collect(Collectors.minBy(Comparator.comparing(User::getAge)));
        System.out.println(minAge.get().getAge());

        //求年龄总哈
        Integer sumAge = list.stream().collect(Collectors.summingInt(User::getAge));
        System.out.println(sumAge);

        //平均值
        Double avgAge = list.stream().collect(Collectors.averagingInt(User::getAge));
        System.out.println(avgAge);

        //一次性得到元素总数、总和、最大值、最小值  ?????


        //字符串拼接
        String str1 = list.stream().map(User::getName).collect(Collectors.joining(","));
        System.out.println(str1);

        //分组  根据地址分组，返回一个map，key为地址，value为List<User>
        Map<String, List<User>> map1 = list.stream().collect(Collectors.groupingBy(User::getAddress));
        System.out.println(map1);
        StringBuffer sb = new StringBuffer();
        list.stream().forEach(sb::append);

        //二级分组
        Map<String, Map<Integer, List<User>>> map2 = list.stream().collect(Collectors.groupingBy(User::getAddress,
                Collectors.groupingBy(User::getGender)));
        System.out.println(map2);

        //每个城市的所有人年龄的总和
        Map<String, Integer> map3 = list.stream().collect(Collectors.groupingBy(User::getAddress,
                Collectors.summingInt(User::getAge)));
        System.out.println(map3);



        List<Jifen> allList = new ArrayList<>();
        Jifen jifen = new Jifen();

//        allList.stream().collect(Collectors.groupingBy());



    }
}

