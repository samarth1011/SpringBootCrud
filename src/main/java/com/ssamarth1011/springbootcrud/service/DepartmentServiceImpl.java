package com.ssamarth1011.springbootcrud.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssamarth1011.springbootcrud.entity.Department;
import com.ssamarth1011.springbootcrud.error.DepartmentNotFoundException;
import com.ssamarth1011.springbootcrud.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment (Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmantList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmantById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =  departmentRepository.findById(departmentId);
        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        } 
        return department.get();
    }

    @Override
    public void deleteDepartmantById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return;
    
    }

    @Override
    public Department updateDepartmantById(Long departmentId, Department department) {

        Department depDb = departmentRepository.findById(departmentId).get();
        
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDb.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDb);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
       return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

 
}
