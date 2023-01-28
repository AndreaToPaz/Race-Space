/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectStation;

import CalculusStation.Location;
import static centralStation.Central.ALTO;
import static centralStation.Central.ANCHO;
import controlStation.Piano;
import controlStation.Piano2;
import graphicsStation.Graphic;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import stateStation.States;

/**
 *
 * @author Andrea
 */


public class Nave extends MovingObject{
    private int LifePoints=3;
    private Location headDir;
    private Location acc;           //Aceleracion
    private final double ACCEL=0.08;
    private final double DACCEL=0.1;
    private States state;
    private int keyset=0;
    private int lap=1;
    private int pos=0;
    private boolean canPass=false;
    private Thrower trw;
    

    public Nave(BufferedImage imagen, Location posicion, Location vel,double maxVel,States state,int keyset) {
        super(imagen,posicion,vel,maxVel,state);
        headDir=new Location(0,1);
        acc=new Location();
        this.state=state;
        this.keyset=keyset;
        nrc=new Rectangle((int)posicion.getX(),(int)posicion.getY(),imagen.getWidth(),imagen.getHeight());
        
        trw=new Thrower(state,this);
        
    }
   
    @Override
    public void renovar() {
        
        
        /*if(Piano2.objeto){          
            state.getObjMov().add(new Laser(Graphic.laser,
                    centro().addoDesu(headDir.escala(Graphic.nave[3].getWidth()/2))
                    ,headDir.escala(4),20,ang));
        }*/
            this.nrc.setLocation((int)posicion.getX(),(int)posicion.getY());
            
        if(keyset==1){
            if(Piano.derecha)
                ang+=Math.PI/50;
            if(Piano.izquierda)
                ang-=Math.PI/50;        
            if(Piano.arriba){
                acc=headDir.escala(ACCEL);
            }else{
                if(vel.getM()!=0)
                    acc=((vel.escala(-1)).norm()).escala(ACCEL);
            }        
            if(Piano.abajo){
                acc=headDir.escala(-ACCEL/2);
            }                        
            if(Piano.shift){
                acc=(vel.escala(-1)).escala(DACCEL*2);
            }
            
            if(Piano.objeto){
                trw.throwConsumable();
            }
            
            // if(Piano.objeto)
        }    
        
        if(keyset==2){
            if(Piano2.derecha)
                ang+=Math.PI/50;
            if(Piano2.izquierda)
                ang-=Math.PI/50;        
            if(Piano2.arriba){
                acc=headDir.escala(ACCEL);
            }else{
                if(vel.getM()!=0)
                    acc=((vel.escala(-1)).norm()).escala(ACCEL);
                }        
            if(Piano2.abajo){
                acc=headDir.escala(-ACCEL/2);
            }                        
            if(Piano2.shift){
                acc=(vel.escala(-1)).escala(DACCEL*2);
            }
            
            if(Piano2.objeto){
                trw.throwConsumable();
            }
            
           // if(Piano2.objeto)
                
            
        }        

        
        vel=vel.addoDesu(acc);
        vel.limite(maxVel);
        headDir=headDir.newDirection(ang-Math.PI/2);
        posicion=posicion.addoDesu(vel);   
        colisionaCon();
        colisionPared();
        //System.out.println("Location : X= "+posicion.getX()+"  Y= "+posicion.getY());
        
    }
    

    
    @Override
     public Location centro(){
        return new Location(posicion.getX()+imagen.getWidth()/2,posicion.getY()+imagen.getHeight()/2);
    }
     
    public double getAng() {
        return ang;
    }

    public Location getHeadDir() {
        return headDir;
    }

    public int getKeyset() {
        return keyset;
    }
    
    
   
    @Override
    public void pintar(Graphics graph) {    
        Graphics2D gd2=(Graphics2D)graph;
        at=AffineTransform.getTranslateInstance(posicion.getX(),posicion.getY());
        if(keyset==1){
            at.rotate(ang,imagen.getWidth()/2,imagen.getHeight()/2);
            gd2.drawImage(imagen, at, null);
        }
        if(keyset==2){
            at.rotate(ang,imagen.getWidth()/2,imagen.getHeight()/2);
            gd2.drawImage(imagen, at, null);
        }
    }

    public boolean isCanPass() {
        return canPass;
    }

    public void setCanPass(boolean canPass) {
        this.canPass = canPass;
    }

    public int getLap() {
        return lap;
    }

    public void setLap() {
        lap++;
    }
    
    public void damage(){
        LifePoints--;
    }
    
    public void heal(){
        LifePoints++;
    }

    public Thrower getTrw() {
        return trw;
    }

    public void setTrw(Thrower trw) {
        this.trw = trw;
    }

    public void comparePos(){
        Nave nv1,nv2;
        nv1=state.getNave();
        nv2=state.getNave2();
        
        if(nv1.getLap()>=nv2.getLap()){
            if(nv1.canPass && !nv2.canPass){
                nv1.pos=1;
                nv2.pos=2;
            }else
                if(!nv1.canPass && nv2.canPass && (nv2.getPosicion().getX()>200)){
                    nv1.pos=1;
                    nv2.pos=2;
                }
        }
        if(nv2.getLap()>=nv1.getLap()){
            if(nv1.canPass && !nv2.canPass){
                nv1.pos=1;
                nv2.pos=2;
            }else
                if(!nv1.canPass && nv2.canPass){
                    nv1.pos=2;
                    nv2.pos=1;
                }
            
            
            
            /*if((nv1.getLap()<nv2.getLap())){
                nv1.pos=2;
                nv2.pos=1;
            }else
                if(nv2.getLap()<nv1.getLap()){
                    nv1.pos=1;
                    nv2.pos=2;
                }*/
        
            }
        System.out.println("nv= "+nv1.getPos()+"nv2= "+nv2.getPos());
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getLifePoints() {
        return LifePoints;
    }

    
    
    
    
    
    
    
}
