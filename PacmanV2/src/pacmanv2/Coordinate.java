/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacmanv2;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author William
 */
class Coordinate {
    Position position;
    boolean isWall;
    JPanel jPanel;
    
    Coordinate(int positionX, int positionY, boolean isWall, JPanel jPanel) {
        this.position = new Position(positionX, positionY);
        this.isWall = isWall;
        this.jPanel = jPanel;
        this.setBoxAsNotUserBox();
        this.setBackground();
    }
    
    void setBoxAsUserBox() {
        jPanel.setBorder(BorderFactory.createLineBorder(PacmanV2.colorBorderUserBox));
    }
    
    void setBoxAsNotUserBox() {
        jPanel.setBorder(BorderFactory.createLineBorder(PacmanV2.colorBorderNormalBox));
    }
    
    void changeWall() {
        isWall = !isWall;
        this.setBackground();
    }
    
    void setBackground(){
        if(isWall) {
            jPanel.setBackground(PacmanV2.colorWallBackground);
        } else {
            jPanel.setBackground(PacmanV2.colorNormalBackground);
        }
    }
}
