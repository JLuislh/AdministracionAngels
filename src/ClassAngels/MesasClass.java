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
public class MesasClass {
    
    
    private String mesa;
    private int estado;
    private int Orden;

    public int getOrden() {
        return Orden;
    }

    public void setOrden(int Orden) {
        this.Orden = Orden;
    }
    
    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    public static ArrayList<MesasClass> ListaMesas () {
        return SQLP("SELECT nomesa,m.estado,o.NOORDEN FROM mesas m inner join ordenes o on m.ID_MESA = o.ID_MESA WHERE m.ESTADO = 2 and o.estado = 1 order by m.ID_MESA;");    
 }  

private static ArrayList<MesasClass> SQLP(String sql){
    ArrayList<MesasClass> list = new ArrayList<MesasClass>();
    BDConexion conecta = new BDConexion();
    Connection cn = conecta.getConexion();
    
        try {
            MesasClass t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new MesasClass();
                 t.setMesa(rs.getString("nomesa"));
                 t.setEstado(rs.getInt("estado"));
                 t.setOrden(rs.getInt("noorden"));
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
