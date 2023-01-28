/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stat;

import java.io.Serializable;

/**
 *
 * @author Luces
 */
public class Stats implements Serializable {
    private String character;
    private int nropJugadas;
    private int nropPerdidas;
    private int nropGanadas;
    private int nropAbandonadas;

    public Stats() {
        character=new String();
        nropJugadas=0;
        nropPerdidas=0;
        nropGanadas=0;
        nropAbandonadas=0;
    }
    
/*----------------------------------------------------------------------------*/
    //metodos set/get

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
    
    public int getNropJugadas() {
        return nropJugadas;
    }

    public void setNropJugadas(int nropJugadas) {
        this.nropJugadas = nropJugadas;
    }

    public int getNropPerdidas() {
        return nropPerdidas;
    }

    public void setNropPerdidas(int nropPerdidas) {
        this.nropPerdidas = nropPerdidas;
    }

    public int getNropGanadas() {
        return nropGanadas;
    }

    public void setNropGanadas(int nropGanadas) {
        this.nropGanadas = nropGanadas;
    }

    public int getNropAbandonadas() {
        return nropAbandonadas;
    }

    public void setNropAbandonadas(int nropAbandonadas) {
        this.nropAbandonadas = nropAbandonadas;
    }
    
    
    
    
}
