/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pedido;

import ClasesAngels.BDConexion_server;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author it
 */
public class BDIngresosConsultas {
    
    
    public static ArrayList<ClassProductos> ListarProductos(int p) {
        return OrderLuis("SELECT id_producto,descripcion,medida  FROM PRODUCTOS WHERE  ID_PRODUCTO not in(SELECT ID_PRODUCTO FROM PRODUCTOS_PEDIDO WHERE ID_PEDIDO = "+p+") order by familia,DESCRIPCION;");    
 }  

    private static ArrayList<ClassProductos> OrderLuis(String sql){
    ArrayList<ClassProductos> list = new ArrayList<>();
    BDConexion_server conecta = new BDConexion_server();
    Connection cn = conecta.getConexion();
    
        try {
            ClassProductos t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new ClassProductos();
                 t.setId_producto(rs.getInt("id_producto"));
                 t.setDescripcion(rs.getString("Descripcion"));
                 t.setUnidad(rs.getString("Medida"));
                 list.add(t);
                            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("error consulta DE LA A TABLA "+e);
            return null;
        } 
        return list;
}



public static ArrayList<ClassProductos> ListarProductosSolicitados(int p) {
        return Pro("SELECT id_producto,descripcion,medida  FROM PRODUCTOS WHERE  ID_PRODUCTO in(SELECT ID_PRODUCTO FROM PRODUCTOS_PEDIDO WHERE ID_PEDIDO = "+p+") order by familia,DESCRIPCION;");    
 }  

    private static ArrayList<ClassProductos> Pro(String sql){
    ArrayList<ClassProductos> list = new ArrayList<>();
    BDConexion_server conecta = new BDConexion_server();
    Connection cn = conecta.getConexion();
    
        try {
            ClassProductos t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new ClassProductos();
                 t.setId_producto(rs.getInt("id_producto"));
                 t.setDescripcion(rs.getString("Descripcion"));
                 t.setUnidad(rs.getString("Medida"));
                 list.add(t);
                            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("error consulta DE LA A TABLA "+e);
            return null;
        } 
        return list;
}    
    
public static ArrayList<ClassProductos> ListarProductosSolicitadosV2(int p) {
        return ProV2("SELECT pp.id_producto,p.descripcion,p.medida,COALESCE(C_SANTAINES,0) as C_SANTAINES,COALESCE(C_PUERTANE,0) as C_PUERTANE,COALESCE(C_PARAISO,0) as C_PARAISO,COALESCE(C_PALENCIA,0) as C_PALENCIA,COALESCE(C_RESIDENCIALES,0) as C_RESIDENCIALES FROM PRODUCTOS p inner join productos_pedido pp on p.ID_PRODUCTO = pp.id_producto  WHERE  pp.ID_PEDIDO = "+p+" order by familia,DESCRIPCION;");    
 }
public static ArrayList<ClassProductos> ListarProductosSolicitadosV2Re(int p) {
        return ProV2("SELECT pp.id_producto,p.descripcion,p.medida,COALESCE(R_SANTAINES,0) as C_SANTAINES,COALESCE(R_PUERTANE,0) as C_PUERTANE,COALESCE(R_PARAISO,0) as C_PARAISO,COALESCE(R_PALENCIA,0) as C_PALENCIA,COALESCE(R_RESIDENCIALES,0) as C_RESIDENCIALES FROM PRODUCTOS p inner join productos_pedido pp on p.ID_PRODUCTO = pp.id_producto  WHERE  pp.ID_PEDIDO = "+p+" order by familia,DESCRIPCION;");    
 } 

    private static ArrayList<ClassProductos> ProV2(String sql){
    ArrayList<ClassProductos> list = new ArrayList<>();
    BDConexion_server conecta = new BDConexion_server();
    Connection cn = conecta.getConexion();
    
        try {
            ClassProductos t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new ClassProductos();
                 t.setId_producto(rs.getInt("id_producto"));
                 t.setDescripcion(rs.getString("Descripcion"));
                 t.setUnidad(rs.getString("Medida"));
                 t.setCsantaines(rs.getString("C_SANTAINES"));
                 t.setCResi(rs.getString("C_RESIDENCIALES"));
                 t.setCpuertanegra(rs.getString("C_PUERTANE"));
                 t.setCparaiso(rs.getString("C_PARAISO"));
                 t.setCpalencia(rs.getString("C_PALENCIA"));
                 list.add(t);
                            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("error consulta DE LA A TABLA "+e);
            return null;
        } 
        return list;
}        
 
public static ClassProductos InsertarPedido(ClassProductos t) throws SQLException{
        BDConexion_server conecta = new BDConexion_server();
        Connection con = conecta.getConexion();
        PreparedStatement smtp = null;
        smtp =con.prepareStatement("insert into pedidos (FECHA,ESTADO) values(?,1)",Statement.RETURN_GENERATED_KEYS);
        
        try {
         smtp.setString(1,t.getFechain());   
         smtp.executeUpdate();
     } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);}
        
        ResultSet rs = smtp.getGeneratedKeys();
        if(rs.next()){int id = rs.getInt(1);
          t.setId_pedido(id);
        }
       con.close();
       smtp.close(); 
        return t;
       
    }


