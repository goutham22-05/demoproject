package com.demoApplication.SpringBoot.Demo.Controller;

import com.demoApplication.SpringBoot.Demo.Entity.Department;
import com.demoApplication.SpringBoot.Demo.Exception.DepartmentNotFoundException;
import com.demoApplication.SpringBoot.Demo.Service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")     //validation
    public Department saveDepartment(@Valid  @RequestBody Department department) {
            logger.info("inside save department of department controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getdepartment")
    public List<Department> fetchDepartment()
    {
        return departmentService.fetchDepartment();
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        logger.info("inside get mapping");
        Department department = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/{departmentId}")
    public String deleteDepartmentById(@PathVariable Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "deleted successfully";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);

    }

    @GetMapping("/{code}")
    public Department findByDepartmentCode(@PathVariable("code") String departmentCode) {
        return departmentService.findByDepartmentCode(departmentCode);
    }

    @GetMapping("/department/Address/{Add}")
    public Department getByDepartmentAddress(@PathVariable("Add") String departmentAddress) {
        return departmentService.getByDepartmentAddress(departmentAddress);

    }



}
