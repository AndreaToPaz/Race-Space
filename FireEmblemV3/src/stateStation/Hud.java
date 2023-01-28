/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateStation;

import CalculusStation.Location;
import graphicsStation.Graphic;
import java.awt.Graphics;
import objectStation.Nave;
import objectStation.Thrower;

/**
 *
 * @author Gabriela
 */
public class Hud {
    private Nave nv;
    private int plyr;

    public Hud(Nave nv) {
        this.nv = nv;
        plyr=nv.getKeyset();
    }
    
    public void showLifePoint(Graphics graph){
        Location pos=null;
        if(plyr==1){
            pos=new Location(30,30);
        }
        else
            if(plyr==2){
                pos=new Location(800,30);
            }
        if(pos!=null){
            
            graph.drawImage(Graphic.lives[0],(int)pos.getX(),(int)pos.getY(),null);
            pos.setX(pos.getX()+45);
            pos.setY(pos.getY()+5);
            graph.drawImage(Graphic.nums[10],(int)pos.getX(),(int)pos.getY(),null);
            pos.setX(pos.getX()+30);
            graph.drawImage(Graphic.nums[nv.getLifePoints()],(int)pos.getX(),(int)pos.getY(), null);
        }
    }
    
    public void showLaps(Graphics graph){
        Location pos=null;
        if(plyr==1)
            pos=new Location(30,70);
        else
            if(plyr==2)
                pos=new Location(800,70);
        if(pos!=null){
            graph.drawImage(Graphic.nums[nv.getLap()],(int)pos.getX(),(int)pos.getY(),null);
            
        }
            
    }
    
    public void showItem(Graphics graph){
        Location pos=null;
        Thrower tr=nv.getTrw();
        int item=tr.getPick();
        if(plyr==1)
            pos=new Location(230,30);
        else
            if(plyr==2)
                pos=new Location(1000,30);
        
        if(pos!=null){
            switch (item){
                case 1:
                    graph.drawImage(Graphic.cajas[1],(int)pos.getX(),(int)pos.getY(),null);
                    break;
                case 2:
                    graph.drawImage(Graphic.laser,(int)pos.getX(),(int)pos.getY(),null);
                    break;
                case 3:
                    graph.drawImage(Graphic.heals,(int)pos.getX(),(int)pos.getY(),null);
                    break;
            }
        }
        
    }
}
