package Nha;

import DAO.UpdateBook;
import GiaoDienBoTro.ThanhCuon;
import MODEL.SanPhamMD;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
public class form3 extends javax.swing.JPanel {

    public form3() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ThanhCuon());
        jTable1.setCellSelectionEnabled(false);
        jTable1.setRowSelectionAllowed(true);

        // Add ActionListener for Delete button
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
    }

    // Method to populate table with data
    public void infor(ArrayList<SanPhamMD> model) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        for (SanPhamMD book : model) {
            Object[] rowData = {
                book.getItemID(), book.getItemName(), book.getDescription(), book.getBrandName(), book.getPrice(), book.getImage(), book.getAuthor()
            };
            tableModel.addRow(rowData);
        }
    }
    
    public javax.swing.JButton getjButton1() {
		return jButton1;
	}

	public void setjButton1(javax.swing.JButton jButton1) {
		this.jButton1 = jButton1;
	}

	public javax.swing.JButton getjButton2() {
		return jButton2;
	}

	public void setjButton2(javax.swing.JButton jButton2) {
		this.jButton2 = jButton2;
	}

	public javax.swing.JButton getjButton3() {
		return jButton3;
	}

	public void setjButton3(javax.swing.JButton jButton3) {
		this.jButton3 = jButton3;
	}

	public javax.swing.JLabel getjLabel1() {
		return jLabel1;
	}

	public void setjLabel1(javax.swing.JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	public javax.swing.JPanel getjPanel1() {
		return jPanel1;
	}

	public void setjPanel1(javax.swing.JPanel jPanel1) {
		this.jPanel1 = jPanel1;
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public javax.swing.JTable getjTable1() {
		return jTable1;
	}

	public void setjTable1(javax.swing.JTable jTable1) {
		this.jTable1 = jTable1;
	}

	// Method to update database with table data
    public void update(ArrayList<SanPhamMD> modelsp) {
        int rowCount = jTable1.getRowCount();
        modelsp = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            int id = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
            String name = (String) jTable1.getValueAt(i, 1);
            String description = (String) jTable1.getValueAt(i, 2);
            String brandName = (String) jTable1.getValueAt(i, 3);
            double price = Double.parseDouble(jTable1.getValueAt(i, 4).toString());
            String image = (String) jTable1.getValueAt(i, 5);
            String author = (String) jTable1.getValueAt(i, 6);
            String content = (String) jTable1.getValueAt(i, 7);
            SanPhamMD spp = new SanPhamMD(id, name, description, price, brandName, image, author,content);
            modelsp.add(spp);
        }
        UpdateBook udBook = new UpdateBook();
        try {
            udBook.updateDatabase(modelsp);
        } catch (SQLException ex) {
            Logger.getLogger(form3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void insertActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"", "", "", "", 0.0, "", ""}); // Add empty row
    }

    // Method to handle delete action
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int[] rows = jTable1.getSelectedRows();

        if (rows.length == 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        for (int i = rows.length - 1; i >= 0; i--) {
            model.removeRow(rows[i]);
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gr = new GradientPaint(0, 0, Color.decode("#65C9F6"), 0, getHeight(), Color.decode("#295C57"));
        g2.setPaint(gr);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        g2.dispose();

        super.paint(grphcs);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1; // Update button
    private javax.swing.JButton jButton2; // Insert button
    private javax.swing.JButton jButton3; // Delete button
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insertActionPerformed(e);
				
			}
		});
        jButton3 = new javax.swing.JButton(); // Add jButton3 for Delete

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description", "Brand", "Price", "Image", "Author"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(0, 255, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Update");

        jButton2.setText("Insert");

        jButton3.setText("Delete"); // Delete button text

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)) // Delete button
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
}
