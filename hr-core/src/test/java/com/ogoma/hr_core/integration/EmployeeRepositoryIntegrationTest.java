//package com.ogoma.vue_starter.vue_starter.integration;
//
//import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
//import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
//import com.ogoma.vue_starter.vue_starter.enums.GenderEnum;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.math.BigDecimal;
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
//@ActiveProfiles("test")
//public class EmployeeRepositoryIntegrationTest {
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Test
//    public void testCanFilterEmployeesByGender() {
//        Employee maleEmployee = new Employee();
//        maleEmployee.setKraPinNumber("999999");
//        maleEmployee.setActive(true);
//        maleEmployee.setGender(GenderEnum.M);
//        maleEmployee.setSalaryAmount(new BigDecimal(1000));
//        maleEmployee.setNhifNumber("7177172772");
//        maleEmployee.setNssfNumber("7177166672772");
//        maleEmployee.setJoiningDate(Date.from(Instant.now()));
//
//        Employee femaleEmployee = new Employee();
//        maleEmployee.setKraPinNumber("999999");
//        maleEmployee.setActive(true);
//        maleEmployee.setGender(GenderEnum.F);
//        maleEmployee.setSalaryAmount(new BigDecimal(1000));
//        maleEmployee.setNhifNumber("7177172772");
//        maleEmployee.setNssfNumber("7177166672772");
//        maleEmployee.setJoiningDate(Date.from(Instant.now()));
//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(femaleEmployee);
//        employeeList.add(maleEmployee);
//        this.employeeRepository.saveAll(employeeList);
//        Assert.assertEquals(1l,this.employeeRepository.findAllByGender(GenderEnum.F).size());
//    }
//}
