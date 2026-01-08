package com.bl.day27.io.problem;

import java.io.File;
import java.io.IOException;
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

        String directoryPath = "EmployeeData";
        String filePath = directoryPath + "/employee.txt";

        File directory = new File(directoryPath);
        File file = new File(filePath);

        System.out.println("File exist: " + file.exists());
        if (!directory.exists()) {
            System.out.println("File exists: " + directory.mkdir());
        }

        try {
            if (!file.createNewFile()) {
                System.out.println("Empty file created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Listing files & directories: ");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getName());
            }
        }

        System.out.println("Listing .txt files: ");
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    System.out.println(f.getName());
                }
            }
        }

        if (file.delete()) {
            System.out.println("File deleted successfully");
        }
        System.out.println("File exists after deletion: " + file.exists());
    }
}
