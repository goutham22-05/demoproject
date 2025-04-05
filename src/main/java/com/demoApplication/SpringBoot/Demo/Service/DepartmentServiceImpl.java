package com.demoApplication.SpringBoot.Demo.Service;


import com.demoApplication.SpringBoot.Demo.Entity.Department;
import com.demoApplication.SpringBoot.Demo.Exception.DepartmentNotFoundException;
import com.demoApplication.SpringBoot.Demo.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
         if(!department.isPresent()){
             throw new DepartmentNotFoundException("department not found");
         }
         return department.get();
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

