package com.sunyard.springboot.mapper;

import com.sunyard.springboot.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface TestEntityMapper {
    public int insertTestEntity(TestEntity testEntity);

    List<TestEntity> getAllTestEntity();

}
