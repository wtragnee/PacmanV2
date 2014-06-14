/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacmanv2;

import javax.swing.JFrame;

/**
 *
 * @author William
 */
public class PacmanV2 {
    /**
     * @param args the command line arguments
     */
    
    static int jFrameWidth = 500;
    static int jFrameHeight = 500;
    static int boxWidth = 20;
    static int boxHeight = 20;
    static String jFrameTitle = "PacmanV2";
    // Continue
    
    public static void main(String[] args) {
        // JPanel jPanelTest = new JPanel();
        // jPanelTest.setLocation(240, 240);
        // jPanelTest.setSize(20, 20);
        /*jPanelTest.setMaximumSize(new Dimension(20,20));
        jPanelTest.setBackground(Color.blue);
        jPanelTest.setPreferredSize(new Dimension(20,20));
        Dimension dimensionTest = jFrameTest.getSize();
        jFrameTest.add(jPanelTest);
        jFrameTest.addKeyListener(new MapKeyListener(jPanelTest));
        jFrameTest.setVisible(true);*/
        createJFrame();
    }
    
    public static void loadConstants(){
        
    }
    
    public static void createJFrame(){
        JFrame window = new JFrame();
        window.setLayout(null);
        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setTitle(jFrameTitle);
        window.setSize(jFrameWidth, jFrameHeight);
        
        new MapContent(window);
        window.setVisible(true);
        
    }
    
}
