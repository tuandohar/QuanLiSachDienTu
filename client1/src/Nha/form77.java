/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Nha;

import java.awt.Color;

import GiaoDienBoTro.ThanhCuon;
import MODEL.SanPhamMD;

/**
 *
 * @author ANH TUAN
 */
public class form77 extends javax.swing.JPanel {
 
    public form77() {
        initComponents();
        
    }
    public void setData(SanPhamMD sp) {
		titleTx.setText(sp.getItemName());
		type.setText(sp.getBrandName());
		author.setText(sp.getAuthor());
		price.setText(sp.getPrice() + "");
		date.setText("Unknow");
		amount.setText("Unknow");
		seens.setText("10");
		jTextArea1.setLineWrap(true);
		jTextArea1.setWrapStyleWord(true);
		jTextArea1.setText(sp.getDescription());
		khungAnh1.setImage(sp.getImageIcon());
		jTextArea1.setEnabled(false);
		jTextArea1.setInputVerifier(getInputVerifier());

		// addLine2 al= new addLine2();
		// addLine2.setTextAndWrap(sp.getDescription(), jTextArea1);

		jScrollPane1.setVerticalScrollBar(new ThanhCuon());

	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        khungAnh1 = new GiaoDienBoTro.KhungAnh();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        InformationLb = new javax.swing.JLabel();
        titleTx = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        author = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        seens = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        Buy = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(khungAnh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(khungAnh1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        InformationLb.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        InformationLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InformationLb.setText("Thông tin sách");

        titleTx.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        titleTx.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTx.setText("Title");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tên");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thể loại");

        type.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        type.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type.setText("Title");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tác giả");

        author.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        author.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        author.setText("Title");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ngày");

        date.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setText("Title");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Lượt mua");

        seens.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        seens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seens.setText("Title");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Giá sách");

        price.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price.setText("Title");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Số lượng");

        amount.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        amount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amount.setText("Title");

        Buy.setBackground(new java.awt.Color(255, 255, 255));
        Buy.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Buy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Buy.setText("Đọc");
        Buy.setOpaque(true);
        Buy.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BuyMouseMoved(evt);
            }
        });
        Buy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuyMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InformationLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleTx, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(author, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Buy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(InformationLb, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleTx, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seens, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buy, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel4);
    }// </editor-fold>                        

    private void BuyMouseMoved(java.awt.event.MouseEvent evt) {                               
        // TODO add your handling code here:
        Buy.setBackground(Color.red);
    }                              

    private void BuyMouseEntered(java.awt.event.MouseEvent evt) {                                 
        // TODO add your handling code here:

    }                                

    private void BuyMouseExited(java.awt.event.MouseEvent evt) {                                
        // TODO add your handling code here:
        Buy.setBackground(Color.white);
    }                               


    public javax.swing.JLabel getBuy() {
		return Buy;
	}

	public void setBuy(javax.swing.JLabel buy) {
		Buy = buy;
	}

	public javax.swing.JLabel getInformationLb() {
		return InformationLb;
	}

	public void setInformationLb(javax.swing.JLabel informationLb) {
		InformationLb = informationLb;
	}

	public javax.swing.JLabel getAmount() {
		return amount;
	}

	public void setAmount(javax.swing.JLabel amount) {
		this.amount = amount;
	}

	public javax.swing.JLabel getAuthor() {
		return author;
	}

	public void setAuthor(javax.swing.JLabel author) {
		this.author = author;
	}

	public javax.swing.JLabel getDate() {
		return date;
	}

	public void setDate(javax.swing.JLabel date) {
		this.date = date;
	}

	public javax.swing.JLabel getjLabel11() {
		return jLabel11;
	}

	public void setjLabel11(javax.swing.JLabel jLabel11) {
		this.jLabel11 = jLabel11;
	}

	public javax.swing.JLabel getjLabel13() {
		return jLabel13;
	}

	public void setjLabel13(javax.swing.JLabel jLabel13) {
		this.jLabel13 = jLabel13;
	}

	public javax.swing.JLabel getjLabel2() {
		return jLabel2;
	}

	public void setjLabel2(javax.swing.JLabel jLabel2) {
		this.jLabel2 = jLabel2;
	}

	public javax.swing.JLabel getjLabel3() {
		return jLabel3;
	}

	public void setjLabel3(javax.swing.JLabel jLabel3) {
		this.jLabel3 = jLabel3;
	}

	public javax.swing.JLabel getjLabel5() {
		return jLabel5;
	}

	public void setjLabel5(javax.swing.JLabel jLabel5) {
		this.jLabel5 = jLabel5;
	}

	public javax.swing.JLabel getjLabel7() {
		return jLabel7;
	}

	public void setjLabel7(javax.swing.JLabel jLabel7) {
		this.jLabel7 = jLabel7;
	}

	public javax.swing.JLabel getjLabel9() {
		return jLabel9;
	}

	public void setjLabel9(javax.swing.JLabel jLabel9) {
		this.jLabel9 = jLabel9;
	}

	public javax.swing.JPanel getjPanel3() {
		return jPanel3;
	}

	public void setjPanel3(javax.swing.JPanel jPanel3) {
		this.jPanel3 = jPanel3;
	}

	public javax.swing.JPanel getjPanel4() {
		return jPanel4;
	}

	public void setjPanel4(javax.swing.JPanel jPanel4) {
		this.jPanel4 = jPanel4;
	}

	public javax.swing.JPanel getjPanel5() {
		return jPanel5;
	}

	public void setjPanel5(javax.swing.JPanel jPanel5) {
		this.jPanel5 = jPanel5;
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public javax.swing.JTextArea getjTextArea1() {
		return jTextArea1;
	}

	public void setjTextArea1(javax.swing.JTextArea jTextArea1) {
		this.jTextArea1 = jTextArea1;
	}

	public GiaoDienBoTro.KhungAnh getKhungAnh1() {
		return khungAnh1;
	}

	public void setKhungAnh1(GiaoDienBoTro.KhungAnh khungAnh1) {
		this.khungAnh1 = khungAnh1;
	}

	public javax.swing.JLabel getPrice() {
		return price;
	}

	public void setPrice(javax.swing.JLabel price) {
		this.price = price;
	}

	public javax.swing.JLabel getSeens() {
		return seens;
	}

	public void setSeens(javax.swing.JLabel seens) {
		this.seens = seens;
	}

	public javax.swing.JLabel getTitleTx() {
		return titleTx;
	}

	public void setTitleTx(javax.swing.JLabel titleTx) {
		this.titleTx = titleTx;
	}

	public javax.swing.JLabel getType() {
		return type;
	}

	public void setType(javax.swing.JLabel type) {
		this.type = type;
	}


	// Variables declaration - do not modify                     
    private javax.swing.JLabel Buy;
    private javax.swing.JLabel InformationLb;
    private javax.swing.JLabel amount;
    private javax.swing.JLabel author;
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private GiaoDienBoTro.KhungAnh khungAnh1;
    private javax.swing.JLabel price;
    private javax.swing.JLabel seens;
    private javax.swing.JLabel titleTx;
    private javax.swing.JLabel type;
    // End of variables declaration                   
}
