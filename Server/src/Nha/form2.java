package Nha;

import DAO.UpdateUser;
import DAO.delete;
import GiaoDienBoTro.ThanhCuon;
import MODEL.ModelUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANH TUAN
 */
public class form2 extends javax.swing.JPanel {

    private ArrayList<ModelUser> user;
    private ArrayList<ModelUser> model2;

    public ArrayList<ModelUser> getModel2() {
        return model2;
    }

    public void setModel2(ArrayList<ModelUser> model2) {
        this.model2 = model2;
    }

    public JButton getUpDate() {
        return UpDate;
    }

    public void setUpDate(JButton UpDate) {
        this.UpDate = UpDate;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public form2() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ThanhCuon());
        jTable1.setCellSelectionEnabled(false);
        jTable1.setRowSelectionAllowed(true);
        insertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insertActionPerformed(e);
				
			}
		});
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(form2.this, "Please select a row to delete.");
                    return;
                }

                String idStr = jTable1.getValueAt(selectedRow, 0).toString();
                int id = Integer.parseInt(idStr);

                if (id != 0) {
                    System.out.println(id);
                    delete de = new delete();
                    try {
                        de.deleteFromTaikhoan(id);

                    } catch (SQLException ex) {
                        Logger.getLogger(form2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("không có dữ liệu để xóa");
                }
            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(new Object[]{"", "", "", ""});
            }
        });
    }
    private void insertActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"", "", "", "", 0.0, "", ""}); // Add empty row
    }
    public void infor(ArrayList<ModelUser> model) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        for (ModelUser users : model) {
            Object[] rowData = {
                users.getId(), users.getName(), users.getBalance(), users.getNumbersOfBook(), users.getPass()
            };
            tableModel.addRow(rowData);
        }
    }

    public void update(ArrayList<ModelUser> model2) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        int rowCount = tableModel.getRowCount();

        model2 = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            int id;
            if (tableModel.getValueAt(i, 0) == null || tableModel.getValueAt(i, 0).toString().isEmpty()) {
                id = 0; // New row
            } else {
                id = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
            }

            String name = (String) tableModel.getValueAt(i, 1);
            double balance = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
            int number = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
            String passs = (String) tableModel.getValueAt(i, 4);
            ModelUser m = new ModelUser(id, name, number, balance,passs);
            model2.add(m);
        }

        UpdateUser uduser = new UpdateUser();
        try {
            uduser.updateDatabase(model2);
        } catch (SQLException ex) {
            Logger.getLogger(form2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        UpDate = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Balance", "Book Numbers", "Pass"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRequestFocusEnabled(false);
        jTable1.setSelectionBackground(new java.awt.Color(0, 255, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        UpDate.setText("Update");
        UpDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpDateActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");

        insertButton.setText("Insert");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(UpDate)
                .addComponent(jButton2)
                .addComponent(insertButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }
    private void UpDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpDateActionPerformed

    }//GEN-LAST:event_UpDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UpDate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton insertButton; // Add this line
    // End of variables declaration//GEN-END:variables
}
