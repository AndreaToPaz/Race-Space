
package objectStation;

import CalculusStation.Location;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Andrea and Adrian
 
  Describe lo que todo objeto del juego necesitas
    *Representacion Grafica (BufferedImagen imagen)
    *Location en la que se encuentra
 */
public abstract class Object {
    protected BufferedImage imagen;
    protected Location posicion;
    protected ArrayList<Object> meta;
    protected ArrayList<Rectangle> arrObj=new ArrayList<>();

    public Object(BufferedImage imagen, Location posicion) {
        this.imagen = imagen;
        this.posicion = posicion;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImage(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public Location getPosicion() {
        return posicion;
    }

    public void setPosicion(Location posicion) {
        this.posicion = posicion;
    }
    
    
    
    
    public abstract void renovar();
    
    public abstract void pintar(Graphics graph);
    
    public abstract Location centro();
}
