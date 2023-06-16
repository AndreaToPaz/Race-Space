package req;

/*
 * Peticion de registro por parte del cliente hacia el servidor, forma parte del mensaje PeticionRegistro
 * El cual es enviado hacia el servidor y genera una respuesta.
 */

import java.io.Serializable;
    import java.util.Scanner;
/**
 *
 * @author Luces
 */
public class RegisterRequest implements Serializable{
    private String user;
    private String pass;
    private String correo;
    private int okane;
/*----------------------------------------------------------------------------*/
    //Constructores
    
    public RegisterRequest(String user, String pass, String correo) {
        this.user = user;
        this.pass = pass;
        this.correo = correo;
        this.okane=0;
        
    }

/*----------------------------------------------------------------------------*/
    // metodos get/set
    
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

    
    
    
    
    public void imp(){
        System.out.println(user+" "+pass+" "+correo);
    }
    
}
