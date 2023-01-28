/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

/**
 *
 * @author Luces
 */
public class User {
    private String user;
    private String pass;
    private String correo;
    private int okane;

    public User(String user, String pass, String correo,int okane) {
        this.user = user;
        this.pass = pass;
        this.correo = correo;
        this.okane=okane;
    }

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
    
    
    
}
