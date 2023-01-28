/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplayerStation;

    import java.io.IOException;
    import java.net.Socket;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.util.logging.Level;
    import java.util.logging.Logger;


/**
 *
 * @author Gabriela
 */


public class Cliente {
    private Socket clntsocket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Cliente(String ip) {
        try {
            while(clntsocket==null)
                clntsocket=new Socket("192.168.0.114",4500);        //"192.168.0.114"
            oos=new ObjectOutputStream(clntsocket.getOutputStream());
            ois=new ObjectInputStream(clntsocket.getInputStream());
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void disconnect(){
        try {
            clntsocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMsg(){
    
    }
    
    public void receiveMsg(){
    
    }
    
    
}
