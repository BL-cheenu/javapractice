package oopsandds.day10.practice;

public class EmployeeWageComputation {
    public static final int FULL_TIME_EMPLOYEE = 1;
    public static final int PART_TIME_EMPLOYEE = 2;

    public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOUR = 8;
    public static final int PART_TIME_HOUR = 4;
    public static final int WORKING_DAY_PER_MONTH = 20;

    // UC1
    public static int isEmployeePresent() {
        return (int) (Math.random() * 3);
    }

    // UC2
    public static double calculateWage(int workingHours) {
        return workingHours * WAGE_PER_HOUR;
    }

    // UC3 && UC4
    public static double calculateDailyEmployeeWage(int isEmployeePresent) {
        double dailyWage = 0.0;
        switch (isEmployeePresent) {
            case FULL_TIME_EMPLOYEE:
                dailyWage = calculateWage(FULL_DAY_HOUR);
                break;
            case PART_TIME_EMPLOYEE:
                dailyWage = calculateWage(PART_TIME_HOUR);
                break;
            default:
                dailyWage = calculateWage(0);
        }
        return dailyWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");
        double totalMonthlyWage = 0.0;

        // UC5
        for (int day = 1; day <= WORKING_DAY_PER_MONTH; day++) {
            int employeePresentCheck = isEmployeePresent();
            double dailyWage = calculateDailyEmployeeWage(employeePresentCheck);
            System.out.println("Employee Daily wage is: " + dailyWage);
            totalMonthlyWage += dailyWage;
        }
        System.out.println("Monthly wage of is: " + totalMonthlyWage);
    }
}
