package oopsandds.day11_12.pracitce;

import java.util.Scanner;

public class StockAccountMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockAccount account = new StockAccount();

        System.out.print("Enter number of stock: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter operation (buy/sell): ");
            String operation = sc.next();

            System.out.print("Enter stock symbol: ");
            String symbol = sc.next();

            System.out.print("Enter number of shares: ");
            int amount = sc.nextInt();

            if (operation.equalsIgnoreCase("buy")) {
                account.buy(amount, symbol);
            } else if (operation.equalsIgnoreCase("sell")) {
                account.sell(amount, symbol);
            }
        }
        account.printReport();
    }
}
