package fwslib.driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import fwslib.Debug;


/**
 * @author Kicho
 *
 */
public class WindListener extends Thread {

    Socket socket;
    WindValue wv;
    
    public WindListener(Socket socket, WindValue wv) {
        this.socket = socket;
        this.wv = wv;
    }

    //-------------------------------------------------------------------------
    
    public void run()  {
        BufferedReader in;
        
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch(Exception e)  {
            System.out.println(e);
            wv.setValue("-1");
            wv.setRead(true);
            return;
        }

        try  {
            String inputLine = in.readLine();
            Debug.println("Reading windSpeed: " + inputLine);
            
            wv.setValue(inputLine);
            wv.setRead(true);
        }
        catch(Exception e)  {
            System.out.println(e);
            wv.setValue("-1");
            wv.setRead(true);
            return;
        }
    }
    
    //-------------------------------------------------------------------------
}
