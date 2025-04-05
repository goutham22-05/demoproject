package com.demoApplication.SpringBoot.Demo.Repository;

import com.demoApplication.SpringBoot.Demo.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentCode(String departmentCode);

    public Department getByDepartmentAddress(String departmentAddress);



}
