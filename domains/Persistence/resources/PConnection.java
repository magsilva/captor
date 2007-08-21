/*
 *
 */
package lib;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PConnection {
    
    Connection con;
    
    String propertiesPath;
    
    String user = "";
    String pass = "";
    String host = "";
    
    public PConnection(String propertiesPath) {
        this.propertiesPath = propertiesPath;
        loadDBData();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception ex) {
                System.out.println(ex);
                System.exit(0);
            }       
            
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + "?user=" + user + "&password=" + pass);
            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                System.exit(0);
            }
    }

    public Statement createStatement() throws Exception {
        try {
            Statement stmt = con.createStatement();
            return stmt;
        } catch (SQLException e) {
            throw new Exception(e.toString());
        }
        
    }
    
    public ResultSet executeQuery(String query) throws Exception  {
        
        try {
            ResultSet rs = executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw new Exception(e.toString());
        }
        
    } 
    
    private void loadDBData()  {
        try  {
            
            File f = new File(".");
            System.out.println(f.getAbsolutePath());
            String path = propertiesPath + "/db.properties";
            File file = new File(path);
            if ( !file.exists() )  {
                System.out.println("Cannot find db.properties!");
                System.exit(0);
            }

            Properties defaultProps = new Properties();
            FileInputStream in = new FileInputStream(path);
            defaultProps.load(in);
            in.close();        
            
            user = defaultProps.getProperty("user");
            pass = defaultProps.getProperty("pass");
            host = defaultProps.getProperty("host");
        }
        catch(Exception e)  {
            System.out.println("Cannot open properties files.<br>Check if the files  db.properties exists.");
            return;
        }
    }
}
