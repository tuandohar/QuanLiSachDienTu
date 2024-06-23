package SwingLogin;

import Chay.Chay;

import EventItem1.MousePressed;
import TaoNen.LogInBackGround;
import TaoNen.Nen;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ANH TUAN
 */
public class LoginPanel extends javax.swing.JPanel {

    private Chay run;
    private LoginFrame1 k;
    private static int id;
    private static String name1;
    private static double balance;
    private static int numbers;

    public static int getNumbers() {
        return numbers;
    }

    public static void setNumbers(int numbers) {
        LoginPanel.numbers = numbers;
    }

    public static String getName1() {
        return name1;
    }

    public static void setName1(String name1) {
        LoginPanel.name1 = name1;
    }

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double balance) {
        LoginPanel.balance = balance;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        LoginPanel.id = id;
    }

    public static MyButton getLoginBtn() {
        return LoginBtn;
    }
    private MousePressed event;

    public MousePressed getEvent() {
        return event;
    }

    public void setEvent(MousePressed event) {
        this.event = event;
        repaint();
    }

    public static void setLoginBtn(MyButton LoginBtn) {
        LoginPanel.LoginBtn = LoginBtn;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public LogInBackGround getLogInBackGround1() {
        return logInBackGround1;
    }

    public void setLogInBackGround1(LogInBackGround logInBackGround1) {
        this.logInBackGround1 = logInBackGround1;
    }

    public Nen getNen1() {
        return nen1;
    }

    public void setNen1(Nen nen1) {
        this.nen1 = nen1;
    }

    public PassWordField getPassWordField1() {
        return passWordField1;
    }

    public void setPassWordField1(PassWordField passWordField1) {
        this.passWordField1 = passWordField1;
    }

    public JButton getRegisterBtn() {
        return registerBtn;
    }

    public void setRegisterBtn(JButton registerBtn) {
        this.registerBtn = registerBtn;
    }

    public TextField getTextUser() {
        return textUser;
    }

    public void setTextUser(TextField textUser) {
        this.textUser = textUser;
    }

    public LoginPanel() {
        initComponents();
        setBackground(new Color(255, 255, 255, 255));
        LoginBtn.setFont(new Font("Arial", Font.BOLD, 10));
        registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    public void LoginPanel() {
        textUser.grabFocus();
    }

    public void addAction(JPanel j, JPanel k) {
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.removeAll();
                j.add(k);
                j.revalidate();
                j.repaint();
                
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        logInBackGround1 = new TaoNen.LogInBackGround();
        nen1 = new TaoNen.Nen();
        textUser = new TextField();
        jLabel1 = new javax.swing.JLabel();
        passWordField1 = new PassWordField();
        LoginBtn = new MyButton();
        registerBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        textUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 110, 226));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng nhập");

        passWordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passWordField1ActionPerformed(evt);
            }
        });

        LoginBtn.setForeground(new java.awt.Color(125, 94, 142));
        LoginBtn.setText("Đăng nhập");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        registerBtn.setBackground(new java.awt.Color(255, 255, 255));
        registerBtn.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(124, 94, 142));
        registerBtn.setText("Đăng ký");
        registerBtn.setAutoscrolls(true);
        registerBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        registerBtn.setContentAreaFilled(false);
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Mật khẩu");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Tên đăng nhập");

        javax.swing.GroupLayout nen1Layout = new javax.swing.GroupLayout(nen1);
        nen1.setLayout(nen1Layout);
        nen1Layout.setHorizontalGroup(
            nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nen1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nen1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nen1Layout.createSequentialGroup()
                        .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nen1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nen1Layout.createSequentialGroup()
                        .addGroup(nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passWordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textUser, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))
                    .addGroup(nen1Layout.createSequentialGroup()
                        .addGroup(nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        nen1Layout.setVerticalGroup(
            nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nen1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passWordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout logInBackGround1Layout = new javax.swing.GroupLayout(logInBackGround1);
        logInBackGround1.setLayout(logInBackGround1Layout);
        logInBackGround1Layout.setHorizontalGroup(
            logInBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logInBackGround1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(nen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        logInBackGround1Layout.setVerticalGroup(
            logInBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logInBackGround1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(nen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        add(logInBackGround1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>                        

    private void textUserActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void passWordField1ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           


    // Variables declaration - do not modify                     
    public static MyButton LoginBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private TaoNen.LogInBackGround logInBackGround1;
    private TaoNen.Nen nen1;
    private PassWordField passWordField1;
    private javax.swing.JButton registerBtn;
    private TextField textUser;
    // End of variables declaration                   
}
