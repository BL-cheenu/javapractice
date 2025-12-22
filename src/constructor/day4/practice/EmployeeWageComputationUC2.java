package constructor.day4.practice;


public class EmployeeWageComputationUC2 {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");

        int empWage = 0;
        int isEmployeePresent = getEmployeePresence();

        if (isEmployeePresent == EmployeeConstant.IS_FULL_TIME) {
            empWage = calculateDailyEmployeeWage(EmployeeConstant.FULL_DAY_HOUR);
        } else {
            empWage = calculateDailyEmployeeWage(0);
        }
        System.out.println("Employee Wage Daily: " + empWage);
    }

    public static int calculateDailyEmployeeWage(int workingHours) {
        return workingHours * EmployeeConstant.WAGE_PER_HOUR;
    }

    private static int getEmployeePresence() {
        return (int) (Math.random() * 2);
    }
}
