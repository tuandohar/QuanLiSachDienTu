/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiaoDienBoTro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author ANH TUAN
 */
public class EditThanhCuon extends BasicScrollBarUI {

    //domo1 ám chỉ độ mờ khi di chuột, còn doMo2 ám chỉ khi không di chuột
    private static final int doMo1 = 100;
    private static final int doMo2 = 50;
    private static final int size = 5;
    private static final Color color = Color.BLACK;

    public EditThanhCuon() {

    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        super.paintTrack(g, c, trackBounds); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return super.createIncreaseButton(orientation); 
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return super.createDecreaseButton(orientation); 
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        super.paintThumb(g, c, thumbBounds); 
        int alpha = isThumbRollover()? doMo1:doMo2;
        int huong = scrollbar.getOrientation();
        int x=thumbBounds.x;
        int y=thumbBounds.y;
        int width= huong==JScrollBar.VERTICAL?size:thumbBounds.width;
        width = Math.max(width, size);
        int height = huong==JScrollBar.VERTICAL?thumbBounds.height:size;
        height=Math.max(height, size);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(x, y, width, height, 5, 5);
        g2.dispose();
    }
    private static class VoHinhNut extends JButton{
        private VoHinhNut(){
            setOpaque(false);
            setFocusable(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setBorder(BorderFactory.createEmptyBorder());
        }
    }
}
