/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Nha;

import GiaoDienBoTro.AddLine;

/**
 *
 * @author ANH TUAN
 */
public class form6 extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public form6() {
        initComponents();
        AddLine al = new AddLine();
        
        lll.setText("1. Bạn nhấp chuột vào ô sản phầm để xem chi tiết những thứ đã mua"
                
                + "<br/>"
                + "2. Khi mua xong bạn có thể vào mục <i>Sách đã mua để có thể đọc</i>"
                + "<br/>"
                + "3. Khi bạn muốn nap tiền hãy chuyển khoản đến số tài khoản <i>123456789</i> ngân hàng Techcombank với nội dung là <i>số id của bạn</i> khoảng cách <i>Số tiền</i> khoảng cách và ngày tháng năm chuyển tiền"
                + "<br/>"
                + "4. Sau khi chuyển tiền xong bạn nhẫn vào mục Nạp tiền và ghi thông tin cần thiết rồi nhấn đã nạp, chúng tôi sẽ xử lí yêu cầu của quý khách trong vài phút! "
                + "<br/>"
                + "5.Nếu cần hỗ trợ hãy vào mục hỗ trợ để gửi vấn đề cho chúng tôi, chúng tôi sẽ trả lời trong vài phút, xin cảm ơn"
                + "<br/>"
                + "6. Hỗ Trợ và Hoàn Tiền: Chính sách có thể bao gồm các hướng dẫn về việc yêu cầu hỗ trợ kỹ thuật hoặc hoàn tiền nếu có vấn đề với việc tải xuống hoặc đọc sách điện tử. "
                + "<br/>"
        );
        al.addMultilineLabel(jPanel1, lll);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lll = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quy tắc");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        lll.setBackground(new java.awt.Color(102, 255, 255));
        lll.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        lll.setForeground(new java.awt.Color(0, 102, 102));
        lll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lll.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lll.setAlignmentY(1.0F);
        jPanel2.add(lll, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lll;
    // End of variables declaration                   
}
