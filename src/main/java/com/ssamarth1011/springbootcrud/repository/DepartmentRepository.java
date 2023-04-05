package com.ssamarth1011.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.ssamarth1011.springbootcrud.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department  findByDepartmentName(String departmentName);
    public Department  findByDepartmentNameIgnoreCase(String departmentName);
}
