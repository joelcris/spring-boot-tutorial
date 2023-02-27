package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("TEST")
                        .departmentAddress("TestCity")
                        .departmentCode("TST-XX")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository
                .findByDepartmentNameIgnoreCase("TEST"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data base on valid department name")
    public void whenValidDepartmentName_thenDepartmentShouldfound() {
        String departmentName = "TEST";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}