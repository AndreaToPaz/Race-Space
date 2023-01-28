
package controlStation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Andrea and Adrian
 * @since 24/06/2018
 * @version  1era version
 * --Control de piano (teclado)--
 * 
 */
public class Piano implements KeyListener{
    
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

    public Piano() {
        arriba = false;
        abajo = false;
        derecha = false;
        izquierda = false;
        objeto = false;
        shift=false;
    }
     
        
    public void renovar(){
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        izquierda = teclas[KeyEvent.VK_A];
        derecha = teclas[KeyEvent.VK_D];
        objeto = teclas[KeyEvent.VK_E];
        shift= teclas[KeyEvent.VK_SHIFT];
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
    

