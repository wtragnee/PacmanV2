/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacmanv2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author William
 */
public class KeyListenerPacmanV2 implements KeyListener {

    JPanel boxUser;
    int pixelPerFrame = 1;
    
    public KeyListenerPacmanV2 (JPanel jPanel) {
        this.boxUser = jPanel;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int locationModified;
        double locationX = boxUser.getLocation().getX();
        double locationY = boxUser.getLocation().getY();
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            locationModified = (int) locationX - pixelPerFrame;
            boxUser.setLocation(locationModified, (int) locationY);
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            locationModified = (int) locationX + pixelPerFrame;
            boxUser.setLocation(locationModified, (int) locationY);
        } else if(e.getKeyCode() == KeyEvent.VK_UP) {
            locationModified = (int) locationY - pixelPerFrame;
            boxUser.setLocation((int) locationX, locationModified);
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            locationModified = (int) locationY + pixelPerFrame;
            boxUser.setLocation((int) locationX, locationModified);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
