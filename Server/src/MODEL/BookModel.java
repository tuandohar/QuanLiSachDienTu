/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author ANH TUAN
 */
public class BookModel {
    private String boolName;
    private String AuthorName;
    private int amount;
    private String type;
    private Date date;
    private DateFormat df;
    private double price;
    private int id;

    public BookModel(String boolName, String AuthorName, int amount, String type, Date date, DateFormat df, double price, int id) {
        this.boolName = boolName;
        this.AuthorName = AuthorName;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.df = df;
        this.price = price;
        this.id = id;
    }

    public BookModel() {
    }

    public String getBoolName() {
        return boolName;
    }

    public void setBoolName(String boolName) {
        this.boolName = boolName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String AuthorName) {
        this.AuthorName = AuthorName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateFormat getDf() {
        return df;
    }

    public void setDf(DateFormat df) {
        this.df = df;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
