package com.bl.day35.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeePayrollServiceTest {
    @Test
    public void givenNewEmployee_WhenAdded_ShouldSyncWithDB() throws EmployeePayrollException{
        EmployeePayrollServiceImpl employeePayrollService = new EmployeePayrollServiceImpl();
        EmployeePayroll employeePayroll=  employeePayrollService.addEmployeePayroll("cheenu", 30000.0, "M");

       Assertions.assertNotNull(employeePayroll);
       Assertions.assertTrue(employeePayroll.getId()>0);

    }
}
