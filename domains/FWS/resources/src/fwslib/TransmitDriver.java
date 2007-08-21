package fwslib;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import fws.FWS;

/** 
 * @author Kicho
 *
 */
public class TransmitDriver {

    public static void send(String s) {
        
        Socket socket;
        PrintWriter out;
        
        try {
            socket = new Socket(FWS.CONTROL_TOWER_HOST, FWS.CONTROL_TOWER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            Debug.println("Sending windSpeed: " + s);
            out.println(s);
            socket.close();
        } 
        catch (IOException e) {
            System.out.println(e);
        }

    }

}
