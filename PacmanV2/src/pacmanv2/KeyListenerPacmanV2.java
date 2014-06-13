/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanv2;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TreeSet;
import javax.swing.JPanel;

/**
 *
 * @author William
 */
public class KeyListenerPacmanV2 implements KeyListener {

    private TreeSet<Integer> set = new TreeSet<Integer>();
    JPanel boxUser;
    int pixelPerFrame = 1;

    public KeyListenerPacmanV2(JPanel jPanel) {
        this.boxUser = jPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        set.add(e.getExtendedKeyCode());
        for (int keyCode : set) {
            executeKey(keyCode);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        set.remove(e.getExtendedKeyCode());
    }
    
    private void executeKey(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT
                    || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_UP) {
                int locationModified;
                double locationX = boxUser.getLocation().getX();
                double locationY = boxUser.getLocation().getY();
                
                if (keyCode == KeyEvent.VK_LEFT) {
                    locationModified = (int) locationX - pixelPerFrame;
                    boxUser.setLocation(locationModified, (int) locationY);
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    locationModified = (int) locationX + pixelPerFrame;
                    boxUser.setLocation(locationModified, (int) locationY);
                } else if (keyCode == KeyEvent.VK_UP) {
                    locationModified = (int) locationY - pixelPerFrame;
                    boxUser.setLocation((int) locationX, locationModified);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    locationModified = (int) locationY + pixelPerFrame;
                    boxUser.setLocation((int) locationX, locationModified);
                }
            } else if (keyCode == KeyEvent.VK_SPACE) {
                if(boxUser.getBackground() == Color.red) {
                    boxUser.setBackground(Color.blue);
                } else {
                    boxUser.setBackground(Color.red);
                }
            }
    }
}
