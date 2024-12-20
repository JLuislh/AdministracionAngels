/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesAngels;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */

public class BDConexion_server {
    
    public static final String URL = "jdbc:mysql://26.49.11.7:3306/PedidosProductos?useTimezone=true&serverTimezone=UTC";//administrador
    //public static final String URL = "jdbc:mysql://192.168.0.14:3306/PedidosProductos?useTimezone=true&serverTimezone=UTC";//PRUEBAS
    //public static final String USER =   "angels";//PRUEBAS
    public static final String USER = "PedidosProductos";//PRODUCCION
    public static final String CLAVE = "Coast@cm";
     
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null,"ERROR GRAVE CONTACTE AL ADMINISTRADOR DEL SISTEMA");
        }
        return con;
    }
   
    }
    
    
    
    

