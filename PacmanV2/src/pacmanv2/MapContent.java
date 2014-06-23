/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacmanv2;

import java.awt.GridLayout;
import java.util.List;
import java.util.ArrayList;
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
    List<Coordinate> coordsList;
    Position currentPosition;
    int numberX; // Number of columns
    int numberY; // Number of lines
    
    // if new map
    MapContent(JFrame window, int numberX, int numberY) {
        this.window = window;
        this.editingMap = true;
        coordsList = new ArrayList();
        this.numberX = numberX;
        this.numberY = numberY;
        
        this.window.setLayout(new GridLayout(numberX, numberY));
        for (int i = 0; i < numberX; i++) {
            for (int j = 0; j < numberY; j++) {
                JPanel jPanel = new JPanel();
                coordsList.add(new Coordinate(j, i, false, jPanel));
                this.window.add(jPanel);
            }
        }
        currentPosition = new Position(0,0);
        this.window.addKeyListener(new MapKeyListener(this));
        this.setUserBox();
    }
    
    void setUserBox(){
        for (Coordinate coord : coordsList) {
            if(coord.position.positionX == currentPosition.positionX 
                    && coord.position.positionY == currentPosition.positionY) {
                coord.setBoxAsUserBox();
            } else {
                coord.setBoxAsNotUserBox();
            }
        }
    }
    
    void editMap() {
        for (Coordinate coord : coordsList) {
            if(coord.position.positionX == currentPosition.positionX 
                    && coord.position.positionY == currentPosition.positionY) {
                coord.changeWall();
            }
        }
    }
    
    void leftMove(){
        if(currentPosition.positionX > 0) {
            currentPosition.positionX--;
        } else {
            currentPosition.positionX = numberX-1;
        }
        setUserBox();
    }
    
    void rightMove() {
        if(currentPosition.positionX < numberX-1) {
            currentPosition.positionX++;
        } else {
            currentPosition.positionX = 0;
        }
        setUserBox();
    }
    
    void upMove() {
        if(currentPosition.positionY > 0) {
            currentPosition.positionY--;
        } else {
            currentPosition.positionY = numberY-1;
        }
        setUserBox();
    }
    
    void downMove() {
        if(currentPosition.positionY < numberY-1) {
            currentPosition.positionY++;
        } else {
            currentPosition.positionY = 0;
        }
        setUserBox();
    }
    
    void saveMap(){
        System.out.println(currentPosition.positionX);
        System.out.println(currentPosition.positionY);
    }
}
