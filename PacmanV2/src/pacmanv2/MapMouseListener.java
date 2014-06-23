/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacmanv2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author William
 */
public class MapMouseListener implements MouseListener{
    
    Coordinate coord;
    MapMouseListener(Coordinate coord) {
        this.coord = coord;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        coord.changeWall();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
