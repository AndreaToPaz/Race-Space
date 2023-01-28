
package graphicsStation;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * @author Andrea and Adrian
 * 
 *  Metodos para la lectura de
 *  imagenes
 */
public class Engine {
    
    /**
     * @param ruta
     * @return
     */
    public static BufferedImage cargador(String ruta){
    
        try {
          
            return ImageIO.read(Engine.class.getResource(ruta));
        } catch (IOException ex) {
            /**
             * MODIFICAR EXCEPCION
             */
            Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
