package com.ssamarth1011.springbootcrud.service;

import java.util.List;

import com.ssamarth1011.springbootcrud.entity.Department;
import com.ssamarth1011.springbootcrud.error.DepartmentNotFoundException;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmantList();

    public Department fetchDepartmantById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmantById(Long departmentId);

    public Department updateDepartmantById(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
    
}
