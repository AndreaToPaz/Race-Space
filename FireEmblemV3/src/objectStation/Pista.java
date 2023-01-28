/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectStation;

import CalculusStation.Location;
import graphicsStation.Graphic;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Gabriela
 */
public class Pista extends Object{
    
    
    public Pista(BufferedImage imagen, Location posicion) {
        super(imagen, posicion);
        
        arrObj.add(new Rectangle(0,0,1200,120));  //limite superior
        arrObj.add(new Rectangle(0,0,70,800));    //izquierdo
        arrObj.add(new Rectangle(1040,130,1200-1030,720)); //derecho
        arrObj.add(new Rectangle(70,730,1200-80,90));   //inferior
        arrObj.add(new Rectangle(270,330,500-240,520-280));
        arrObj.add(new Rectangle(900,420,1000-830,525-420));
        arrObj.add(new Rectangle(555,260,720-555,300-225));
        
        
        
    }

    @Override
    public void renovar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pintar(Graphics graph) {
        Graphics2D g2d=(Graphics2D)graph;
        g2d.drawImage(imagen, 0, 0, null);
    }

    @Override
    public Location centro() {
        return null;
    }

    public ArrayList<Rectangle> getArrObj() {
        return arrObj;
    }
    
    
    
}
