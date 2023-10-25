package com.saispring.Springbootlearning.service;

import com.saispring.Springbootlearning.entity.Department;
import com.saispring.Springbootlearning.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentbyId(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentbyId(Long id);

    public Department updateDepartment(Long id, Department department);

    public Department getDepartmentbyname(String name);
}
