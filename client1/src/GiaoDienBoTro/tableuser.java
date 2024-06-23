/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiaoDienBoTro;


import MODEL.ModelUser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANH TUAN
 */
public class tableuser extends JPanel implements Serializable{

    private static final long serialVersionUID = 1L;

    private JTable table;
    private JScrollPane scrollPane;

    public tableuser() {
        setLayout(new BorderLayout()); // Đảm bảo layout của JPanel là BorderLayout
        table = new JTable();
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Arial", Font.BOLD, 10));
        table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "User ID ", "UserName", "Numbers of book", "Balance"
                }
        ));
        // Tạo JScrollPane cho JTable
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER); // Thêm JScrollPane vào JPanel
       // setTable();
    }

    /*public void setTable() {
        CheckU check = new CheckU();
        try {
            check.worker.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.setRowCount(0);
        check.CheckU(this, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY);
        for (int i = 0; i < check.getUser().size(); i++) {
            ModelUser data = check.getUser().get(i);
            model_table.addRow(new Object[]{
                data.getId(), data.getName(), data.getNumbersOfBook(), data.getBalance()
            });
        }
    }*/
}
