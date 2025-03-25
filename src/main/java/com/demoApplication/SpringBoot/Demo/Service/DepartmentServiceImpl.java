package com.demoApplication.SpringBoot.Demo.Service;


import com.demoApplication.SpringBoot.Demo.Entity.Department;
import com.demoApplication.SpringBoot.Demo.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);

    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).
                orElseThrow(() -> new RuntimeException("department not found" + departmentId));
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        return departmentRepository.findById(departmentId).
                map(department1 -> {
                    department1.setDepartmentName(department.getDepartmentName());
                    department1.setDepartmentAddress(department.getDepartmentAddress());
                    department1.setDepartmentCode(department.getDepartmentCode());
                    Department save = departmentRepository.save(department1);
                    return save;

                }).orElseThrow(() -> new RuntimeException("Department not found with id" + " " + departmentId));
    }

    @Override
    public Department findByDepartmentCode(String departmentCode) {
        return departmentRepository.findByDepartmentCode(departmentCode);
    }

    @Override
    public Department getByDepartmentAddress(String departmentAddress) {
        return departmentRepository.getByDepartmentAddress(departmentAddress);
    }


}

