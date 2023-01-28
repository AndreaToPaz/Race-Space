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
import java.util.ArrayList;
import stateStation.States;

/**
 *
 * @author Gabriela
 */
public class Consumable extends MovingObject{
    
    private double ang=0;
    private AffineTransform at;

    public Consumable(BufferedImage imagen, Location posicion, Location vel, double maxVel, States gmStat) {
        super(imagen, posicion, vel, maxVel, gmStat);
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

    @Override
    public Location centro() {
         return new Location(posicion.getX()+imagen.getWidth()/2,posicion.getY()+imagen.getHeight()/2);
    }
    
   /* public void reGenBox(){
        ArrayList <Consumable> csm=new ArrayList<>();
        csm.add(new Consumable(Graphic.cajas[0],new Location(390,620),null,0,gmStat));
        csm.add(new Consumable(Graphic.cajas[0],new Location(680,450),null,0,gmStat));
        csm.add(new Consumable(Graphic.cajas[0],new Location(945,210),null,0,gmStat));
        csm.add(new Consumable(Graphic.cajas[0],new Location(925,590),null,0,gmStat));
        ArrayList<MovingObject> objMov=gmStat.getObjMov();
        boolean add=false;
        for(int i=0;i<csm.size();i++){
            for(int j=0;j<objMov.size();j++){
                if(csm.get(i).equals(objMov.get(j))){
                    add=false;
                }else
                    add=true;
            }    
            if(add)
                objMov.add(csm.get(i));
        }
    }*/
    
}
