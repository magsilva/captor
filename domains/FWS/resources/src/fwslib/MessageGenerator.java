package fwslib;

import fws.FWS;
import fws.MessageFormat;

/**
 * @author Kicho
 *
 */
public class MessageGenerator extends Thread  {
    
    Runner runner;
    
    public MessageGenerator(Runner runner)  {
        this.runner = runner;
    }

    //-------------------------------------------------------------------------
    
    public void run() {
        while ( true )  {
            
            if ( !runner.isRun() )
                return;
            
            try {
                Thread.sleep(FWS.TransmitPeriod);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            
            TransmitDriver.send(MessageFormat.create(Averager.get()));
            
        }
    }

}
