package oopsandds.day10.practice;

public class EmpWageBuilder {
    public static final int FULL_TIME_EMPLOYEE = 1;
    public static final int PART_TIME_EMPLOYEE = 2;

    private String name;
    private int wagePerHour;
    private int maxWorkingDays;
    private int maxWorkingHours;
    private double totalWage;

    public EmpWageBuilder(String name, int wagePerHour, int maxWorkingDays, int maxWorkingHours, int totalWage) {
        this.name = name;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.totalWage = totalWage;
    }

    public String getName() {
        return name;
    }

    public double getTotalWage() {
        return totalWage;
    }

    public void calculateEmployeeWage() {
        int totalHours = 0;
        int totalDays = 0;
        int hour = 0;

        while (totalDays < maxWorkingDays && totalHours < maxWorkingHours) {
            int employeePresentCheck = isEmployeePresent();
            switch (employeePresentCheck) {
                case FULL_TIME_EMPLOYEE:
                    hour = 8;
                    break;
                case PART_TIME_EMPLOYEE:
                    hour = 4;
                default:
                    hour = 0;
            }
            totalHours += hour;
        }

        totalWage = calculateWage(totalHours, wagePerHour);
    }

    public static int isEmployeePresent() {
        return (int) (Math.random() * 3);
    }

    public static double calculateWage(int workingHours, int employeeWage) {
        return workingHours * employeeWage;
    }

}
