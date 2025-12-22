package constructor.day4.practice;

public class EmployeeWageComputationUC6 {
    public static void main(String[] args) {
        int empHrs = 0;
        int totalWorkingHours = 0;
        int toalWorkingDays = 0;

        while (totalWorkingHours < EmployeeConstant.TOTAL_WORKING_HOURS && toalWorkingDays < EmployeeConstant.TOTAL_WORKING_DAYS) {
            toalWorkingDays++;

            int isEmployeePresent = EmployeeWageComputationUC3.getEmployeePresence();
            switch (isEmployeePresent) {
                case EmployeeConstant.IS_FULL_TIME:
                    empHrs = EmployeeConstant.FULL_DAY_HOUR;
                    break;
                case EmployeeConstant.IS_PART_TIME:
                    empHrs = EmployeeConstant.PART_TIME_HOUR;
                    break;
                default:
                    empHrs = 0;
            }
            totalWorkingHours += empHrs;
            System.out.println("Day: " + toalWorkingDays + " Employee working hours: " + empHrs);
        }

        int totalEmpWage = EmployeeWageComputationUC2.calculateDailyEmployeeWage(totalWorkingHours);
        System.out.println("Total Employee Wage: " + totalEmpWage);
    }
}
