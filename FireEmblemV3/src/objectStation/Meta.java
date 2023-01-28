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
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import stateStation.States;

/**
 *
 * @author Gabriela
 */
public class Meta extends MovingObject{
    
    
    public Meta(BufferedImage imagen, Location posicion, Location vel, double maxVel, States gmStat) {
        super(imagen, posicion, vel, maxVel, gmStat);
    }

    

    @Override
    public void renovar() {
    }

    @Override
    public void pintar(Graphics graph) {
        Graphics2D g2d=(Graphics2D)graph;
        at=AffineTransform.getTranslateInstance(posicion.getX(),posicion.getY());
        g2d.drawImage(Graphic.meta,at, null);
    }

    @Override
     public Location centro(){
        return new Location(posicion.getX()+imagen.getWidth()/2,posicion.getY()+imagen.getHeight()/2);
    }
    
}
