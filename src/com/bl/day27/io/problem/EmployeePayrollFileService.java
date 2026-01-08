package com.bl.day27.io.problem;

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
}
