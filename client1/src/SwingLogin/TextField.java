/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SwingLogin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ANH TUAN
 */
public class TextField extends JTextField {

    public TextField() {
        setBorder(new EmptyBorder(7, 5, 7, 5));
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (isFocusOwner()) {
            g2.setColor(new Color(6, 135, 196));
            g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            g2.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
        } else {
            g2.setColor(new Color(76, 181, 195));
            g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            g2.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
        }

    }
}
