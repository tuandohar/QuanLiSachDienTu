package DAO;

import DataBase.ConectDataBase;
import MODEL.ProductSummary;

import javax.swing.SwingWorker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductSummaryDAO {

    private ArrayList<ProductSummary> productSummaryList;
    public static SwingWorker<Void, Void> worker;

    public ProductSummaryDAO() {
        productSummaryList = new ArrayList<>();
    }

    public void fetchProductSummary() {
        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try (Connection connection = ConectDataBase.getConnection()) {
                    String query = "SELECT ProductID, BookName, BuyNumber, Price FROM product";
                    try (PreparedStatement statement = connection.prepareStatement(query);
                         ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            int productID = resultSet.getInt("ProductID");
                            String bookName = resultSet.getString("BookName");
                            int buyNumber = resultSet.getInt("BuyNumber");
                            double price = resultSet.getDouble("Price");

                            ProductSummary productSummary = new ProductSummary(productID, bookName, buyNumber, price);
                            productSummaryList.add(productSummary);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        worker.execute();
    }

    public ArrayList<ProductSummary> getProductSummaryList() {
        return productSummaryList;
    }
}
