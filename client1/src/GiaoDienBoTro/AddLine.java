/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiaoDienBoTro;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ANH TUAN
 */
public class AddLine {
    public static void addMultilineLabel(JPanel panel, JLabel label){
        int panelWidth = panel.WIDTH;
        Dimension labelSize = label.getPreferredSize();
        if(labelSize.width>panelWidth){
            label.setText("<html>"+ label.getText()+"</html>");
        }
    }
}
