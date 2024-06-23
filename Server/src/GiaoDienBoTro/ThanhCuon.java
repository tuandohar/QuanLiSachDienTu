/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiaoDienBoTro;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *
 * @author ANH TUAN
 */
public class ThanhCuon extends JScrollBar{
    public ThanhCuon(){
        setUI(new EditThanhCuon());
        setPreferredSize(new Dimension(5, 5));
        setBackground(new Color(242, 242,242));
        setUnitIncrement(20);
    }
}
