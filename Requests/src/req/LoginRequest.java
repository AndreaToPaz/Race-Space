/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package req;
import java.io.Serializable;
/**
 *
 * @author Luces
 */
public class LoginRequest implements Serializable {
    private String user;
    private String pass;
    private String correo;
    private int okane;
    
/*----------------------------------------------------------------------------*/
    //constructores

    public LoginRequest(String user, String pass, String correo) {
        this.user = user;
        this.pass = pass;
        this.correo = correo;
        
    }

/*----------------------------------------------------------------------------*/
    //metodos set/get

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public int getOkane() {
        return okane;
    }

    public void setOkane(int okane) {
        this.okane = okane;
    }
    
    
/*----------------------------------------------------------------------------*/
    //metodos

    
    
    

}
