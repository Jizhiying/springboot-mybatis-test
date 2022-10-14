package com.sunyard.springboot.controller;

import com.sunyard.springboot.entity.TestEntity;
import com.sunyard.springboot.mapper.TestEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestEntityController {
    @Autowired
    TestEntityMapper testEntityMapper;

    @GetMapping("/getTestEntity")
    public String getTestEntity() {
//        return testEntityMapper.getAllTestEntity().toString();
        return "success";
    }

    @PostMapping("/insertTestEntity")
    public int insertTestEntity(@RequestBody TestEntity testEntity) {
        return testEntityMapper.insertTestEntity(testEntity);
    }
}
