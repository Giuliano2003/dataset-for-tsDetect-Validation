
package com.example.Springbootpractice.Service;

import com.example.Springbootpractice.Entity.Department;
import com.example.Springbootpractice.Repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/* https://github.com/prajvals/Advanced-Spring-boot-with-Testing/blob/main/src/test/java/com/example/Springbootpractice/Service/DepartmentServiceImpTest.java */

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImpTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    //this is the function that it will run before any of the function run anytime alright
    //there is one before all too alright yeah
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentName("IT")
                .departmentAddress("Ahemdabad")
                .departmentCode("IT-06")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}
/*
how unit testing works is, we test for that unit only, and we use the mocks of what it is actually dependent on alright.
the mokito is used to mock the object and we create the object and tell mockito to give this object when this function is called alright
and for this the object of which we are creating we call it is mockBean alright yeah
 */