public static ClassProductos InsertarProductosPedido(ClassProductos t) throws SQLException{
        BDConexion_server conecta = new BDConexion_server();
        Connection con = conecta.getConexion();
        PreparedStatement smtp = null;
        smtp =con.prepareStatement("insert into productos_pedido(id_pedido,id_producto,c_santaines,c_puertane,c_paraiso,c_palencia,c_residenciales) values(?,?,0,0,0,0,0)");
        try {
         smtp.setInt(1,t.getId_pedido());
         smtp.setInt(2,t.getId_producto());
         smtp.executeUpdate();
     } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "CUAL ERROR = "+e);}
       con.close();
       smtp.close(); 
        return t;
    }


public static ClassProductos buscarProducto(int a,int b ) throws SQLException{  
        return buscarPro(a,b,null);
        
    }
    
    public static ClassProductos buscarPro(int a,int b ,ClassProductos c) throws SQLException {
             
            BDConexion_server conecta = new BDConexion_server();
            Connection cn = conecta.getConexion();
            PreparedStatement ps = null;
            ps = cn.prepareStatement("SELECT concat(p.descripcion,' - ',p.medida) as Descripcion,pp.c_santaines,pp.c_puertane,pp.c_paraiso,pp.c_palencia,pp.c_residenciales FROM productos_pedido pp inner join productos p on pp.id_producto = p.id_producto where pp.id_pedido = "+a+" and pp.id_producto = "+b+" order by p.familia,p.DESCRIPCION");
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
               if (c==null)
               {c = new ClassProductos(){};}
               c.setDescripcion(rs.getString("Descripcion"));
               c.setCsantaines(rs.getString("c_santaines"));
               c.setCpuertanegra(rs.getString("c_puertane"));
               c.setCparaiso(rs.getString("c_paraiso"));
               c.setCpalencia(rs.getString("c_palencia"));
               c.setCResi(rs.getString("c_residenciales"));
            }
            cn.close();
            ps.close();
            return c;
}
    

    public static ClassProductos buscarProductoRecibido(int a,int b ) throws SQLException{  
        return buscarProRe(a,b,null);
        
    }
    
    public static ClassProductos buscarProRe(int a,int b ,ClassProductos c) throws SQLException {
             
            BDConexion_server conecta = new BDConexion_server();
            Connection cn = conecta.getConexion();
            PreparedStatement ps = null;
            ps = cn.prepareStatement("SELECT concat(p.descripcion,' - ',p.medida) as Descripcion,pp.r_santaines,pp.r_puertane,pp.r_paraiso,pp.r_palencia,pp.r_residenciales FROM productos_pedido pp inner join productos p on pp.id_producto = p.id_producto where pp.id_pedido = "+a+" and pp.id_producto = "+b+" order by p.familia,p.DESCRIPCION");
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
               if (c==null)
               {c = new ClassProductos(){};}
               c.setDescripcion(rs.getString("Descripcion"));
               c.setCsantaines(rs.getString("r_santaines"));
               c.setCpuertanegra(rs.getString("r_puertane"));
               c.setCparaiso(rs.getString("r_paraiso"));
               c.setCpalencia(rs.getString("r_palencia"));
               c.setCResi(rs.getString("r_residenciales"));
            }
            cn.close();
            ps.close();
            return c;
}    



    
    
 public static ClassProductos ActualizarCantidad(ClassProductos t) throws SQLException{
        BDConexion_server conecta = new BDConexion_server();
        Connection con = conecta.getConexion();
        PreparedStatement smtp = null;
        smtp =con.prepareStatement("update productos_pedido set c_santaines = ?,c_puertane = ?,c_paraiso = ?,c_palencia = ?,c_residenciales = ? where id_pedido = ? and id_producto = ?");
        try {
         smtp.setString(1,t.getCsantaines());
         smtp.setString(2,t.getCpuertanegra());
         smtp.setString(3,t.getCparaiso());
         smtp.setString(4,t.getCpalencia());
         smtp.setString(5,t.getCResi());
         smtp.setInt(6,t.getId_pedido());
         smtp.setInt(7,t.getId_producto());
         smtp.executeUpdate();
     } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "CUAL ERROR = "+e);}
       con.close();
       smtp.close(); 
        return t;
    }    
 
 public static ClassProductos ActualizarCantidadRecibida(ClassProductos t) throws SQLException{
        BDConexion_server conecta = new BDConexion_server();
        Connection con = conecta.getConexion();
        PreparedStatement smtp = null;
        smtp =con.prepareStatement("update productos_pedido set r_santaines = ?,r_puertane = ?,r_paraiso = ?,r_palencia = ?,r_residenciales = ? where id_pedido = ? and id_producto = ?");
        try {
         smtp.setString(1,t.getCsantaines());
         smtp.setString(2,t.getCpuertanegra());
         smtp.setString(3,t.getCparaiso());
         smtp.setString(4,t.getCpalencia());
         smtp.setString(5,t.getCResi());
         smtp.setInt(6,t.getId_pedido());
         smtp.setInt(7,t.getId_producto());
         smtp.executeUpdate();
     } catch (SQLException e) {
       JOptionPane.showMessageDialog(null, "CUAL ERROR = "+e);}
       con.close();
       smtp.close(); 
        return t;
    }    
 
 public static ArrayList<ClassProductos> ListarPedidosImprimirRecibidos() {
        return Pedidos("SELECT ID_PEDIDO,date_format(fecha,'%d/%m/%Y') as Fecha FROM pedidosproductos.pedidos where estado = 3;");    
 } 
 public static ArrayList<ClassProductos> ListarPedidosImprimir() {
        return Pedidos("SELECT ID_PEDIDO,date_format(fecha,'%d/%m/%Y') as Fecha FROM pedidosproductos.pedidos where estado in(1,2);");    
 }  
