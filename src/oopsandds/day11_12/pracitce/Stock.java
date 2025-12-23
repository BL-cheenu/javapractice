package oopsandds.day11_12.pracitce;

public class Stock {

    private String shareName;
    private int numberOfShare;
    private double sharePrice;

    public Stock(String shareName, int numberOfShare, double sharePrice) {
        this.shareName = shareName;
        this.numberOfShare = numberOfShare;
        this.sharePrice = sharePrice;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public int getNumberOfShare() {
        return numberOfShare;
    }

    public void setNumberOfShare(int numberOfShare) {
        this.numberOfShare = numberOfShare;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(double sharePrice) {
        this.sharePrice = sharePrice;
    }

    public double calculateStockValue() {
        return numberOfShare * sharePrice;
    }

}
