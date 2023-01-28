
package graphicsStation;

import java.awt.image.BufferedImage;

/**
 *
 * @author Andrea and Adrian
 * Metodos para la inicializacion
 * 
 */
public class Graphic {
    public static BufferedImage[] nave=new BufferedImage[8];
    public static BufferedImage[] pista=new BufferedImage[2];
    public static BufferedImage laser;
    public static BufferedImage[] cajas=new BufferedImage[3];
    public static BufferedImage meta;
    public static BufferedImage[]nums=new BufferedImage[11];
    public static BufferedImage[]lives=new BufferedImage[2];
    public static BufferedImage heals;
    
    public static void initialization(){
        
        for(int i=0;i<8;i++){
            
            String path="/Utilidades/Naves/nave"+(i+1)+".png";
            nave[i] = Engine.cargador(path);                        
        }
        
        for(int i=0;i<2;i++){
            String path="/Utilidades/Box/box"+(i+1)+".png";
            String path2="/Utilidades/Pistas/pista"+(i+1)+".png";
            String path3="/Utilidades/Life/life"+(i+1)+".png";
            cajas[i]=Engine.cargador(path);
            pista[i]=Engine.cargador(path2);
            lives[i]=Engine.cargador(path3);
        }
        
        for(int i=0;i<11;i++){
            String path="/Utilidades/Num/numeral"+(i)+".png";
            nums[i]=Engine.cargador(path);
        }
            
        meta=Engine.cargador("/Utilidades/Pistas/meta1.png");
        heals=Engine.cargador("/Utilidades/Box/box3.png");
        laser=Engine.cargador("/Utilidades/Consumable/laserBlue01.png");
    }
    
    
}
