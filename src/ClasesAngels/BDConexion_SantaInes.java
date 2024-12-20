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

public class BDConexion_SantaInes {
     //public static final String URL = "jdbc:mysql://26.74.177.186:3306/angels?useTimezone=true&serverTimezone=UTC";// PARAISO
      public static final String URL = "jdbc:mysql://26.102.114.50:3306/angels?useTimezone=true&serverTimezone=UTC";//SANTA INES
    //public static final String URL = "jdbc:mysql://192.168.0.14:3306/angels?useTimezone=true&serverTimezone=UTC";
    public static final String USER = "angels";
    public static final String CLAVE = "Coast@cm";
     
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null,"LA MAQUINA NO ESTA ENCENDIDA");
        }
        return con;
    }
   
    }
    
    
    
    

