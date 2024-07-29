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
 * @author Jorge Lopez
 */
public class EtiquetasClass {
    private String Descripcion1;
    private String Descripcion2;
    private String precio;
    private int codigo;

    public String getDescripcion1() {
        return Descripcion1;
    }

    public void setDescripcion1(String Descripcion1) {
        this.Descripcion1 = Descripcion1;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public static ArrayList<EtiquetasClass> ListaEtiquetasCaldos() {
        return SQLP("SELECT codigo,DESCRIPCION1,DESCRIPCION2,precio FROM productos where tipo = 1 order by codigo");    
 }  
    public static ArrayList<EtiquetasClass> ListaEtiquetasHambuerguesas() {
        return SQLP("SELECT codigo,DESCRIPCION1,DESCRIPCION2,precio FROM productos where tipo = 2 order by codigo");    
 }  
     public static ArrayList<EtiquetasClass> ListaEtiquetasCeviches() {
        return SQLP("SELECT codigo,DESCRIPCION1,DESCRIPCION2,precio FROM productos where tipo = 3 order by codigo");    
 }  
      public static ArrayList<EtiquetasClass> ListaEtiquetasBebidas() {
        return SQLP("SELECT codigo,DESCRIPCION1,DESCRIPCION2,precio FROM productos where tipo = 4 order by codigo");    
 }  

  public static ArrayList<EtiquetasClass> ListaEtiquetasBebidasAlcohol() {
        return SQLP("SELECT codigo,DESCRIPCION1,DESCRIPCION2,precio FROM productos where tipo = 5 order by codigo");    
 }  
  public static ArrayList<EtiquetasClass> ListaEtiquetasBotellas() {
        return SQLP("SELECT codigo,DESCRIPCION1,DESCRIPCION2,precio FROM productos where tipo = 6 order by codigo");    
 }  
 public static ArrayList<EtiquetasClass> ListaEtiquetasExtras() {
        return SQLP("SELECT codigo,DESCRIPCION1,DESCRIPCION2,precio FROM productos where tipo = 7 order by codigo");    
 }  
private static ArrayList<EtiquetasClass> SQLP(String sql){
    ArrayList<EtiquetasClass> list = new ArrayList<EtiquetasClass>();
    BDConexion conecta = new BDConexion();
    Connection cn = conecta.getConexion();
    
        try {
            EtiquetasClass t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new EtiquetasClass();
                 t.setDescripcion1(rs.getString("DESCRIPCION1"));
                 t.setDescripcion2(rs.getString("DESCRIPCION2"));
                 t.setCodigo(rs.getInt("codigo"));
                 t.setPrecio(rs.getString("precio"));
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
