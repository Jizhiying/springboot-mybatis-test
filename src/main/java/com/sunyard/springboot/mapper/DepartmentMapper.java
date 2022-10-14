package com.sunyard.springboot.mapper;

import com.sunyard.springboot.entity.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public abstract Department selectDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public abstract int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department (departmentName) values (#{departmentName})")
    public abstract int insertDept(Department department);

    @Update("update department set departmentName = #{departmentName} where id = #{#id}")
    public abstract int updateDept(Department department);
}
