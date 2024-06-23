package Chay;

import DAO.ProductSummaryDAO;
import DAO.UploadBook;
import DAO.uploadUser;
import EventItem1.EvenItem1;
import EventItem1.EventMenuSelected;
import EventItem1.MousePressed;
import GiaoDienBoTro.KhungAnh;
import MODEL.ModelUser;
import MODEL.SanPhamMD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Nha.form1;
import Nha.form10;
import Nha.form2;
import Nha.form3;
import Nha.form4;
import Nha.form5;
import Nha.form6;
import Nha.form7;
import Nha.form8;
import Nha.form9;
import Servet.ServerSock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Chay extends javax.swing.JFrame implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double balance;
    private int numbers;
    private String clientID;
    private String clientText;

    private form1 form1;
    private form2 form2;
    private form3 form3;
    private form4 form4;
    private form5 form5;
    private form6 form6;
    private form7 form7;
    private form8 form8;
   private form9 form9;
    private form10 form10;

    public int x;
    public int y;

    public Chay() {
        initComponents();
        Thread serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                ServerSock serverSock = new ServerSock(Chay.this);
                serverSock.startServer();
            }
        });
        serverThread.start();
        setBackground(new Color(0, 0, 0, 0));
        menu2.initMoving(this);
        form1 = new form1();
        form2 = new form2();
        form3 = new form3();
        form4 = new form4();
        form5 = new form5(clientID, clientText);
        form6 = new form6();
        form7 = new form7();
        form8 = new form8();
        form9 = new form9();
        form10 = new form10();

        menu2.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                System.out.println(".selected()" + index);
                if (index == 0) {
                    uploadUser u = new uploadUser();
                    u.CheckU();
                    try {
                        u.worker.get();
                    } catch (InterruptedException | ExecutionException ex) {
                        Logger.getLogger(Chay.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    setForm(form2);
                    form2.infor(u.getUser());
                    form2.getUpDate().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ArrayList<ModelUser> model3 = new ArrayList<>();
                            form2.update(model3);
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                    });
                    Jheader.setText("Quản lí người dùng");
                } else if (index == 1) {
                    UploadBook uploadBook = new UploadBook();
                    uploadBook.CheckU();
                    try {
                        uploadBook.worker.get();
                    } catch (InterruptedException | ExecutionException ex) {
                        Logger.getLogger(Chay.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    setForm(form3);
                    form3.infor(uploadBook.getSp());
                    form3.getjButton1().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ArrayList<SanPhamMD> spmd3 = new ArrayList<>();
                            form3.update(spmd3);
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                    });
                    Jheader.setText("Quản lí sách");
                } else if (index == 2) {
                    Jheader.setText("Hỗ trợ");
                    setForm(form5);
                } else   if (index == 3) {
                    Jheader.setText("Thống kê");
                    updateForm4Table();
                }
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        init();
    }
    private void updateForm4Table() {
        ProductSummaryDAO productSummaryDAO = new ProductSummaryDAO();
        productSummaryDAO.fetchProductSummary();

        try {
            productSummaryDAO.worker.get(); // Wait for the worker to finish
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Chay.class.getName()).log(Level.SEVERE, null, ex);
        }

        form4.updateTable(productSummaryDAO.getProductSummaryList());
        setForm(form4);
    }

    public void setform1() {
        form1.check(getId(), getName(), getNumbers(), getBalance());
        setForm(form1);
    }

    private void setForm(JComponent com) {
        jPanel3.removeAll();
        jPanel3.add(com);
        jPanel3.repaint();
        jPanel3.revalidate();
    }

    private void init() {
        gopNutMAC1.initEvent(this, nen1);
        jPanel1.setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        nen1 = new TaoNen.Nen();
        jPanel1 = new javax.swing.JPanel();
        menu2 = new MenuSwing.Menu();
        jPanel2 = new javax.swing.JPanel();
        gopNutMAC1 = new NutNhanMAC.GopNutMAC();
        Jheader = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(104, 60));

        Jheader.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Jheader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Jheader.setText("Dash board");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(Jheader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gopNutMAC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(gopNutMAC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
            .addComponent(Jheader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout nen1Layout = new javax.swing.GroupLayout(nen1);
        nen1.setLayout(nen1Layout);
        nen1Layout.setHorizontalGroup(
            nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nen1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
                .addContainerGap())
        );
        nen1Layout.setVerticalGroup(
            nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nen1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nen1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(nen1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chay().setVisible(true);
            }
        });
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientText() {
        return clientText;
    }

    public void setClientText(String clientText) {
        this.clientText = clientText;
    }

    public void updateForm5() {
        form5.appendText(clientID, clientText);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel Jheader;
    private NutNhanMAC.GopNutMAC gopNutMAC1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private MenuSwing.Menu menu2;
    private TaoNen.Nen nen1;
    // End of variables declaration                   
}
