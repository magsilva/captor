package fwslib.driver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import fws.FWS;

/**
 * @author Kicho
 *
 */
public class WindReader {

    public static int read() {
        Socket socket;
        PrintWriter out;
        WindListener wl;
        WindValue wv = new WindValue();
        
        try {
            socket = new Socket(FWS.WIND_GENERATOR_HOST, FWS.WIND_GENERATOR_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            wl = new WindListener(socket, wv);
            wl.start();
        }
        catch (IOException e) {
            System.out.println(e);
            return -1;
        }

        out.println("windSpeed");
    
        int cont = 0;
        while ( !wv.isRead() )  {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e2) {
                System.out.println(e2);
            }
            cont++;
            
            if ( cont > 500 )
                return -1;
        }
        
        try {
            Integer i = new Integer(wv.getValue());
            return i.intValue();
        } catch (NumberFormatException e1) {
            System.out.println(e1);
        }
        
        return -1;
    }

}
