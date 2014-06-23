/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacmanv2;

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
    private List<int[]> coordsList;
    private List<JPanel> jPanelList;
    /* for each coords in coordsList :
        - first is positionX
        - second is positionY
        - third is width
        - fourth is height
        - fifth and last is index of JPanel in list of JPanels
    */
    
    
    // if new map
    public MapContent(JFrame window) {
        this.window = window;
        this.editingMap = true;
        coordsList = new ArrayList();
        userBox = new JPanel();
        userBox.setBorder(BorderFactory.createLineBorder(PacmanV2.colorBorderUserBox));
        userBox.setSize(new Dimension(PacmanV2.boxWidth,PacmanV2.boxHeight));
        this.window.addKeyListener(new MapKeyListener(this));
        this.window.add(userBox);
    }
    
    public void editMap() {
        boolean isCoordsModified = false;
        int currentPositionX1 = (int) userBox.getLocation().getX();
        int currentPositionY1 = (int) userBox.getLocation().getY();
        int currentPositionX2 = currentPositionX1 + PacmanV2.boxWidth;
        int currentPositionY2 = currentPositionY1 + PacmanV2.boxHeight;
        for(int[] coords : coordsList) {
            if(currentPositionX1 == coords[0] && currentPositionX2 == (coords[0]+coords[2])) {// X1 = coord 1 et X2 < coord 1 + coord3
                
            }
        }
        if(!isCoordsModified) {
            this.addNewZoneToMap(currentPositionX1, currentPositionY1);
        }
    }
    
    public void addNewZoneToMap(int coordX, int coordY){
        JPanel newZone = new JPanel();
        newZone.setSize(PacmanV2.boxWidth, PacmanV2.boxHeight);
        newZone.setLocation(coordX, coordY);
        newZone.setBackground(PacmanV2.colorWallBackground);
        this.window.add(newZone);
        this.jPanelList.add(newZone);
        //System.out.println(coordX);
        //System.out.println(coordY);
    }
    
    public void saveMap(){
        System.out.println(window.getComponentCount());
    }
}