public static ArrayList<ClassProductos> ListarPedidos() {
        return Pedidos("SELECT ID_PEDIDO,date_format(fecha,'%d/%m/%Y') as Fecha FROM pedidosproductos.pedidos where estado = 1;");    
 }
    private static ArrayList<ClassProductos> Pedidos(String sql){
    ArrayList<ClassProductos> list = new ArrayList<>();
    BDConexion_server conecta = new BDConexion_server();
    Connection cn = conecta.getConexion();
    
        try {
            ClassProductos t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new ClassProductos();
                 t.setId_pedido(rs.getInt("ID_PEDIDO"));
                 t.setFechain(rs.getString("Fecha"));
                 list.add(t);
                            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("error consulta DE LA A TABLA "+e);
            return null;
        } 
        return list;
}    
 
public static ArrayList<ClassProductos> ListarPedidosRecibido() {
        return PedidosReci("SELECT ID_PEDIDO,date_format(fecha,'%d/%m/%Y') as Fecha FROM pedidosproductos.pedidos where estado = 2;");    
 }  

    private static ArrayList<ClassProductos> PedidosReci(String sql){
    ArrayList<ClassProductos> list = new ArrayList<>();
    BDConexion_server conecta = new BDConexion_server();
    Connection cn = conecta.getConexion();
    
        try {
            ClassProductos t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new ClassProductos();
                 t.setId_pedido(rs.getInt("ID_PEDIDO"));
                 t.setFechain(rs.getString("Fecha"));
                 list.add(t);
                            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("error consulta DE LA A TABLA "+e);
            return null;
        } 
        return list;
}

 public static boolean CerrarPedido(ClassProductos t) throws SQLException{
        BDConexion_server conecta = new BDConexion_server();
        Connection cn = conecta.getConexion();
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ps2 = cn.prepareStatement("""
                                  update pedidosproductos.productos_pedido set 
                                  R_SANTAINES = C_SANTAINES,
                                  R_PUERTANE = C_PUERTANE,
                                  R_PARAISO = C_PARAISO,
                                  R_PALENCIA = C_PALENCIA,
                                  R_RESIDENCIALES = C_RESIDENCIALES WHERE  ID_PEDIDO  = ?""");
        ps2.setInt(1,t.getId_pedido());
        ps = cn.prepareStatement("UPDATE PEDIDOS SET ESTADO = 2 WHERE ID_PEDIDO = ?");
        ps.setInt(1,t.getId_pedido());    
        int rowsUpdated = ps.executeUpdate();
        ps2.executeUpdate();
        cn.close();
        ps.close();
        ps2.close();
        return rowsUpdated > 0;
    }    
 
 public static boolean CerrarPedidoRecibido(ClassProductos t) throws SQLException{
        BDConexion_server conecta = new BDConexion_server();
        Connection cn = conecta.getConexion();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("UPDATE PEDIDOS SET ESTADO = 3 WHERE ID_PEDIDO = ?");
        ps.setInt(1,t.getId_pedido());    
        int rowsUpdated = ps.executeUpdate();
        cn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }    
     
    
    
}
