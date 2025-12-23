package oopsandds.day11_12.pracitce;

import java.util.ArrayList;
import java.util.List;

public class StockPortfolio {
    List<Stock> stockList = new ArrayList<>();

    public void addStock(Stock stock) {
        stockList.add(stock);
    }

    public double calculateTotalValue() {
        double totalPortfolioValue = 0.0;

        for (Stock stock : stockList) {
            totalPortfolioValue += stock.calculateStockValue();
        }
        return totalPortfolioValue;
    }

    public void printStockReport() {
        System.out.println("----- Stock Report -----");
        System.out.println("Stock Name Shares Price Value");

        for (Stock stock : stockList) {
            System.out.println(
                    stock.getShareName() + " " +
                            stock.getNumberOfShare() + " " +
                            stock.getSharePrice() + " " +
                            stock.calculateStockValue()
            );
        }

        System.out.println("Total Portfolio Value: " + calculateTotalValue());
    }
}
