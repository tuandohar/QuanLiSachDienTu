package MODEL;

import java.io.Serializable;

public class ProductSummary implements Serializable {
    private static final long serialVersionUID = 1L;

    private int productID;
    private String bookName;
    private int buyNumber;
    private double price;

    public ProductSummary(int productID, String bookName, int buyNumber, double price) {
        this.productID = productID;
        this.bookName = bookName;
        this.buyNumber = buyNumber;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
