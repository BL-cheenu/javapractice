package oopsandds.day11_12.pracitce;

import java.util.Scanner;

public class StockMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter a stock: ");
        int stock = scanner.nextInt();

        for (int i = 1; i <= stock; i++) {
            System.out.println("Enter details for Stock " + i + ":");

            System.out.print("Stock Name: ");
            String name = scanner.next();

            System.out.print("Number of Shares: ");
            int shares = scanner.nextInt();

            System.out.print("Share Price: ");
            double price = scanner.nextDouble();
            Stock stock1 = new Stock(name, shares, price);
            portfolio.addStock(stock1);
        }
        portfolio.printStockReport();
    }
}
