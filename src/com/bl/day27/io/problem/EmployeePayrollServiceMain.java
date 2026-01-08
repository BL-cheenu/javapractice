package com.bl.day27.io.problem;

import java.util.Scanner;

public class EmployeePayrollServiceMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        EmployeePayrollService payrollService = new EmployeePayrollService(id, name, salary);
        System.out.println("--- Employee Payroll Details ---");
        payrollService.display();

    }
}
