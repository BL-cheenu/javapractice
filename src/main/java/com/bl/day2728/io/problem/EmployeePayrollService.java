package com.bl.day2728.io.problem;

public class EmployeePayrollService {
    public int id;
    public String name;
    public double salary;

    public EmployeePayrollService(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee Id   : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Salary        : " + salary);
    }

    @Override
    public String toString() {
        return "EmployeePayrollService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
