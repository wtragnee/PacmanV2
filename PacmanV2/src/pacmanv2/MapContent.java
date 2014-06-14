/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacmanv2;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author William
 */
public class MapContent {
    
    JFrame window;
    boolean editingMap;
    JPanel userBox;
    private final List<Integer[]> coords;
    /* for each coord in coords :
        - first is positionX
        - second is positionY
        - third is width
        - fourth and last is height
    */
    
    
    // if new map
    public MapContent(JFrame window) {
        this.window = window;
        this.editingMap = true;
        coords = new ArrayList();
        userBox = new JPanel();
        userBox.setBorder(BorderFactory.createLineBorder(Color.green));
        userBox.setSize(new Dimension(PacmanV2.boxWidth,PacmanV2.boxHeight));
        this.window.addKeyListener(new MapKeyListener(this));
        this.window.add(userBox);
    }
    
    public void editMap() {
        boolean isCoordsModified = false;
        
    }
}
