package com.bl.day2728.io.problem;

import java.io.*;
import java.util.List;

public class EmployeePayrollFileService {
    public static void writeToFile(List<EmployeePayrollService> employees, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (EmployeePayrollService emp : employees) {
                writer.write(emp.toString());
                writer.newLine();
            }
            System.out.println("Employee payroll written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countEntries(String filePath) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void printPayrolls(String filePath) {
        System.out.println("--- Employee Payrolls from File ---");
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total Payroll Entries Printed: " + count);
    }

    public static int getNumberOfEntries(String filePath) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static void analyzePayrollFile(String filePath) {

        int employeeCount = 0;
        double totalSalary = 0;
        double maxSalary = Double.MIN_VALUE;
        double minSalary = Double.MAX_VALUE;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                double salary = Double.parseDouble(data[2]);

                employeeCount++;
                totalSalary += salary;

                maxSalary = Math.max(maxSalary, salary);
                minSalary = Math.min(minSalary, salary);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double averageSalary = employeeCount > 0 ? totalSalary / employeeCount : 0;

        System.out.println("--- Payroll Analysis ---");
        System.out.println("Total Employees : " + employeeCount);
        System.out.println("Total Salary    : " + totalSalary);
        System.out.println("Average Salary  : " + averageSalary);
        System.out.println("Max Salary      : " + maxSalary);
        System.out.println("Min Salary      : " + minSalary);
    }
}
