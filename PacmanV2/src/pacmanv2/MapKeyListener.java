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
                    if(keyCode == KeyEvent.VK_LEFT) {
                        this.map.leftMove();
                    } else if (keyCode == KeyEvent.VK_RIGHT) {
                        this.map.rightMove();
                    } else if (keyCode == KeyEvent.VK_DOWN) {
                        this.map.downMove();
                    } else if (keyCode == KeyEvent.VK_UP) {
                        this.map.upMove();
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
