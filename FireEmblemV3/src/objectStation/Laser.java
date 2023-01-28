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
import stateStation.States;

/**
 *
 * @author Gabriela
 */
public class Laser extends MovingObject {
    private Nave nv;

    public Laser(BufferedImage imagen, Location posicion, Location vel, double maxVel, States gmStat,double ang,Nave nv) {
        super(imagen, posicion, vel, maxVel, gmStat);
        this.ang=ang;
        this.vel=vel;
        this.nv=nv;
        
    }

    
    @Override
    public void renovar() {
        this.posicion=posicion.addoDesu(vel);
        
    }

    @Override
    public void pintar(Graphics graph) {
        Graphics2D g2d=(Graphics2D)graph;
        at=AffineTransform.getTranslateInstance(this.posicion.getX(),this.posicion.getY());
        at.rotate(ang);
        g2d.drawImage(imagen, at, null);
    }

    @Override
    public Location centro() {
        return new Location(posicion.getX()+imagen.getWidth()/2,posicion.getY());
    }

    public Nave getNv() {
        return nv;
    }

    public void setNv(Nave nv) {
        this.nv = nv;
    }
    
    
    
}
