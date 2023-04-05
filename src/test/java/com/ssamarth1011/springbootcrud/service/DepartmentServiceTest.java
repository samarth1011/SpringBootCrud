package com.ssamarth1011.springbootcrud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ssamarth1011.springbootcrud.entity.Department;
import com.ssamarth1011.springbootcrud.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {
    
    @Autowired
    private DepartmentService departmentService;
    
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp(){
        Department department = Department.builder().departmentName("Comp").departmentAddress("Pune").departmentCode("612").departmentId(1L).build();
         Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Comp")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){

        String departmentName = "Comp";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}
