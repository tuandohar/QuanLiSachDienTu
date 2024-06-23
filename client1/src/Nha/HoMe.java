/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Nha;

import EventItem1.EvenItem1;
import EventItem1.MousePressed;
import GiaoDienBoTro.KhungAnh;
import GiaoDienBoTro.ThanhCuon;
import MODEL.SanPhamMD;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.SwingUtilities;
import sp.Sp;

/**
 * Class representing the home panel where products are displayed.
 * @author ANH TUAN
 */
public class HoMe extends javax.swing.JPanel implements Serializable {

    private static final long serialVersionUID = 1L;
    private EvenItem1 event;
    private MousePressed event2;

    public HoMe() {
        initComponents();
        // Initialize the custom scroll bar
        jScrollPane1.setVerticalScrollBar(new ThanhCuon());
    }

    public MousePressed getEvent2() {
        return event2;
    }

    public void setEvent2(MousePressed event2) {
        this.event2 = event2;
    }

    public EvenItem1 getEvent() {
        return event;
    }

    public void setEvent(EvenItem1 event) {
        this.event = event;
    }

    /**
     * Adds a product item to the panel.
     * @param data The product data to be added.
     */
    public void addItem(SanPhamMD data) {
        Sp item = new Sp();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    if (event != null) {
                        event.itemClick(item, data);
                    }
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (event2 != null) {
                        event2.itemClick(item, data);
                    }
                }
                super.mouseClicked(e);
            }
        });
        
        khungSanPham1.add(item);
        khungSanPham1.repaint();
        khungSanPham1.revalidate();
    }

    /**
     * Clears all items from the panel.
     */
    public void clearItems() {
        khungSanPham1.removeAll();
        khungSanPham1.repaint();
        khungSanPham1.revalidate();
    }

    /**
     * Sets the selected item in the panel.
     * @param item The component to be marked as selected.
     */
    public void setSelected(Component item) {
        for (Component com : khungSanPham1.getComponents()) {
            Sp i = (Sp) com;
            if (i.isSelected()) {
                i.setSelected(false);
            }
        }
        ((Sp) item).setSelected(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        khungSanPham1 = new GiaoDienBoTro.KhungSanPham();

        setOpaque(false);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportView(khungSanPham1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );
    }

    // Variables declaration
    private javax.swing.JScrollPane jScrollPane1;
    private GiaoDienBoTro.KhungSanPham khungSanPham1;
    // End of variables declaration
}
