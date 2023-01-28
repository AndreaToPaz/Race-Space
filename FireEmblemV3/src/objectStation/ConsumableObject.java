/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectStation;

import CalculusStation.Location;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import objectStation.MovingObject;
import objectStation.Nave;
import stateStation.States;

/**
 *
 * @author Gabriela
 */
public class ConsumableObject extends MovingObject {
    
    private int actual;
    private Nave nv;
    private double ang=0;
    
    
    public ConsumableObject(BufferedImage imagen, Location posicion, Location vel, double maxVel, States gmStat,int pick,Nave nv) {
        super(imagen, posicion, vel, maxVel, gmStat);
        actual=pick;
        this.nv=nv;
        
    }
    
    public int random(){
         return (int)((Math.random()*3)+1);
    }
    
    
    @Override
    public void renovar() {
        ang+=0.04;
    }

    @Override
    public void pintar(Graphics graph) {
        Graphics2D g2d=(Graphics2D)graph;
        at=AffineTransform.getTranslateInstance(posicion.getX(),posicion.getY());
        at.rotate(ang,this.imagen.getTileWidth()/2,this.imagen.getHeight()/2);
        g2d.drawImage(imagen, at, null);
    }
    
    
    public void throwConsumable(){
        
        switch (actual){
            case 1:
                
                actual=0;
                break;
            case 2:;
            case 3:;
        }
            
        
            
    
    }

    @Override
    public Location centro() {
         return new Location(posicion.getX()+imagen.getWidth()/2,posicion.getY()+imagen.getHeight()/2);
    }

    public Nave getNv() {
        return nv;
    }

    public void setNv(Nave nv) {
        this.nv = nv;
    }
    
    
    
}
