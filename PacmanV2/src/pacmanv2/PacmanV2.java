/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacmanv2;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JFrame;

/**
 *
 * @author William
 */
public class PacmanV2 {
    /**
     * @param args the command line arguments
     */
    
    static String constantsFileName = "constants.json";
    static int jFrameWidth = 500;
    static int jFrameHeight = 500;
    static int boxWidth = 20;
    static int boxHeight = 20;
    static Color colorBorderUserBox = Color.green;
    static Color colorNormalBackground = Color.white;
    static Color colorWallBackground = Color.black;
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
        String answer ="";
        try{
            InputStream ips=new FileInputStream(constantsFileName); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            while ((ligne=br.readLine())!=null){
                    System.out.println(ligne);
                    answer+=ligne+"\n";
            }
            br.close(); 
            }		
            catch (Exception e){
                    System.out.println(e.toString());
            }
    }
    
    public static void createJFrame(){
        JFrame window = new JFrame();
        window.setLayout(null);
        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setTitle(jFrameTitle);
        window.setBackground(colorNormalBackground);
        window.setSize(jFrameWidth, jFrameHeight);
        
        new MapContent(window);
        window.setVisible(true);
        
    }
    
}
