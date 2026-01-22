package com.bl.day34.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollServiceImpl {
    public List<EmployeePayroll> getEmployeePayrolls() throws EmployeePayrollException {
        List<EmployeePayroll> employeePayrolls = new ArrayList<>();

        String sql = "select id, name, salary, start_date from payroll_service.employee_payroll";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();

                employeePayrolls.add(new EmployeePayroll(id, name, salary, startDate));
            }
        } catch (SQLException e) {
            throw new EmployeePayrollException("Unable to get the data");
        }
        return employeePayrolls;
    }
}
