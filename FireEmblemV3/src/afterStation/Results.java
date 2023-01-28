/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afterStation;

import objectStation.Nave;

/**
 *
 * @author Gabriela
 */
public class Results {
    public static Nave winner;
    public static Nave loser;
    public static boolean lifedepl=false;
    public static boolean lapfin=false;
    
    public Results() {
    
    }
    
    public void reset(){
        winner=null;
        lifedepl=false;
        lapfin=false;
    }
}
