package sp;

import MODEL.SanPhamMD;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sp extends javax.swing.JPanel implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean selected;
    private SanPhamMD sanPham;

    public Sp() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public SanPhamMD getSanPham() {
        return sanPham;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    public void setData(SanPhamMD sanpham) {
        this.sanPham = sanpham;
        TenSP.setText(sanpham.getItemName());
        thuongHieu.setText(sanpham.getBrandName());
        mota.setText(sanpham.getDescription());
        
        ImageIcon imageIcon = (ImageIcon) sanpham.getImageIcon();
        if (imageIcon != null) {
            pic.setImage(imageIcon);
        } else {
            // Handle case where the image is not available
            pic.setImage(new ImageIcon(getClass().getResource("/Anh/default.png"))); // Use a default image
        }
        
        
        Gia.setText(sanpham.getPrice()+"");
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        if (selected) {
            g2.setColor(new Color(94, 156, 255));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        }
        g2.dispose();
        super.paint(g);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        TenSP = new javax.swing.JLabel();
        thuongHieu = new javax.swing.JLabel();
        pic = new GiaoDienBoTro.KhungAnh();
        mota = new JLabel();
        Gia = new JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setOpaque(false);

        TenSP.setFont(new java.awt.Font("Segoe UI", 1, 18));
        TenSP.setForeground(new java.awt.Color(102, 102, 102));
        TenSP.setText("Conan");

        thuongHieu.setFont(new java.awt.Font("Segoe UI", 1, 14));
        thuongHieu.setForeground(new java.awt.Color(102, 102, 102));
        thuongHieu.setText("Hiro");

        pic.setImage(new javax.swing.ImageIcon(getClass().getResource("/Anh/img6.png"))); // Use a default image

        mota.setFont(new java.awt.Font("Segoe UI", 1, 14));
        mota.setForeground(new java.awt.Color(102, 102, 102));
        mota.setText("TrinhTham");

        Gia.setFont(new java.awt.Font("Segoe UI", 1, 14));
        Gia.setForeground(new java.awt.Color(102, 102, 102));
        Gia.setText("GiaBan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mota, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thuongHieu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mota, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel Gia;
    private javax.swing.JLabel TenSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mota;
    private GiaoDienBoTro.KhungAnh pic;
    private javax.swing.JLabel thuongHieu;
    // End of variables declaration                   
}
