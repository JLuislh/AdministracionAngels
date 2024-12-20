/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Palencia;

//import com.mysql.cj.xdevapi.Statement;
import Residenciales.*;
import BDclass.Productos;
import ClasesAngels.BDConexion_Palencia;
import ClasesAngels.BDConexion_Residenciales;
import ClassAngels.InsertarProducto;
import java.sql.*;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author jluis
 */
public class BDProductosPalencia {
    
    
    int a;
    
    
    public static ArrayList<Productos> ListarProductos() {

        return consultarSQL("select id_producto,descripcion,truncate(precio,2) as precio FROM PRODUCTOS where tipo = 1");
    }
    
    public static ArrayList<Productos> ListarProductosExtra() {

        return consultarSQL("select id_adicional,descripcion,truncate(precio,2) as precio FROM ADICIONAL");
    }
    

    private static ArrayList<Productos> consultarSQL(String sql) {
        ArrayList<Productos> list = new ArrayList<Productos>();
        BDConexion_Palencia conecta = new BDConexion_Palencia();
        Connection cn = conecta.getConexion();
        DecimalFormat df = new DecimalFormat("#0.00");
        
        try {
            Productos p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new Productos();
                p.setId_producto(rs.getInt("id_producto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio("Q "+df.format(rs.getString("precio")));
                //p.setPrecio(Double.parseDouble(df.format(rs.getDouble("precio"))));
                //System.out.println("precio ="+rs.getDouble("precio"));
                 //System.out.println(df.format(rs.getDouble("precio")));
                list.add(p);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
    
    
 public static InsertarProducto InsertarProducto_Pedido(InsertarProducto t) throws SQLException{
        BDConexion_Palencia conecta = new BDConexion_Palencia();
        Connection con = conecta.getConexion();
        PreparedStatement smtp = null;
        PreparedStatement sm = null;
        smtp =con.prepareStatement("insert into productos_pedido (id_pedido,id_producto,cantidad,tipo,adicional,precio,opcion) values(?,?,?,?,1,(select precio*"+t.getCantidad()+" from productos where ID_PRODUCTO =  "+t.getId_producto()+" ),1) ",Statement.RETURN_GENERATED_KEYS);
        sm = con.prepareStatement("{call Opcion1("+t.getTipo()+","+t.getId_producto()+","+t.getCantidad()+")}");
        try {
         smtp.setInt(1,t.getId_pedido());
         smtp.setInt(2,t.getId_producto());
         smtp.setInt(3, t.getCantidad());
         smtp.setInt(4, t.getTipo());
         smtp.executeUpdate();
         sm.executeUpdate();
     } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "QUE MIERDA PASA ADENTRO =  "+e);}
        
        ResultSet rs = smtp.getGeneratedKeys();
        if(rs.next()){int id1 = rs.getInt(1);
          t.setIdregreso(id1);
        }
        
       con.close();
       smtp.close(); 
       sm.close(); 
        return t;
       
    }
 
 
 public static InsertarProducto InsertarProducto_Pedido_combo(InsertarProducto t) throws SQLException{
        BDConexion_Palencia conecta = new BDConexion_Palencia();
        Connection con = conecta.getConexion();
        PreparedStatement smtp = null;
        PreparedStatement sm = null;
        smtp =con.prepareStatement("insert into productos_pedido (id_pedido,id_producto,cantidad,tipo,adicional,precio,opcion) values(?,?,?,?,1,(select precio*"+t.getCantidad()+" from PRODUCTOS where ID_PRODUCTO =  "+t.getId_producto()+" ),4)",Statement.RETURN_GENERATED_KEYS);
        sm = con.prepareStatement("{call Opcion4("+t.getCantidad()+")}");
        try {
         smtp.setInt(1,t.getId_pedido());
         smtp.setInt(2,t.getId_producto());
         smtp.setInt(3, t.getCantidad());
         smtp.setInt(4, t.getTipo());
         smtp.executeUpdate();
         sm.executeUpdate();
     } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "QUE MIERDA PASA ADENTRO =  "+e);}
        ResultSet rs = smtp.getGeneratedKeys();
        if(rs.next()){int id1 = rs.getInt(1);
          t.setIdregreso(id1);
        }
        
       con.close();
       smtp.close(); 
       sm.close(); 
        return t;
       
    }
 
 
   public static InsertarProducto InsertarProducto_Pedido_tortilla(InsertarProducto t) throws SQLException{
        BDConexion_Palencia conecta = new BDConexion_Palencia();
        Connection con = conecta.getConexion();
        PreparedStatement smtp = null;
        PreparedStatement sm = null;
        smtp =con.prepareStatement("insert into productos_pedido (id_pedido,id_producto,cantidad,tipo,adicional,precio,opcion) values(?,?,?,3,1,(select precio*"+t.getCantidad()+"  from PRODUCTOS where ID_PRODUCTO = "+t.getId_producto()+" ),2)",Statement.RETURN_GENERATED_KEYS);
        sm = con.prepareStatement("{call Opcion2("+t.getId_producto()+","+t.getCantidad()+")}");
        try {
         smtp.setInt(1,t.getId_pedido());
         smtp.setInt(2,t.getId_producto());
         smtp.setInt(3, t.getCantidad());
         smtp.executeUpdate();
         sm.executeUpdate();
     } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CUAL ERROR = "+e);}
        
        ResultSet rs = smtp.getGeneratedKeys();
        if(rs.next()){int id1 = rs.getInt(1);
          t.setIdregreso(id1);
        }
       con.close();
       smtp.close(); 
       sm.close(); 
        return t;
    }
 
 
    public static InsertarProducto InsertarPedido(InsertarProducto t) throws SQLException{
        BDConexion_Palencia conecta = new BDConexion_Palencia();
        Connection con = conecta.getConexion();
        PreparedStatement smtp = null;
        smtp =con.prepareStatement("insert into Ordenes (FECHA) values(CURRENT_TIMESTAMP)",Statement.RETURN_GENERATED_KEYS);
        try {
         smtp.executeUpdate();
     } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);}
        
        ResultSet rs = smtp.getGeneratedKeys();
        if(rs.next()){int id = rs.getInt(1);
          t.setIdregresoPedido(id);
        }
       con.close();
       smtp.close(); 
        return t;
       
    } 
    
 public static ArrayList<Productos> ListarProductosInventario() {

        return ListarInventario("SELECT codigo,DESCRIPCION,CANTIDAD FROM productos_inventario");
    }

    private static ArrayList<Productos> ListarInventario(String sql) {
        ArrayList<Productos> list = new ArrayList<Productos>();
        BDConexion_Palencia conecta = new BDConexion_Palencia();
        Connection cn = conecta.getConexion();
        try {
            Productos c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new Productos();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setCantidad(rs.getInt("cantidad"));
               

                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta producto por nombre " + e);
            return null;
        }
        return list;
    }


 public static Productos BuscarProducto (int idc) throws SQLException{
    
        return buscarDescarga(idc, null);
        
    }
    
    public static Productos buscarDescarga(int idc, Productos c) throws SQLException{
        
        BDConexion_Palencia conecta = new BDConexion_Palencia();
        Connection cn = conecta.getConexion();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("SELECT codigo,DESCRIPCION,cantidad FROM productos_inventario where codigo ="+idc);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (c == null){
             c = new Productos(){   };
        
        }
        c.setCodigo(rs.getInt("codigo"));
        c.setDescripcion(rs.getString("descripcion"));
        c.setCantidad(rs.getInt("cantidad"));
        }
        cn.close();
        ps.close();
        return c;
        
    }
    
    public static InsertarProducto InsertarProductoIngresoInventario(InsertarProducto t) throws SQLException{
        BDConexion_Palencia conecta = new BDConexion_Palencia();
        Connection con = conecta.getConexion();
        PreparedStatement smtp = null;
        smtp =con.prepareStatement("insert into ingresosproductos (idproductosinve,cantidad,estado,fecha) values(?,?,1,CURRENT_TIMESTAMP)");
        try {
         smtp.setInt(1,t.getIdregreso());
         smtp.setInt(2,t.getCantidad());
         smtp.executeUpdate();
     } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CUAL ERROR = "+e);}
       con.close();
       smtp.close(); 
        return t;
    }
    
     public static InsertarProducto InsertarProductoDescargaInventario(InsertarProducto t) throws SQLException{
        BDConexion_Palencia conecta = new BDConexion_Palencia();
        Connection con = conecta.getConexion();
        PreparedStatement smtp = null;
        smtp =con.prepareStatement("insert into productosdescargas (codigo,idproductosinve,cantidadout,unidad_medida) values(?,?,?,?)");
        try {
         smtp.setInt(1,t.getCodigo());
         smtp.setInt(2,t.getIdregreso());
         smtp.setInt(3,t.getCantidad());
         smtp.setString(4,t.getUMedida());
         smtp.executeUpdate();
     } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CUAL ERROR = "+e);}
       con.close();
       smtp.close(); 
        return t;
    }
    
     
      public static InsertarProducto InsertarGastos(InsertarProducto t) throws SQLException{
        BDConexion_Palencia conecta = new BDConexion_Palencia();
        Connection con = conecta.getConexion();
        PreparedStatement smtp = null;
        smtp =con.prepareStatement("insert into gastosdiarios(descripciongasto,precio,fecha,cantidad,factura) values(?,?,?,?,?)");
        try {
         smtp.setString(1,t.getDescripcion());
         smtp.setDouble(2,t.getPrecio());
         smtp.setString(3, t.getFecha());
         smtp.setInt(4, t.getCantidad());
         smtp.setString(5, t.getNofactura());
         
         smtp.executeUpdate();
     } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CUAL ERROR = "+e);}
       con.close();
       smtp.close(); 
        return t;
    }

}
