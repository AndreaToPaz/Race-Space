/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlStation;

import log.User;
import objectStation.Nave;

/**
 *
 * @author Gabriela
 */
public class Player {
    public static Player crrntPlayer;
    public  User usr;
    private Nave ship;
    private int objectheld;

    public Player(Nave ship, int objectheld) {
        this.ship = ship;
        this.objectheld = objectheld;
    }

    public Player() {
        
    }
    
    

    public User getUsr() {
        return usr;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }

    public Nave getShip() {
        return ship;
    }

    public void setShip(Nave ship) {
        this.ship = ship;
    }

    public int getObjectheld() {
        return objectheld;
    }

    public void setObjectheld(int objectheld) {
        this.objectheld = objectheld;
    }
    
    
    
    
}
