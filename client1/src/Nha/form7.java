package Nha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import SwingLogin.LoginFrame1;
public class form7 extends javax.swing.JPanel {
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SwingLogin.MyButton getSent() {
        return sent;
    }

    public void setSent(SwingLogin.MyButton sent) {
        this.sent = sent;
    }

    public javax.swing.JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(javax.swing.JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public form7() {
        initComponents();
        sent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> performAction("help")).start();
            }
        });
    }

    private void performAction(String action) {
        String userName = String.valueOf(id);
        String pass = jTextArea1.getText();

        if (!userName.isEmpty() && !pass.isEmpty()) {
            try (Socket socket = new Socket("localhost", 9999)) {
                out = new ObjectOutputStream(socket.getOutputStream());
                in = new ObjectInputStream(socket.getInputStream());
                String ll = null;
                out.writeObject(action);
                out.writeObject(userName);
                out.writeObject(pass);
                out.writeObject(ll);
                JOptionPane.showMessageDialog(form7.this, "Đã gửi thành công!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(form7.this, "Please fill in user name and password");
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        nen1 = new TaoNen.Nen();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        sent = new SwingLogin.MyButton();

        nen1.setLayout(new java.awt.GridBagLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        nen1.add(jScrollPane1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        sent.setText("Gửi");
        sent.setPreferredSize(new java.awt.Dimension(734, 40));
        sent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sentActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        jPanel1.add(sent, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        nen1.add(jPanel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nen1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nen1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );
    }

    private void sentActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private TaoNen.Nen nen1;
    private SwingLogin.MyButton sent;
}
