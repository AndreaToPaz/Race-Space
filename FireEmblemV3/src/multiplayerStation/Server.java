/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplayerStation;

import centralStation.Central;
    import static centralStation.Central.ALTO;
    import static centralStation.Central.ANCHO;
    import controlStation.Piano;
    import controlStation.Piano2;
    import graphicsStation.Graphic;
    import java.awt.Canvas;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Graphics;
    import java.awt.image.BufferStrategy;
    import java.io.IOException;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.swing.JFrame;
    import stateStation.ServerStates;
    import stateStation.States;


/**
 *
 * @author Gabriela
 */

public class Server extends JFrame implements Runnable{
 
    
//------------------------------------------------------------------------------    
        //caracteristicas del server
    
    private ServerSocket ss;
    private Socket tmpsocket;
    private int crrntids=0;    //iD´s de conexion para identificar a cada cliente.
    private ServerStates state;

//------------------------------------------------------------------------------
    //Funcionalidad del juego en server
    //------------Control de Rendimiento----------
    //---------------Auxiliares---------------
    
    private final int NANO_POR_SEG = 1000000000;   
    private final int APS = 60;   
    
    //-----------------------------------------
    
    private final double NANO_ACT = NANO_POR_SEG / APS;
    private int pAPS = APS;
    private double delta = 0;
    
    //----------------------------------------------
    
    //-------------Ventana----------------------
        public static final int ANCHO = 1200;
        public static final int ALTO = 800;
        private final  Canvas ventana;
        private Thread ejecucion;
        private boolean control = false;
    //--------------------------------------------
    
    //--------------Graficas---------------------
        private BufferStrategy bufferS;
        private Graphics grafico;
    //--------------------------------------------
    
    
    //------------Control de Estado de Juego---------
        private States estados ;
        private ServerStates estadosS;
    //-----------------------------------------------
     
    //------------Control por teclado----------------
        private Piano teclado;
        private Piano2 teclado2;
    //-----------------------------------------------
    
    
//------------------------------------------------------------------------------
        

    public Server() {
        //------------------Variables---------------------
         ventana = new Canvas();
         teclado = new Piano();
         teclado2= new Piano2();
        //-------------------------------------------------
        
        //-------------Propiedades de JFrame---------------
         setSize(ANCHO,ALTO);
         setTitle("Fire Emblem : Space Racing");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setResizable(false);
         setVisible(true);
        //--------------------------------------------------
        
        //-------------Propiedades de Canvas---------------
         ventana.setPreferredSize(new Dimension(ANCHO,ALTO));
         ventana.setMaximumSize(new Dimension(ANCHO,ALTO));
         ventana.setMinimumSize(new Dimension(ANCHO,ALTO));
         ventana.setFocusable(true);
        //--------------------------------------------------
        
        add(ventana);
        
        //----------- Variables agregadas a ventana---------
            ventana.addKeyListener(teclado);
            ventana.addKeyListener(teclado2);
        //--------------------------------------------------
        
        
        
    /*------------------------------------------------------------------------*/
        //Loop de escucha de conexiones al server
        
        
        try {
            ss=new ServerSocket(4500);
            int i=0;
            while(i!=1){
                crrntids++;
                tmpsocket=ss.accept();
                ((ServerThread)new ServerThread(tmpsocket,crrntids,state)).start();
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    /*------------------------------------------------------------------------*/
    
    }
    
    public void disconnect(){
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void renovar(){
        teclado.renovar();
        teclado2.renovar();
        estadosS.renovar();
    }
    
     public void pintar(){
        bufferS = ventana.getBufferStrategy();
        if(bufferS == null){ventana.createBufferStrategy(3); return;}
        grafico = bufferS.getDrawGraphics();
        
        //---------Pintado de Pantalla----------
            grafico.setColor(Color.black);
            grafico.fillRect(0, 0, ANCHO, ALTO);
        //---------------------------------------
        
        //------Prueba-----
            //grafico.drawImage(Graphic.nave, 500, 100, null);
        //-----------------
        
        //------------Uso estados-------
            estadosS.pintar(grafico);
        //-------------------------------
            //grafico.drawString(""+pAPS,200,200);
        
        
        grafico.dispose();
        bufferS.show();
    }
    //-----------------------------------------------------------
    public void init(){
        Graphic.initialization();
        //estados = new States();
        estadosS=new ServerStates();
    }
    
    /**
     *  Manejo
     *  Hilo
     *   --ejecucion--
     */
    @Override
    @SuppressWarnings("UnusedAssignment")
    public void run() {
        long referenciaTime = 0;
        long tiempoTranscurrido = System.nanoTime();
        
        int f =0;
        long t = 0;
        
       init();
        
        while(control == true){
            referenciaTime = System.nanoTime();
            delta +=((referenciaTime - tiempoTranscurrido)/NANO_ACT);
            t = referenciaTime - tiempoTranscurrido;
            tiempoTranscurrido = referenciaTime;
            
            
            if (delta  >=  1){
               renovar();
               pintar();
               delta--;
               f++;
               System.out.println(f);
            }
          
            /*renovar();
            pintar();*/
            
            if(t >= NANO_POR_SEG){
                pAPS = f;
                f = 0;
                t = 0;
            }
        }
        
        
       end(); 
    }
    
    public void Begin(){
        control = true;
        ejecucion = new Thread(Server.this);
        ejecucion.start();
        
    }
    
    public void end(){
        
        /**
        * MODIFICAR EXCEPCION
        */
        
        try {
            ejecucion.join();
            control = false;
        } catch (InterruptedException ex) {
            System.out.print("Error");
        }
    }
    
    
}
