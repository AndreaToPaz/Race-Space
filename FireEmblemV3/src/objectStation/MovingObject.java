/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectStation;

import CalculusStation.Location;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import stateStation.States;

/**
 *
 * @author Gabriela
 */
public abstract class MovingObject extends Object {
    
    protected Location vel;
    protected AffineTransform at;
    protected double ang;
    protected double maxVel;
    protected States gmStat;
    protected Rectangle nrc;

    public MovingObject(BufferedImage imagen, Location posicion,Location vel,double maxVel,States gmStat) {
        super(imagen, posicion);
        this.maxVel=maxVel;
        this.vel=vel;
        this.gmStat=gmStat;
        this.ang=0;
    }
    
    //public abstract Location centro();
    
    
    
    public void colisionaCon(){
        ArrayList<MovingObject> arr=gmStat.getObjMov();
        for(int i=0;i<arr.size();i++){
            MovingObject obj=arr.get(i);
            if(obj.equals(this))
                continue;
            double dist=((this.centro()).subboDesu(obj.centro())).getM();
            
            if(dist<=(this.imagen.getWidth()/2+obj.imagen.getWidth()/2)){
                
                colision(this,obj);
            }                                
        }
    
    }
    
    public Rectangle getNrc() {
        return nrc;
    }
    
    public void colision(MovingObject obj1,MovingObject obj2){
            Nave nv=(Nave)obj1;
            
            if(obj1 instanceof Nave && obj2 instanceof Consumable){
                nv.getTrw().random();
                obj2.remover();
            }
            
            if(obj1 instanceof Nave && obj2 instanceof Nave)
                obj1.vel=obj1.vel.escala(-1); 
            
            if((obj1 instanceof Nave)&&(obj2 instanceof ConsumableObject)){
                ConsumableObject cobj=(ConsumableObject)obj2;
                
                if(!nv.equals(cobj.getNv())){
                    obj1.vel=obj1.vel.escala(0);
                    nv.damage();
                    obj2.remover();
                }
            
            }
            
            if(obj1 instanceof Nave && (obj2 instanceof Meta)&&(nv.isCanPass())){
                nv.comparePos();
                nv.setCanPass(false);
                nv.setLap();
                System.out.println(nv.getLap());
                
            }
            if(obj1 instanceof Nave && obj2 instanceof Checkpoint ){
                nv.comparePos();
                nv.setCanPass(true);
            }
            
            if(obj1 instanceof Nave && obj2 instanceof Laser){
                Laser lsr=(Laser)obj2;
                if(!nv.equals(lsr.getNv())){
                    nv.damage();
                    obj2.remover();
                }
                
            }
            
            //obj1.vel=obj1.vel.escala(-1); colision elastica
    }
    
    public void colisionPared(){
        ArrayList <Rectangle> arr=gmStat.getPista().getArrObj();
        for(int i=0;i<arr.size();i++){
            Rectangle rr=arr.get(i);
            
            if(this.getNrc().intersects(rr))
                this.vel=this.vel.escala(0.1);
                
        }
    }
    
    public void remover(){
        gmStat.getObjMov().remove(this);
    }
    
    
    
    
    
}
