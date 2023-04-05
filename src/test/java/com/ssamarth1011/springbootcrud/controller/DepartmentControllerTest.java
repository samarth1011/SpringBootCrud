package com.ssamarth1011.springbootcrud.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jayway.jsonpath.JsonPath;
import com.ssamarth1011.springbootcrud.entity.Department;
import com.ssamarth1011.springbootcrud.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
     
    @BeforeEach
    void setUp(){
        Department department = Department.builder().departmentName("Mechanical").departmentCode("344").departmentAddress("Delhi").departmentId(1L).build();
    }
    @Test
    void testFetchDepartmantById() throws Exception{

        Mockito.when(departmentService.fetchDepartmantById(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
        
                

    }

   
    @Test
    void testSaveDepartment() throws Exception {
        Department inputDepartment = Department.builder().departmentName("Mechanical").departmentCode("344").departmentAddress("Delhi").departmentId(1L).build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "\t\"departmentName\":\"IT\",\n" +
                "\t\"departmentAddress\":\"Ahmedabad\",\n" +
                "\t\"departmentCode\":\"IT-06\"\n" +
                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
