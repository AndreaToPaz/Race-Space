/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg;
    
    import java.io.File;
    import req.*;   
    import java.io.FileOutputStream;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.io.Serializable;


/**
 *
 * @author Luces
 */
public class NewRegister implements Serializable {
    final String rgdatPath="C:\\FireEmblemSpaceRacing\\RegisterData";
    String regarPath;

    public NewRegister() {
        File folder= new File(rgdatPath);
        if(!folder.exists())
            folder.mkdirs();
    }
    
     
    
    public void register(RegisterRequest rr)throws RegisterException{
        regarPath=rgdatPath+"\\"+rr.getUser()+".dat";
        File archivoReg=new File(regarPath);
        if(!archivoReg.exists()){
            try {
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(archivoReg));
                oos.writeObject(rr);
                oos.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(NewRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            if(archivoReg.exists()){
            try {
                ObjectInputStream ois=new ObjectInputStream(new FileInputStream(archivoReg));
                RegisterRequest r1=(RegisterRequest)ois.readObject();
                if(((r1.getUser()).equals(rr.getUser()))&&((r1.getPass()).equals(rr.getPass())))
                    throw new RegisterException("Usuario ya registrado");
                else
                    if((r1.getUser()).equals(rr.getUser()))
                        throw new RegisterException("Username en uso");
                    else
                        if((r1.getPass()).equals(rr.getPass()))
                            throw new RegisterException("Clave no disponible");
                                    
            } catch (FileNotFoundException|ClassNotFoundException ex) {
                Logger.getLogger(NewRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(NewRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
         
}
