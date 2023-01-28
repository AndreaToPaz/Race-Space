/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectStation;
   
import graphicsStation.Graphic;
import java.util.ArrayList;
import stateStation.States;
import CalculusStation.Location;
import objectStation.Laser;
import objectStation.MovingObject;
import objectStation.Nave;

    
/**
 *
 * @author Gabriela
 */
public class Thrower {
    private int pick=0;
    private States state;
    private Nave nv;
    
    
    public Thrower(States state,Nave nv) {
        this.state=state;
        this.nv=nv;
    }
    
    public void random(){
        
        pick=(int)((Math.random()*3)+1);
        System.out.println(pick);
    }
     
    public void throwConsumable(){
        ArrayList <MovingObject> objMov=state.getObjMov();
        switch (pick){
            case 1:
                ConsumableObject csmb=new ConsumableObject(Graphic.cajas[1],nv.posicion,null,0,state,pick,nv);
                objMov.add(csmb);
                pick=0;
                break;
            case 2:
                objMov.add(new Laser(Graphic.laser,nv.centro().addoDesu(nv.getHeadDir().escala(nv.imagen.getWidth()/2)),nv.getHeadDir().escala(5),5,state,nv.ang,nv));
                
                pick=0;
                break;
            case 3:
                nv.heal();
                pick=0;
                break;
                
        }
                                    
    } 

    public int getPick() {
        return pick;
    }

    public void setPick(int pick) {
        this.pick = pick;
    }
     
     
    
}
