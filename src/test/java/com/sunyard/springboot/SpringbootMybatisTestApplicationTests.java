package com.sunyard.springboot;

import com.sunyard.service.MyJsonService;
import com.sunyard.springboot.entity.MyEntity;
import com.sunyard.springboot.entity.Person;
import com.sunyard.springboot.entity.TestEntity;
import com.sunyard.springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.config.ScheduledTask;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class SpringbootMybatisTestApplicationTests {
    @Autowired
    MyJsonService myJsonService;
    private final Map<Object, Set<ScheduledTask>> scheduledTasks = new IdentityHashMap<>(16);

    @Test
    void contextLoads() {
        Person person = new Person("jizy",18);
        System.out.println(myJsonService.objectToMyJson(person));
    }

    @Test
    void test1() {
        List list = new ArrayList(3);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.add(2,10);
        System.out.println(list);
        HashMap<String,Object> hs = new HashMap();
        hs.put("name","jizy");
        hs.put("age",2);
        hs.put("address","南京");
        hs.forEach((k,v) -> {
            if (k.equals("age")) {
                hs.put(k,"29");
            }
        });
        System.out.println(hs);
        for (Map.Entry<String,Object> entry : hs.entrySet()) {
            if (entry.getKey().equals("name")) {
//                hs.remove(entry.getKey());
            }
        }

        Iterator<Map.Entry<String, Object>> iterator = hs.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            if (next.getKey().equals("name")) {
                iterator.remove();
            }
            System.out.println(next.getKey()+":"+next.getValue());
        }
    }


}
