/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataBase.ConectDataBase;
import MODEL.SanPhamMD;
import com.mysql.cj.protocol.Resultset;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.SwingWorker;

/**
 *
 * @author ANH TUAN
 */
public class CheckAddItem {

    private boolean check;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    private int idItem;
    private String itemName;
    private float price;
    private Icon itemImage;
    private ArrayList<SanPhamMD> item;
    public static SwingWorker<Void, Void> worker;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Icon getItemImage() {
        return itemImage;
    }

    public void setItemImage(Icon itemImage) {
        this.itemImage = itemImage;
    }

    public ArrayList<SanPhamMD> getItem() {
        return item;
    }

    public void setItem(ArrayList<SanPhamMD> item) {
        this.item = item;
    }

    public static SwingWorker<Void, Void> getWorker() {
        return worker;
    }

    public static void setWorker(SwingWorker<Void, Void> worker) {
        CheckAddItem.worker = worker;
    }

    public CheckAddItem() {

    }

    public void checkAdmin(String username, String pass) {
        item = new ArrayList<>();
        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try (java.sql.Connection com = ConectDataBase.getConnection()) {
                    String sql = "SELECT * FROM admin WHERE taikhoan=? and matkhau=?";
                    try (PreparedStatement ps = com.prepareStatement(sql)) {
                        ps.setString(1, username);
                        ps.setString(2, pass);
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                check = true;
                            } else {
                                check = false;
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                }
            }
        };

    }
}
