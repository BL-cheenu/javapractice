package constructor.day4.practice;

public class EmployeeWageComputationUC5 {
    public static void main(String[] args) {
        int empWage = 0;
        int totalEmpWage = 0;

        for (int day = 0; day < EmployeeConstant.NUM_OF_WORKING_DAYS; day++) {

            int isEmployeePresent = EmployeeWageComputationUC3.getEmployeePresence();
            switch (isEmployeePresent) {
                case EmployeeConstant.IS_FULL_TIME:
                    empWage = EmployeeWageComputationUC2.calculateDailyEmployeeWage(EmployeeConstant.FULL_DAY_HOUR);
                    break;
                case EmployeeConstant.IS_PART_TIME:
                    empWage = EmployeeWageComputationUC2.calculateDailyEmployeeWage(EmployeeConstant.PART_TIME_HOUR);
                    break;
                default:
                    empWage = EmployeeWageComputationUC2.calculateDailyEmployeeWage(0);
            }
            totalEmpWage += empWage;
            System.out.println("Employee Wage Daily: " + empWage);
        }
        System.out.println("Total Employee Wage: " + totalEmpWage);
    }
}
