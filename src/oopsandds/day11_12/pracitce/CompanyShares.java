package oopsandds.day11_12.pracitce;

import java.time.LocalDateTime;

public class CompanyShares {
    private String symbol;
    private int shares;
    private LocalDateTime transactionTime;

    public CompanyShares(String symbol, int shares) {
        this.symbol = symbol;
        this.shares = shares;
        this.transactionTime = LocalDateTime.now();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime localDateTime) {
        this.transactionTime = localDateTime;
    }

    public void addShares(int amount) {
        shares += amount;
        transactionTime = LocalDateTime.now();
    }

    public void removeShares(int amount) {
        shares -= amount;
        transactionTime = LocalDateTime.now();
    }
}
