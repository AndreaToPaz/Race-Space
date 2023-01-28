/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package log;
    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.io.ObjectInputStream;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import req.*;
/**
 *
 * @author Luces
 */
public class NewLogin {
    
    final String dirpath="C:\\FireEmblemSpaceRacing\\RegisterData";
    String arpath;
    
    public NewLogin() {
    }
    
    public User login(LoginRequest lr)throws LoginException{
        ObjectInputStream ois=null;
        try {
            arpath=dirpath+"\\"+lr.getUser()+".dat";
            File archivoReg=new File(arpath);
            if(archivoReg.exists()){
                ois = new ObjectInputStream(new FileInputStream(archivoReg));
                RegisterRequest rr=(RegisterRequest)ois.readObject();
                if((rr.getUser()).equals(lr.getUser())&&((rr.getPass()).equals(lr.getPass()))){
                    User us=new User(rr.getUser(),rr.getPass(),rr.getCorreo(),rr.getOkane());
                    return us;
                }else
                    if(!((rr.getUser()).equals(lr.getUser())))
                        throw new LoginException("Usuario Incorrecto");
                    else
                        if(!((rr.getPass()).equals(lr.getPass())))
                            throw new LoginException("Pass Incorrecto");
            }else
                throw new LoginException("No se encuentra registrado");
                                    
        } catch (FileNotFoundException  ex) {
            Logger.getLogger(NewLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException|ClassNotFoundException ex) {
            Logger.getLogger(NewLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(NewLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
