package com.bl.day27.io.problem;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.util.*;

public class EmployeePayrollServiceMain {
    private static final Map<WatchKey, Path> keyMap = new HashMap<>();


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        EmployeePayrollService employee = new EmployeePayrollService(id, name, salary);
        employee.display();

        String directoryPath = "EmployeeData";
        String filePath = directoryPath + "/employee.txt";

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        File file = new File(filePath);
        System.out.println("\nFile exist: " + file.exists());

        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("Empty file created");
            }
        } else {
            System.out.println("File already exists");
        }

        System.out.println("Listing files & directories:");
        for (File f : directory.listFiles()) {
            System.out.println(f.getName());
        }

        System.out.println("Listing .txt files:");
        for (File f : directory.listFiles()) {
            if (f.isFile() && f.getName().endsWith(".txt")) {
                System.out.println(f.getName());
            }
        }

        List<EmployeePayrollService> employees = Arrays.asList(
                employee,
                new EmployeePayrollService(101, "Alice", 55000),
                new EmployeePayrollService(102, "Bob", 60000)
        );

        EmployeePayrollFileService.writeToFile(employees, filePath);
        System.out.println("Total payroll entries: " + EmployeePayrollFileService.countEntries(filePath));

        EmployeePayrollFileService.printPayrolls(filePath);
        DirectoryWatchService.countEntries(directory);
        DirectoryWatchService.watchDirectory(directoryPath);

        int entries = EmployeePayrollFileService.getNumberOfEntries(filePath);
        System.out.println("Number of Employee Payroll Entries: " + entries);

        EmployeePayrollFileService.analyzePayrollFile(filePath);

    }
}
