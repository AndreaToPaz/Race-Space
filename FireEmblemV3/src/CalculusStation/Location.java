
package CalculusStation;

/**
 * @author Andrea and Adrian
 *  --Localizacion de los objetos
 *          -- Auxiliar--
 */
public class Location {
    @SuppressWarnings("FieldMayBeFinal")
    private double x;
    
    @SuppressWarnings("FieldMayBeFinal")
    private double y;
    
     public Location() {
        x = 0;
        y = 0;
    }
     
     
    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getM(){
        return Math.sqrt(x*x+y*y);
    }
    
    public Location newDirection(double ang){
        return new Location(Math.cos(ang)*getM(),Math.sin(ang)*getM());
    }
    
    //Suma dos vectores y devuelve otro vector
    
    public Location addoDesu(Location loct){            
        return new Location(x+loct.getX(),y+loct.getY());
    }
    
    public Location subboDesu(Location loct){            
        return new Location(x-loct.getX(),y-loct.getY());
    }
    
    public Location escala(double vl){
        return new Location(x*vl,y*vl);
    }
    
    public void limite(double vl){
        if(x>vl)
            x=vl;
        if(x<-vl)
            x=-vl;
        if(y>vl)
            y=vl;
        if(y<-vl)
            y=-vl;
    }
    
    public Location norm(){
        
        return new Location(x/getM(),y/getM());
    }        
    

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
    
    
}
