
package MenuSwing;

import EventItem1.EventMenuSelected;
import MODEL.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;


public class Menu extends javax.swing.JPanel {
    private EventMenuSelected event;
    private int x;
    private int y;

   public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu2.addEventMenuSelected(event);
    }
    public Menu() {
        initComponents();

        setOpaque(false);
        listMenu2.setOpaque(false);
        init();
    }

    private void init() {
        listMenu2.addItem(new Model_Menu("1", "Quản lí người dùng", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("2", "Quản lí sách", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("3", "Phản hồi", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("4", "Doanh thu", Model_Menu.MenuType.MENU));
       
        
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));

       // listMenu2.addItem(new Model_Menu("", "My Data", Model_Menu.MenuType.TITLE));
        //listMenu2.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        //listMenu2.addItem(new Model_Menu("6", "My Profile", Model_Menu.MenuType.MENU));
        //listMenu2.addItem(new Model_Menu("7", "Profit", Model_Menu.MenuType.MENU));
        //listMenu2.addItem(new Model_Menu("8", "Book managers", Model_Menu.MenuType.MENU));
        //listMenu2.addItem(new Model_Menu("9", "User Managets", Model_Menu.MenuType.MENU));
       // listMenu2.addItem(new Model_Menu("10", "Logout", Model_Menu.MenuType.MENU));
        listMenu2.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
    }

    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    public void initMoving(JFrame fram) {
        PanelMove.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        PanelMove.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        PanelMove = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listMenu2 = new MenuSwing.ListMenu<>();

        PanelMove.setBackground(new java.awt.Color(204, 204, 204));
        PanelMove.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/logo.png"))); // NOI18N
        jLabel2.setText("Application");

        javax.swing.GroupLayout PanelMoveLayout = new javax.swing.GroupLayout(PanelMove);
        PanelMove.setLayout(PanelMoveLayout);
        PanelMoveLayout.setHorizontalGroup(
            PanelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );
        PanelMoveLayout.setVerticalGroup(
            PanelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMoveLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2))
        );

        listMenu2.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(listMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JPanel PanelMove;
    private javax.swing.JLabel jLabel2;
    private MenuSwing.ListMenu<String> listMenu2;
    // End of variables declaration                   
}
