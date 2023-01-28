
package stateStation;


import CalculusStation.Location;
import afterStation.Final;
import afterStation.Results;
import centralStation.Game;
import centralStation.Menu;
import graphicsStation.Graphic;
import static graphicsStation.Graphic.nave;
import java.awt.Graphics;
import java.util.ArrayList;
import objectStation.Checkpoint;
import objectStation.Consumable;
import objectStation.Laser;
import objectStation.Meta;
import objectStation.MovingObject;
import objectStation.Nave;
import objectStation.Pista;
import selectStation.Picks;

/**
 *
 * @author Andrea and Adrian
 * 
 */
public  class States {
    
    private Nave nave;
    private Nave nave2;
    private Hud hud1;
    private Hud hud2;
    private Pista pista;    
    private ArrayList <MovingObject> objMov=new ArrayList<>();
    private ArrayList <Consumable> caja=new ArrayList<>();
    private Meta finish;
    private Meta finish2;
    private Checkpoint ch1;
    private Checkpoint ch2;
    private int ren=0;
    public States() {

/*----------------------------------------------------------------------------*/
    //Inicializar naves y sus respectivos HUD´s

        System.out.println(Picks.np1+" "+Picks.np2);
    
        nave = new Nave (Graphic.nave[Picks.np1-1] , new Location(110,350),new Location() ,5,this,1);
        nave2 = new Nave (Graphic.nave[Picks.np2-1] , new Location(180,350),new Location() ,5,this,2);
        hud1= new Hud(nave);
        hud2=new Hud(nave2);
        
/*----------------------------------------------------------------------------*/        
        //iniciar Pista
        
        pista=new Pista(Graphic.pista[Picks.pp1-1],new Location(0,0));
/*----------------------------------------------------------------------------*/
    //iniciar meta y checkpoint

        finish=new Meta(Graphic.meta,new Location(110,420),null,0,this);
        finish2=new Meta(Graphic.meta,new Location(180,420),null,0,this);
        ch1=new Checkpoint(Graphic.meta,new Location(760,330),null,0,this);
        ch2=new Checkpoint(Graphic.meta,new Location(800,390),null,0,this);
/*----------------------------------------------------------------------------*/
    //agregar objetos y caracteristicas a la pista
        Consumable b1=new Consumable(Graphic.cajas[0],new Location(390,620),null,0,this);
        Consumable b2=new Consumable(Graphic.cajas[0],new Location(680,450),null,0,this);
        Consumable b3=new Consumable(Graphic.cajas[0],new Location(945,210),null,0,this);
        Consumable b4=new Consumable(Graphic.cajas[0],new Location(925,590),null,0,this);
        caja.add(b1);
        caja.add(b2);
        caja.add(b3);
        caja.add(b4);
        objMov.add(finish);
        objMov.add(finish2);
        objMov.add(ch1);
        objMov.add(ch2);
        
        for(int i=0;i<caja.size();i++)
            objMov.add(caja.get(i));
        
        objMov.add(nave);
        objMov.add(nave2);
        
/*----------------------------------------------------------------------------*/        
       
        

        //consumable=new Laser(Graphic.laser,nave.centro().addoDesu(nave.getHeadDir().escala(Graphic.nave[3].getWidth()/2)),nave.getHeadDir(),5,nave.getAng());
        
    }
     
    /**
     *  Metodos constantes
     *   renovar
     *   pintar
     * 
     */
    
    public void renovar(){
        //nave.renovar();
        
        
        ren++;
        
        
        for(int i=0;i<objMov.size();i++)
            objMov.get(i).renovar();
        
        if((nave.getLap()>3)||(nave2.getLap()>3)){
            if(nave.getLap()>3){
                Results.winner=nave;
                Results.loser=nave2;
            }else
                if(nave2.getLap()>3){
                    Results.winner=nave2;
                    Results.loser=nave;
                }
            Results.lapfin=true;
            Final after=new Final();
            after.setVisible(true);
            Game.mnCentral.setVisible(false);
            Game.mnCentral.end();
            
                                    
        }
        if((nave.getLifePoints()==0)||(nave2.getLifePoints()==0)){
            if(nave.getLifePoints()==0){
                Results.winner=nave;
                Results.loser=nave2;
            }else
                if(nave2.getLifePoints()==0){
                    Results.winner=nave2;
                    Results.loser=nave;
                }
            Results.lifedepl=true;
            Menu mnfr=new Menu();
            mnfr.setVisible(true);
            Game.mnCentral.setVisible(false);
            Game.mnCentral.end();
        }
        if(ren>=700){
            reGenBox();
            ren=0;
        }    
    }
  
    public void pintar(Graphics graph){
        pista.pintar(graph);
        
        for(int i=0;i<objMov.size();i++)
            objMov.get(i).pintar(graph);
        
        hud1.showLifePoint(graph);
        hud2.showLifePoint(graph);
        hud1.showLaps(graph);
        hud2.showLaps(graph);
        hud1.showItem(graph);
        hud2.showItem(graph);
    
        
        
    }

    public ArrayList<MovingObject> getObjMov() {
        return objMov;
    }
    
    public States getState(){
        return this;
    }

    public Pista getPista() {
        return pista;
    }
    
    
    
   /* public void generarCajas(int i){
        
            for(int j=0;j<4;j++)
                    objMov.add(caja.get(i));
    }
    */

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public Nave getNave2() {
        return nave2;
    }

    public void setNave2(Nave nave2) {
        this.nave2 = nave2;
    }
    
    public void reGenBox(){                
        
        boolean add=false;
        for(int i=0;i<caja.size();i++){
            add=false;
            for(int j=0;j<objMov.size();j++){
                if(caja.get(i).equals(objMov.get(j))){
                    add=false;
                }else
                    if(!(caja.get(i).equals(objMov.get(j)))&&(objMov.get(j)instanceof Consumable))
                        add=true;
            }    
            if(add)
                objMov.add(caja.get(i));
        }
    }
    
}
