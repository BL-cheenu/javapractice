package day34.jdbc;

import com.bl.day34.jdbc.DBConnection;
import com.bl.day34.jdbc.EmployeePayroll;
import com.bl.day34.jdbc.EmployeePayrollException;
import com.bl.day34.jdbc.EmployeePayrollServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeePayrollServiceTest {
    private EmployeePayrollServiceImpl employeePayrollService = new EmployeePayrollServiceImpl();

    @Test
    public void givenEmployeePayrollDB_WhenRetrieved_ShouldReturnEmployeeList() throws EmployeePayrollException {
        List<EmployeePayroll> employeePayrolls = employeePayrollService.getEmployeePayrolls();
        Assertions.assertNotNull(employeePayrolls);
        Assertions.assertTrue(employeePayrolls.size() > 0);
    }

    @Test
    public void givenNewSalary_WhenUpdated_ShouldSyncWithDB() throws EmployeePayrollException, SQLException {
        String employeeName = "Emily Davis";
        double updatedSalary = 3000000.00;
        employeePayrollService.updateEmployeeSalary(employeeName, updatedSalary);

        boolean isSynced = isEmployeePayrollInSyncWithDB(employeeName, updatedSalary);
        Assertions.assertTrue(isSynced);
    }

    private boolean isEmployeePayrollInSyncWithDB(String employeeName, double updatedSalary) throws EmployeePayrollException, SQLException {
        String sql = "select salary from payroll_service.employee_payroll where name = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, employeeName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("salary") == updatedSalary;
            }
            return false;
        }
    }
}
