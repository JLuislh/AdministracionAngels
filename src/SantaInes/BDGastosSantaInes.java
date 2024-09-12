/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SantaInes;

import ClasesAngels.BDConexion_SantaInes;
import ClassAngels.InsertarProducto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jluis
 */
public class BDGastosSantaInes {
     public static ArrayList<InsertarProducto>ListarCuentas () {
        return cuentas("call ListaCuentas"); 
 }  
    private static ArrayList<InsertarProducto> cuentas(String sql){
    ArrayList<InsertarProducto> list = new ArrayList<>();
    BDConexion_SantaInes conecta = new BDConexion_SantaInes();
    Connection cn = conecta.getConexion();
    
        try {
            InsertarProducto t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new InsertarProducto();
                 t.setCodigo(rs.getInt("id_cuenta"));
                 t.setDescripcion(rs.getString("DESCRIPCION").toUpperCase());
                 list.add(t);
                            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta DE LA TABLA "+e);
            return null;
        } 
        return list;
}
    
 public static ArrayList<InsertarProducto>ListarGastos( String F1, String F2) {
        return gastos("call ListaGastos('"+F1+"','"+F2+"')"); 
 }  
    private static ArrayList<InsertarProducto> gastos(String sql){
    ArrayList<InsertarProducto> list = new ArrayList<>();
        BDConexion_SantaInes conecta = new BDConexion_SantaInes();
    Connection cn = conecta.getConexion();
    
        try {
            InsertarProducto t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new InsertarProducto();
                 t.setDescripcion(rs.getString("DESCRIPCION").toUpperCase());
                 t.setPrecio(rs.getDouble("PRECIO"));
                 t.setCantidad(rs.getInt("CANTIDAD"));
                 t.setFecha(rs.getString("FECHA"));
                 t.setDescripcionCuenta(rs.getString("DESCRIPCIONCUENTA").toUpperCase());
                 list.add(t);
                            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta DE LA TABLA "+e);
            return null;
        } 
        return list;
}
    
}
