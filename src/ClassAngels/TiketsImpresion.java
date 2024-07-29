/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassAngels;

import BDclass.BDConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jluis
 */






public class TiketsImpresion {
    
    
    
    private String cantidad;
    private String Descripcion2;
    private String precio;
    private String total;

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion2() {
        return Descripcion2;
    }

    public void setDescripcion2(String Descripcion2) {
        this.Descripcion2 = Descripcion2;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    

      public static ArrayList<TiketsImpresion> ListaProductosTIket() {
        return SQLP("SELECT cantidad,concat(p.DESCRIPCION1 ,' ', p.DESCRIPCION2) as Descripcion,precio,precio*CANTIDAD as total FROM ventas v inner join productos p on v.CODIGO = p.CODIGO where NOORDEN = 76");    
 }  
private static ArrayList<TiketsImpresion> SQLP(String sql){
    ArrayList<TiketsImpresion> list = new ArrayList<TiketsImpresion>();
    BDConexion conecta = new BDConexion();
    Connection cn = conecta.getConexion();
    
        try {
            TiketsImpresion t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new TiketsImpresion();
                 t.setCantidad(rs.getString("cantidad"));
                 t.setDescripcion2(rs.getString("Descripcion"));
                 t.setPrecio(rs.getString("precio"));
                 t.setTotal(rs.getString("total"));
                 list.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta DE LA ATABLA "+e);
            return null;
        } 
        return list;
} 
    
    
    
}
