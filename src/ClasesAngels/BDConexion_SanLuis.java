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

public class BDConexion_SanLuis {
    
    
    
    public static final String URL = "jdbc:mysql://26.247.51.34:3306/angels?useTimezone=true&serverTimezone=UTC";//PUERTA NEGRA
    //public static final String URL = "jdbc:mysql://localhost:3306/elrey?useTimezone=true&serverTimezone=UTC";//LOCAL
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
    
    
    
    

