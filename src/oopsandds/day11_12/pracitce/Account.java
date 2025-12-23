package oopsandds.day11_12.pracitce;

public class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double debitAmount) {
        if (debitAmount <= balance) {
            balance -= debitAmount;
            System.out.println("Withdraw amount is: " + debitAmount);
            System.out.println("Your balance is: " + balance);
        } else {
            System.out.println("Debit amount exceeded account balance.");
        }
    }
}
