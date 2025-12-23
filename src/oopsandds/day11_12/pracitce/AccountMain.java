package oopsandds.day11_12.pracitce;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account("Axis Bank", 5000);
        double checkBalance = account.getBalance();
        System.out.println("Your balance is: " + checkBalance);
        account.withdraw(600);
    }
}
