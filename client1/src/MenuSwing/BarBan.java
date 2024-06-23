/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuSwing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author ANH TUAN
 */
public class BarBan extends JPanel {

    public BarBan() {

    }

    /**
     *
     * @author ANH TUAN
     */
    public class Bar extends javax.swing.JPanel {

        /**
         * Creates new form Bar
         */
        public Bar() {

        }

        @Override
        protected void paintChildren(Graphics grphcs) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            GradientPaint g = new GradientPaint(0, 0, Color.decode("#d34566"), 0, getHeight(), Color.decode("#000046"));
            g2.setPaint(g);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

            super.paintChildren(grphcs); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }

    }
}
