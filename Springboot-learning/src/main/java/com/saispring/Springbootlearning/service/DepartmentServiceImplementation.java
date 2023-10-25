package com.saispring.Springbootlearning.service;

import com.saispring.Springbootlearning.entity.Department;
import com.saispring.Springbootlearning.error.DepartmentNotFoundException;
import com.saispring.Springbootlearning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentbyId(Long id) throws DepartmentNotFoundException {
        //return departmentRepository.findById(id).get();
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isPresent() == false){
            throw new DepartmentNotFoundException("Not found");
        }
        return department.get();

    }

    @Override
    public void deleteDepartmentbyId(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department fromDB = departmentRepository.findById(id).get();
        if (Objects.nonNull(department.getDepartmentName()) && !department.getDepartmentName().equals("")){
            fromDB.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentAddress()) && !department.getDepartmentAddress().equals("")){
            fromDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && !department.getDepartmentCode().equals("")){
            fromDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(fromDB);
    }

    @Override
    public Department getDepartmentbyname(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }
}
