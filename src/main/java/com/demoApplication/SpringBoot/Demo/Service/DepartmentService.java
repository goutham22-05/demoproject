package com.demoApplication.SpringBoot.Demo.Service;

import com.demoApplication.SpringBoot.Demo.Entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

    public Department getDepartmentById(Long departmentId);

    public void deleteDepartmentById(Long departmentId);



    public Department updateDepartment(Long departmentId, Department department);


    public Department findByDepartmentCode(String departmentCode);

    public Department getByDepartmentAddress(String departmentAddress);


}
