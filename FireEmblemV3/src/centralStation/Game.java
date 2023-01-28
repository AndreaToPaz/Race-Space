
package centralStation;

import multiplayerStation.Server;
import registrationStation.Login;
import statisticsStation.StatModule;
import registrationStation.Registration;
import registrationStation.Registro;


 /**
 * @author Andrea and Adrian
 * @since 23/06/2018
 * @version 1era version
 * 
 */
public class Game {
    public static Central mnCentral;
    public static void main(String[] args) {
        new Registration();
        new StatModule();
        Login lfr=new Login();
        lfr.setVisible(Login.finishedlog);
        
        /*while(Login.finishedlog);
            lfr.setVisible(Login.finishedlog);*/
        
        //new Server().Begin();
        
    }
    
}
