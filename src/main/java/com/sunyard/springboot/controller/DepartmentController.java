package com.sunyard.springboot.controller;

import com.sunyard.springboot.entity.Department;
import com.sunyard.springboot.mapper.DepartmentMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class DepartmentController {

    @Resource
    DepartmentMapper departmentMapper;

    @ResponseBody
    @GetMapping("/dept")
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }
    @ResponseBody
    @GetMapping("/dept/{id}")
    public Department selectDeptById(@PathVariable("id") Integer id){
        return departmentMapper.selectDeptById(id);
    }

}
