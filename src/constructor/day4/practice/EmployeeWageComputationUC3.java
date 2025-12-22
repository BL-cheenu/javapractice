package constructor.day4.practice;

public class EmployeeWageComputationUC3 {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");
        int empWage = 0;

        int isEmployeePresent = getEmployeePresence();

        if (isEmployeePresent == EmployeeConstant.IS_FULL_TIME) {
            empWage = EmployeeWageComputationUC2.calculateDailyEmployeeWage(EmployeeConstant.FULL_DAY_HOUR);
        } else if (isEmployeePresent == EmployeeConstant.IS_PART_TIME) {
            empWage = EmployeeWageComputationUC2.calculateDailyEmployeeWage(EmployeeConstant.PART_TIME_HOUR);
        } else {
            empWage = 0;
        }
        System.out.println("Employee Wage Daily: " + empWage);

    }

    public static int getEmployeePresence() {
        return (int) (Math.random() * 3);
    }

}
