package oopsandds.day10.practice;

public class EmployeeWageMain {
    public static void main(String[] args) {
        EmpWageBuilder tcs = new EmpWageBuilder("TCS", 20, 20, 100, 0);
        EmpWageBuilder zoho = new EmpWageBuilder("Zoho", 30, 22, 110, 0);

        tcs.calculateEmployeeWage();
        zoho.calculateEmployeeWage();

        System.out.println("Total Wage of " + tcs.getName() + " : " + tcs.getTotalWage());
        System.out.println("Total Wage of " + zoho.getName() + " : " + zoho.getTotalWage());
    }

}
