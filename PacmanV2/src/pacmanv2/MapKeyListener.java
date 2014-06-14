/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanv2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TreeSet;

/**
 *
 * @author William
 */
public class MapKeyListener implements KeyListener {

    private TreeSet<Integer> set = new TreeSet<Integer>();
    MapContent map;
    int pixelPerFrame = 2;

    public MapKeyListener(MapContent map) {
        this.map = map;
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
                double locationX = map.userBox.getLocation().getX();
                double locationY = map.userBox.getLocation().getY();
                
                if (keyCode == KeyEvent.VK_LEFT) {
                    locationModified = (int) locationX - pixelPerFrame;
                    map.userBox.setLocation(locationModified, (int) locationY);
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    locationModified = (int) locationX + pixelPerFrame;
                    map.userBox.setLocation(locationModified, (int) locationY);
                } else if (keyCode == KeyEvent.VK_UP) {
                    locationModified = (int) locationY - pixelPerFrame;
                    map.userBox.setLocation((int) locationX, locationModified);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    locationModified = (int) locationY + pixelPerFrame;
                    map.userBox.setLocation((int) locationX, locationModified);
                }
            } else if (keyCode == KeyEvent.VK_SPACE) {
                if(map.editingMap) {
                    map.editMap();
                } else {
                    
                }
            } else if (keyCode == KeyEvent.VK_ENTER) {
                map.saveMap();
            }
    }
}
