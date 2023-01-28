/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplayerStation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import stateStation.ServerStates;

/**
 *
 * @author Gabriela
 */


public class ServerThread extends Thread {
    private Socket clnt;
    private int clntId;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private ServerStates state;

    public ServerThread(Socket clnt, int clntId,ServerStates state) {
        try {
            System.out.println("conectado");
            this.clnt = clnt;
            this.clntId = clntId;
            this.state=state;
            
            //inicializar entradas y salidas de objetos
            while(oos==null)
                oos=new ObjectOutputStream(clnt.getOutputStream());
            while(ois==null)
                ois=new ObjectInputStream(clnt.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    private void disconnect(){
        try {
            clnt.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void run() {
        while(true){
            
        }
    }
    
}
