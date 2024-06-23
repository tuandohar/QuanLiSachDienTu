/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.awt.print.Book;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ANH TUAN
 */
public class ModelUser implements Serializable{

    @Override
	public String toString() {
		return "ModelUser [id=" + id + ", name=" + name + ", NumbersOfBook=" + NumbersOfBook + ", balance=" + balance
				+ "]";
	}

	private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int NumbersOfBook;
    private double balance;

    public ModelUser() {
    }

    public ModelUser(int id, String name, int NumbersOfBook, double balance) {
        this.id = id;
        this.name = name;
        this.NumbersOfBook = NumbersOfBook;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumbersOfBook() {
        return NumbersOfBook;
    }

    public void setNumbersOfBook(int NumbersOfBook) {
        this.NumbersOfBook = NumbersOfBook;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + this.NumbersOfBook;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.balance) ^ (Double.doubleToLongBits(this.balance) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModelUser other = (ModelUser) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.NumbersOfBook != other.NumbersOfBook) {
            return false;
        }
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    
    
}
