package com.bl.day35.jdbc;

import java.sql.*;
import java.time.LocalDate;

public class EmployeePayrollDBService {
    private static EmployeePayrollDBService dbService;
    public static EmployeePayroll addEmployeeToDB(String name, double salary, String gender) throws EmployeePayrollException {
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
            throw new EmployeePayrollException("Unable to insert employee payroll", e);
        }
        return null;
    }

    public static EmployeePayroll addEmployeeWithPayrollDetails(String name, double salary, String gender) throws EmployeePayrollException {

        String employeeSql = "insert into payroll_service.employee_payroll (name, salary, gender, start_date) values (?, ?, ?, ?)";
        String payrollSql = "insert into payroll_service.payroll_details (employee_id, basic_pay, deductions, taxable_pay, tax, net_pay) values (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement empStmt =connection.prepareStatement(employeeSql, Statement.RETURN_GENERATED_KEYS)) {

                empStmt.setString(1, name);
                empStmt.setDouble(2, salary);
                empStmt.setString(3, gender);
                empStmt.setDate(4,java.sql.Date.valueOf(LocalDate.now()));
                empStmt.executeUpdate();

                ResultSet rs = empStmt.getGeneratedKeys();
                if (!rs.next()) {
                    connection.rollback();
                    throw new EmployeePayrollException("Employee insert failed", null);
                }
                int employeeId = rs.getInt(1);
                double deductions = salary * 0.20;
                double taxablePay = salary - deductions;
                double tax = taxablePay * 0.10;
                double netPay = salary - tax;
                try (PreparedStatement payrollStmt = connection.prepareStatement(payrollSql)) {
                    payrollStmt.setInt(1, employeeId);
                    payrollStmt.setDouble(2, salary);
                    payrollStmt.setDouble(3, deductions);
                    payrollStmt.setDouble(4, taxablePay);
                    payrollStmt.setDouble(5, tax);
                    payrollStmt.setDouble(6, netPay);
                    payrollStmt.executeUpdate();
                }
                connection.commit();
                return new EmployeePayroll(employeeId, name, salary, gender,LocalDate.now());
            }
        } catch (Exception e) {
            throw new EmployeePayrollException("Unable to add employee with payroll details", e);
        }
    }
}
