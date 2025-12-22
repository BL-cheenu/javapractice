package oopsandds.day10.practice;


public class EmployeeWageComputationUC6 {
    public static final int FULL_TIME_EMPLOYEE = 1;
    public static final int PART_TIME_EMPLOYEE = 2;

    int wagePerHour;
    int fullDayHour;
    int partTimeHour;
    int workingDayPerMonth;

    public EmployeeWageComputationUC6(int wagePerHour, int fullDayHour, int partTimeHour, int workingPerMonth) {
        this.wagePerHour = wagePerHour;
        this.fullDayHour = fullDayHour;
        this.partTimeHour = partTimeHour;
        this.workingDayPerMonth = workingDayPerMonth;
    }

    // UC1
    public int isEmployeePresent() {
        return (int) (Math.random() * 3);
    }

    // UC2
    public double calculateWage(int workingHours) {
        return workingHours * wagePerHour;
    }

    // UC3 && UC4
    public double calculateDailyEmployeeWage(int isEmployeePresent) {
        switch (isEmployeePresent) {
            case FULL_TIME_EMPLOYEE:
                return fullDayHour;
            case PART_TIME_EMPLOYEE:
                return partTimeHour;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");
        double totalMonthlyWage = 0.0;

        int totalWorkingHours = 0;
        int totalWorkingDays = 0;

        // UC6 && UC7
        EmployeeWageComputationUC6 employeeWage = new EmployeeWageComputationUC6(20, 8, 4, 20);
        while (totalWorkingDays < 20 && totalWorkingHours < 100) {
            totalWorkingDays++;
            int employeePresentCheck = employeeWage.isEmployeePresent();
            double dailyWage = employeeWage.calculateDailyEmployeeWage(employeePresentCheck);
            totalWorkingHours += dailyWage;
        }
        totalMonthlyWage = employeeWage.calculateWage(totalWorkingHours);
        System.out.println("Monthly wage of is: " + totalMonthlyWage);
    }
}
