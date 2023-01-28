/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectStation;
    
import centralStation.Central;
import centralStation.Game;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriela
 */
public class Picks {
    public static int np1=0;
    public static int np2=0;
    public static int pp1=0;
    public static boolean picked1=false;
    public static boolean picked2=false;
    public static boolean pickedp=false;
    
    public void reset(){
        np1=0;
        np2=0;
        pp1=0;
        picked1=false;
        picked2=false;
        pickedp=false;
    }
    
    
    
}
