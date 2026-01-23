package com.bl.day35.jdbc;

import java.sql.*;
import java.time.LocalDate;

public class EmployeePayrollDBService {

    public EmployeePayroll addEmployeeToDB(String name, double salary, String gender) throws EmployeePayrollException {
        String sql = "insert into payroll_service.employee_payroll (name, salary, gender, start_date) values (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, salary);
            preparedStatement.setString(3, gender);
            preparedStatement.setDate(4, java.sql.Date.valueOf(LocalDate.now()));

            int result = preparedStatement.executeUpdate();

            if (result == 0) {
                throw new EmployeePayrollException("Employee insert failed");
            }
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                return new EmployeePayroll(id, name, salary, gender, LocalDate.now());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmployeePayrollException("Unable to insert employee payroll");
        }
        return null;
    }
}
