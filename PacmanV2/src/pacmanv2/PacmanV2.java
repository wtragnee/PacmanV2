/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacmanv2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author William
 */
public class PacmanV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jFrameTest = new JFrame();
        jFrameTest.setLayout(null);
        jFrameTest.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrameTest.setTitle("PacmanV2");
        jFrameTest.setSize(500, 500);
        JPanel jPanelTest = new JPanel();
        jPanelTest.setLocation(240, 240);
        jPanelTest.setSize(20, 20);
        jPanelTest.setMaximumSize(new Dimension(20,20));
        jPanelTest.setBackground(Color.blue);
        jPanelTest.setPreferredSize(new Dimension(20,20));
        Dimension dimensionTest = jFrameTest.getSize();
        System.out.println(dimensionTest.getHeight());
        System.out.println(dimensionTest.getWidth());
        jFrameTest.add(jPanelTest);
        jFrameTest.setVisible(true);
    }
    
}
