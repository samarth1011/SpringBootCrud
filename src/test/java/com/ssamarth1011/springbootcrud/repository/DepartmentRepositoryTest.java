package com.ssamarth1011.springbootcrud.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.ssamarth1011.springbootcrud.entity.Department;

@DataJpaTest
public class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentrepository;
    
    @Autowired
    private TestEntityManager entityManager; 

    @BeforeEach
    void setUp(){
        Department department = Department.builder().departmentName("Mechanical").departmentCode("344").departmentAddress("Delhi").build();
        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentrepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Mechanical");
        
    }

}
