
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jose Luis Castañeda
 */
public class Conexion {

    String DB;
    String url="jdbc:mysql://localhost:3306/";
    String user ="root";
    String password="root";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conexion(String DB)
    {
        this.DB=DB;
    }

    public Connection Conectar() throws SQLException, ClassNotFoundException
    {
        try {
                Class.forName(driver);
                //Cadena de Conexion
                cx = DriverManager.getConnection(url+DB, user, password);
                System.out.println("Se conecto a la DB: "+ DB);    
            } catch (ClassNotFoundException |SQLException ex){
                System.out.println("No se conecto a la DB: "+ DB); 
                //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
            }
        return cx;
    }

    public void Desconectar()
    {
        try
        {
            System.out.println("Se desconecto a la DB: "+ DB);
            cx.close();
        }catch(SQLException ex){
            System.out.println("No se desconecto a la DB: "+ DB); 
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
        }
    }



    
}
