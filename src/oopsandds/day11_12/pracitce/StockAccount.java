package oopsandds.day11_12.pracitce;

import java.util.ArrayList;
import java.util.List;

public class StockAccount {
    List<CompanyShares> shares = new ArrayList<>();

    public void buy(int amount, String symbol) {
        for (CompanyShares shares1 : shares) {
            if (shares1.getSymbol().equals(symbol)) {
                shares1.addShares(amount);
                return;
            }
        }
        shares.add(new CompanyShares(symbol, amount));
    }

    public void printReport() {
        System.out.println("----- Stock Report -----");
        for (CompanyShares shares2 : shares) {
            System.out.println(
                    "Stock Symbol: " + shares2.getSymbol() +
                            ", Shares: " + shares2.getShares() +
                            ", Last Transaction: " + shares2.getTransactionTime()
            );
        }
        System.out.println("Total Account Value: " + valueOfShare());
    }

    public double valueOfShare() {
        double total = 0.0;
        for (CompanyShares shares3 : shares) {
            total += shares3.getShares() * 100;
        }
        return total;
    }

    public void sell(int amount, String symbol) {
        for (CompanyShares shares1 : shares) {
            if (shares1.getSymbol().equals(symbol)) {
                if (shares1.getShares() >= amount) {
                    shares1.removeShares(amount);
                } else {
                    System.out.println("Not enough shares to sell.");
                }
                return;
            }
        }
        System.out.println("Stock not found.");
    }
}
