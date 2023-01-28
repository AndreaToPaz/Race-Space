/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateStation;

    import CalculusStation.Location;
    import graphicsStation.Graphic;
    import static graphicsStation.Graphic.nave;
    import java.awt.Graphics;
    import java.util.ArrayList;
    import objectStation.Consumable;
    import objectStation.Laser;
    import objectStation.MovingObject;
    import objectStation.Nave;
    import objectStation.Pista;



/**
 *
 * @author Gabriela
 */
public class ServerStates extends States {
    private Nave nave;
    private Nave nave2;
    private Pista pista;
    private Consumable caja;
    
    private ArrayList<MovingObject> objMov=new ArrayList<>();
    

    public ServerStates() {
        nave = new Nave (Graphic.nave[3] , new Location(100,100),new Location() ,5,this,1);
        pista=new Pista(Graphic.pista[0],new Location(0,0));
        caja=new Consumable(Graphic.cajas[0],new Location(400,400),null,0,this);
        nave2 = new Nave (Graphic.nave[2] , new Location(200,200),new Location() ,5,this,1);
        objMov.add(nave);
        objMov.add(nave2);
        objMov.add(caja);
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
        
        for(int i=0;i<objMov.size();i++)
            objMov.get(i).renovar();
        
    }
  
    public void pintar(Graphics graph){
        pista.pintar(graph);
        //nave.pintar(graph);
        for(int i=0;i<objMov.size();i++)
            objMov.get(i).pintar(graph);
        
    }

    public ArrayList<MovingObject> getObjMov() {
        return objMov;
    }
    
    @Override
    public ServerStates getState(){
        return this;
    }
}
