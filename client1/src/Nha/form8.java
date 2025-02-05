/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Nha;

import GiaoDienBoTro.ThanhCuon;
import GiaoDienBoTro.WrapLayout;
import java.awt.Label;
import javax.swing.JLabel;
import GiaoDienBoTro.AddLine;

/**
 *
 * @author ANH TUAN
 */
public class form8 extends javax.swing.JPanel {
     private final static String tieuDe1="fom1";
     public static String getTieuDe1() {
        return tieuDe1;
    }
    /**
     * Creates new form form7
     */
    public form8() {
        initComponents();
        AddLine al = new AddLine();
        
        lll.setText("1. Quyền Sở Hữu và Bản Quyền: Chính sách thường xác định rõ quyền sở hữu và bản quyền của sách điện tử, bao gồm quyền của tác giả và nhà xuất bản. Nó cũng có thể chỉ ra rằng việc sao chép, phân phối hoặc sử dụng sách điện tử mà không có sự cho phép của chủ sở hữu bản quyền là vi phạm pháp "
                + "luật "
                + "<br/>"
                + "2. Giá và Thanh Toán: Chính sách thường mô tả giá của sách điện tử và các phương thức thanh toán có sẵn cho người tiêu dùng. Nó cũng có thể đề cập đến các chính sách giảm giá, mã giảm giá và ưu đãi đặc biệt. "
                + "<br/>"
                + "3. Quyền Sử Dụng và Giới Hạn: Chính sách thường miêu tả quyền của người dùng khi mua sách điện tử, bao gồm quyền đọc, sao chép và in. Nó cũng có thể xác định các giới hạn hoặc hạn chế đối với việc sử dụng sách điện tử, chẳng hạn như không được sao chép nhiều bản cho mục đích thương mại hoặc không được phép phân phối cho người khác. "
                + "<br/>"
                + "4. Định Dạng và Công Nghệ: Chính sách có thể đề cập đến các định dạng sách điện tử được hỗ trợ và yêu cầu công nghệ cần thiết để đọc sách điện tử, chẳng hạn như phần mềm đọc e-book hoặc các thiết bị đọc e-book như Kindle hoặc Nook. "
                + "<br/>"
                + "5. Bảo Mật và Quyền Riêng Tư: Chính sách thường cung cấp thông tin về cách sách điện tử và thông tin cá nhân của người dùng được bảo vệ và được sử dụng, bao gồm cả chính sách về cookie và quyền riêng tư trực tuyến. "
                + "<br/>"
                + "6. Hỗ Trợ và Hoàn Tiền: Chính sách có thể bao gồm các hướng dẫn về việc yêu cầu hỗ trợ kỹ thuật hoặc hoàn tiền nếu có vấn đề với việc tải xuống hoặc đọc sách điện tử. "
                + "<br/>"
                + "7. Thay Đổi và Cập Nhật: Chính sách thường mô tả các điều khoản liên quan đến việc thay đổi hoặc cập nhật chính sách, bao gồm cách thông báo cho người dùng về các thay đổi này. ");
        al.addMultilineLabel(jPanel1, lll);
       
       
    }
    public void add(){
        
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

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chính sách");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
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
