package oopsandds.day8.practice;

public class EmployeeWageComputationObjectUC6 {
    public static final int FULL_TIME_EMPLOYEE = 1;
    public static final int PART_TIME_EMPLOYEE = 2;

    public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOUR = 8;
    public static final int PART_TIME_HOUR = 4;

    public static final int MAX_WORKING_DAYS = 20;
    public static final int MAX_WORKING_HOURS = 100;


    public static int isEmployeePresent() {
        return (int) (Math.random() * 3);
    }

    public static int calculateEmployeeWorkingHours(int isEmployeePresent) {
        switch (isEmployeePresent) {
            case FULL_TIME_EMPLOYEE:
                return FULL_DAY_HOUR;
            case PART_TIME_EMPLOYEE:
                return PART_TIME_HOUR;
            default:
                return 0;
        }
    }

    public static double calculateWage(int workingHours) {
        return workingHours * WAGE_PER_HOUR;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");

        int totalWorkingHours = 0;
        int totalWorkingDays = 0;

        while (totalWorkingHours < MAX_WORKING_HOURS &&  totalWorkingDays < MAX_WORKING_DAYS) {

            totalWorkingDays++;

            int employeeType = isEmployeePresent();
            int dailyHours = calculateEmployeeWorkingHours(employeeType);

            if (totalWorkingHours + dailyHours > MAX_WORKING_HOURS) {
                break;
            }
            totalWorkingHours += dailyHours;
        }

        double totalMonthlyWage = calculateWage(totalWorkingHours);
        System.out.println("Monthly wage is: " + totalMonthlyWage);
    }
}
