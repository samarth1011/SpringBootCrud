package com.ssamarth1011.springbootcrud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssamarth1011.springbootcrud.entity.Department;
import com.ssamarth1011.springbootcrud.error.DepartmentNotFoundException;
import com.ssamarth1011.springbootcrud.service.DepartmentService;
// import com.ssamarth1011.springbootcrud.service.DepartmentServiceImpl;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    
    public Department saveDepartment(@Valid @RequestBody  Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getdepartments")
    public List<Department> fetchDepartmantList(){
        LOGGER.info("Inside fetchDepartmantList of DepartmentController");
        return departmentService.fetchDepartmantList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmantById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException{
        LOGGER.info("Inside fetchDepartmantById of DepartmentController");
        return departmentService.fetchDepartmantById(departmentId);
    }

    @DeleteMapping("/deletedepartment/{id}")
    public String deleteDepartmantById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside deleteDepartmantById of DepartmentController");
        departmentService.deleteDepartmantById(departmentId);
        return "Department with id: "+ departmentId+" Deleted Successfully!";
    }

    @PutMapping("/updatedepartment/{id}")
    public Department updateDepartmantById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside updateDepartmantById of DepartmentController");
        return departmentService.updateDepartmantById(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
