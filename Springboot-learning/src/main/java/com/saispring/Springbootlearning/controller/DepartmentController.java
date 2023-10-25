package com.saispring.Springbootlearning.controller;

import com.saispring.Springbootlearning.entity.Department;
import com.saispring.Springbootlearning.error.DepartmentNotFoundException;
import com.saispring.Springbootlearning.service.DepartmentService;
import com.saispring.Springbootlearning.service.DepartmentServiceImplementation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController  {
    @Autowired
    private DepartmentService departmentservice;
    private final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        log.info("New Department object has been added");
        return departmentservice.saveDepartment(department);
    }

    @GetMapping("/getDepartments")
    public List<Department> getDepartments(){
        log.info("Info retrieved");
        return departmentservice.getDepartments();
    }

    @GetMapping("/getDepartments/{id}")
    public Department getDepartmentbyId(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentservice.getDepartmentbyId(id);
    }
    @GetMapping("/getDepartments/name/{name}")
    public Department getDepartmentbyname(@PathVariable("name") String name){
        return departmentservice.getDepartmentbyname(name);
    }

    @DeleteMapping("/getDepartments/{id}")
    public String deleteDepartmentbyId(@PathVariable("id") Long id){
        departmentservice.deleteDepartmentbyId(id);
        return "Deletion Successful";
    }

    @PutMapping("/getDepartments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department){
        return departmentservice.updateDepartment(id, department);
    }


}
