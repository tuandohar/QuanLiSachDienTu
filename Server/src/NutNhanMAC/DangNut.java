/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NutNhanMAC;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.RenderingHints;

/**
 *
 * @author ANH TUAN
 */
public class DangNut extends JButton{
  private int round =20;
  public DangNut(){
      setContentAreaFilled(false);
      setBorder(new EmptyBorder(6,6,6,6));
      setCursor(new Cursor(Cursor.HAND_CURSOR));
  }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width=getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int x= (width-size)/2;
        int y= (width-size)/2;
        g2.fillOval(x, y, width, height);
        super.paint(g); 
    }
}