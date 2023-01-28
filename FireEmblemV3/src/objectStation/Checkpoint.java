/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectStation;

import CalculusStation.Location;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import stateStation.States;

/**
 *
 * @author Gabriela
 */
public class Checkpoint extends MovingObject{

    public Checkpoint(BufferedImage imagen, Location posicion, Location vel, double maxVel, States gmStat) {
        super(imagen, posicion, vel, maxVel, gmStat);
    }

    @Override
    public void renovar() {
        
    }

    @Override
    public void pintar(Graphics graph) {
       
    }

    @Override
    public Location centro() {
        return new Location(posicion.getX()+imagen.getWidth()/2,posicion.getY()+imagen.getHeight()/2);
    }
    
}
