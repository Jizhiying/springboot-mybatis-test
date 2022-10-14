package com.sunyard.springboot.mapper;

import com.sunyard.springboot.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    public int insertEmp(Employee employee);

    public Employee getEmpById(Integer id);
}
