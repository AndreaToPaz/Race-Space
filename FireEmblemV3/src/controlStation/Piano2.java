/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlStation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Gabriela
 */
public class Piano2 implements KeyListener{
   
/**
 *
 * @author Andrea and Adrian
 * @since 24/06/2018
 * @version  1era version
 * --Control de piano (teclado)--
 * 
 */

    
    //-----------------Auxiliares----------------------
        private final static int CANTECLAS = 256;
        private final boolean [] teclas = new boolean [CANTECLAS];
    //-------------------------------------------------
    
    //-----------Variables de control del piano-------
        public static boolean arriba;
        public static boolean abajo;
        public static boolean derecha;
        public static boolean izquierda;
        public static boolean objeto;
        public static boolean shift; //Handbrake
    //-------------------------------------------------

    public Piano2() {
        arriba = false;
        abajo = false;
        derecha = false;
        izquierda = false;
        objeto = false;
        shift=false;
    }
     
        
    public void renovar(){
        arriba = teclas[KeyEvent.VK_UP];
        abajo = teclas[KeyEvent.VK_DOWN];
        izquierda = teclas[KeyEvent.VK_LEFT];
        derecha = teclas[KeyEvent.VK_RIGHT];
        objeto = teclas[KeyEvent.VK_COMMA];
        shift= teclas[KeyEvent.VK_PERIOD];
    }
    
    
    @Override
    public void keyTyped(KeyEvent ke) { 
       
    }

    @Override
    public void keyPressed(KeyEvent ke) { 
        teclas[ke.getKeyCode()] = true;
    }
    

    @Override
    public void keyReleased(KeyEvent ke) {
         teclas[ke.getKeyCode()] = false;
    }
    
}

