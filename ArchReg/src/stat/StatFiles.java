/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stat;
    import java.io.File;
    import java.io.FileOutputStream;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.io.ObjectOutputStream;
    import java.io.ObjectInputStream;
    import java.util.logging.Level;
    import java.util.logging.Logger;

/**
 *
 * @author Luces
 */

public class StatFiles {
    final String dirpath="C:\\FireEmblemSpaceRacing\\StatsData";
    private String statpath;
    
    public StatFiles() {
        File fdirpath=new File(dirpath);
        if(!fdirpath.exists())
            fdirpath.mkdirs();
    }
    
    public void statRegister(Stats stt){
        statpath=dirpath+"\\"+stt.getCharacter()+".dat";
        File sttArch=new File(statpath);
        if(!sttArch.exists()){
            try {
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(statpath));
                oos.writeObject(stt);
                oos.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StatFiles.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StatFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public Stats statRead(String charst){
        statpath=dirpath+"\\"+charst+".dat";
        File statarch=new File(statpath);
        Stats stt;
        if(statarch.exists()){           
            try {
                ObjectInputStream ois=new ObjectInputStream(new FileInputStream(statpath));
                stt=(Stats)ois.readObject();
                return stt;
            } catch (IOException |ClassNotFoundException ex) {
                Logger.getLogger(StatFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return null;
    }
    
    
}
