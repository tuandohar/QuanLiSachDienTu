package Nha;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.text.DecimalFormat;
import java.util.List;
import MODEL.ProductSummary; // Assuming you have this model

public class form4 extends javax.swing.JPanel {
    private final static String tieuDe1 = "form4";

    public static String getTieuDe1() {
        return tieuDe1;
    }

    public form4() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID sách", "Tên sách", "Số lượng mua", "Giá", "Tổng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);

        // Set custom renderer for columns displaying Double values
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new DoubleRenderer());
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new DoubleRenderer());

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>

    public void updateTable(List<ProductSummary> productList) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        double total = 0;

        for (ProductSummary product : productList) {
            Object[] row = new Object[5];
            row[0] = product.getProductID();
            row[1] = product.getBookName();
            row[2] = product.getBuyNumber();
            row[3] = product.getPrice();
            double subtotal = product.getPrice() * product.getBuyNumber();
            row[4] = subtotal; // Total

            model.addRow(row);

            total += subtotal;
        }

        // Add total row
        Object[] totalRow = {"", "", "", "Tổng cộng:", total};
        model.addRow(totalRow);
    }

    // Custom Renderer for displaying Double values with decimal format
    private class DoubleRenderer extends javax.swing.table.DefaultTableCellRenderer {
        private DecimalFormat formatter;

        public DoubleRenderer() {
            super();
            formatter = new DecimalFormat("#,###.00"); // Format to two decimal places
        }

        @Override
        public void setValue(Object value) {
            if (value instanceof Double) {
                setText(formatter.format(value));
            } else {
                super.setValue(value);
            }
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
