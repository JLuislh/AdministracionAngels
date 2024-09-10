/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package SantaInes;

import SanLuis.*;
import ClassAngels.InsertarProducto;
import ClassAngels.TextAreaRenderer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author jluis
 */
public class AdDescargasInventarioSantaInes extends javax.swing.JPanel {
     int idproductosinve =0;
     int codigo;
     String DescripcionProducto;
    /**
     * Creates new form AdDescargasInventario
     */
    public AdDescargasInventarioSantaInes() {
        initComponents();
        ListarProductosInventario();
        ListarInventario();
    }
    
    private void limpiar(){
    
        Descripcion.setText("");
        cantidaddescarga.setText("");
        medida.setText("");
        idproductosinve = 0;
    
    }
    
     private void ListarProductosInventario(){
     
        ArrayList<InsertarProducto> result = BDIngresosSantaInes.ListarProductosVenta();
        RecargarTabla(result);  
    }
     private void RecargarTabla(ArrayList<InsertarProducto> list) {
              Object[][] datos = new Object[list.size()][2];
              int i = 0;
              for(InsertarProducto t : list)
              {
                  datos[i][0] = t.getCodigo();
                  datos[i][1] = t.getDescripcion();
                 
                  i++;
              }    
             Producto.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "CODIGO","DESCRIPCION"
             })
             {  
                 @Override
                 public boolean isCellEditable(int row, int column){
                 return false;

             }
             });
             Producto.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
             TableColumn columna1 = Producto.getColumn("CODIGO");
             columna1.setPreferredWidth(-20);
             TableColumn columna2 = Producto.getColumn("DESCRIPCION");
             columna2.setPreferredWidth(150);
            
     }
     
     
     
     private void ListarProductosDescarga(){
        int codigo = (int) (Producto.getModel().getValueAt(Producto.getSelectedRow(), 0));
        DescripcionProducto = (String) (Producto.getModel().getValueAt(Producto.getSelectedRow(), 1));
        ArrayList<InsertarProducto> result = BDIngresosSantaInes.ListarProductosDescargasVentas(codigo);
        RecargarTablaDesc(result);  
    }
     private void RecargarTablaDesc(ArrayList<InsertarProducto> list) {
              Object[][] datos = new Object[list.size()][3];
              int i = 0;
              for(InsertarProducto t : list)
              {
                  datos[i][0] = t.getDescripcion();
                  datos[i][1] = t.getCantidad();
                  datos[i][2] = t.getUMedida();
                  i++;
              }    
             PRODESC.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "DESCRIPCION","CANTIDAD DE DESCARGA","UNIDAD MEDIDA"
             })
             {  
                 @Override
                 public boolean isCellEditable(int row, int column){
                 return false;

             }
             });
             PRODESC.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
             TableColumn columna1 = PRODESC.getColumn("DESCRIPCION");
             columna1.setPreferredWidth(125);
             TableColumn columna2 = PRODESC.getColumn("CANTIDAD DE DESCARGA");
             columna2.setPreferredWidth(25);
             TableColumn columna3 = PRODESC.getColumn("UNIDAD MEDIDA");
             columna3.setPreferredWidth(75);
     }
     
     
      private void ListarInventario(){
       // int codigo = (int) (Producto.getModel().getValueAt(Producto.getSelectedRow(), 0));
        ArrayList<InsertarProducto> result = BDIngresosSantaInes.ProductosInventario();
        RecargarTablaInven(result);  
    }
     private void RecargarTablaInven(ArrayList<InsertarProducto> list) {
              Object[][] datos = new Object[list.size()][3];
              int i = 0;
              for(InsertarProducto t : list)
              {
                  datos[i][0] = t.getId_producto();
                  datos[i][1] = t.getDescripcion();
                  datos[i][2] = t.getUMedida();
                  i++;
              }    
             PROINVE.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "ID","DESCRIPCION","UNIDAD MEDIDA"
             })
             {  
                 @Override
                 public boolean isCellEditable(int row, int column){
                 return false;

             }
             });
             PROINVE.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
             TableColumn columna1 = PROINVE.getColumn("ID");
             columna1.setPreferredWidth(0);
             TableColumn columna2 = PROINVE.getColumn("DESCRIPCION");
             columna2.setPreferredWidth(200);
             TableColumn columna3 = PROINVE.getColumn("UNIDAD MEDIDA");
             columna3.setPreferredWidth(75);
     }
     
     private void guardar(){
     
          codigo = (int) (Producto.getModel().getValueAt(Producto.getSelectedRow(), 0));
          idproductosinve = (int) (PROINVE.getModel().getValueAt(PROINVE.getSelectedRow(), 0));
     try {
            
            InsertarProducto p = new InsertarProducto();
            p.setCodigo(codigo);
            p.setIdregreso(idproductosinve);
            p.setCantidad(Integer.parseInt(cantidaddescarga.getText()));
            p.setUMedida(medida.getText());
            BDProductosSantaInes.InsertarProductoDescargaInventario(p);
            JOptionPane.showMessageDialog(null, Descripcion.getText()+" AGREGADO DESCARGAS DE "+DescripcionProducto);
            ListarProductosDescarga();
            ListarInventario();
            limpiar();
        } catch (Exception ex) {
            //Logger.getLogger(ConsultaPedidos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
     
     
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Producto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        PROINVE = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PRODESC = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cantidaddescarga = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        medida = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1025, 635));

        Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION"
            }
        ));
        Producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Producto);

        PROINVE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCION", "U MEDIDA"
            }
        ));
        PROINVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PROINVEMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(PROINVE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CANTIDADES DE DESCARGA POR VENTA");

        PRODESC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPCION", "CANTIDAD", "U MEDIDA"
            }
        ));
        jScrollPane3.setViewportView(PRODESC);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("DESCRIPCION");

        Descripcion.setEditable(false);
        Descripcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Descripcion.setForeground(new java.awt.Color(51, 51, 255));

        jLabel3.setText("CANTIDAD");

        cantidaddescarga.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cantidaddescarga.setForeground(new java.awt.Color(255, 0, 0));

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        medida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Descripcion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cantidaddescarga, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medida, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 91, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidaddescarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medida, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LISTA PRODUCTOS MENU");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LISTA DE DESCARGA POR MENU");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LISTA PRODUCTOS EN INVENTARIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void ProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductoMouseClicked
       ListarProductosDescarga();

    }//GEN-LAST:event_ProductoMouseClicked

    private void PROINVEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PROINVEMouseClicked
       idproductosinve = (int) PROINVE.getModel().getValueAt(PROINVE.getSelectedRow(), 0); 
       Descripcion.setText(String.valueOf(PROINVE.getModel().getValueAt(PROINVE.getSelectedRow(), 1))); 
       medida.setText(String.valueOf(PROINVE.getModel().getValueAt(PROINVE.getSelectedRow(), 2))); 
       cantidaddescarga.requestFocus();
    }//GEN-LAST:event_PROINVEMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(idproductosinve == 0 ){JOptionPane.showMessageDialog(null, "SELECCIONES UN PRODUCTO DE INVENTARIO");}
       else{ 
       guardar();}
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Descripcion;
    private javax.swing.JTable PRODESC;
    private javax.swing.JTable PROINVE;
    private javax.swing.JTable Producto;
    private javax.swing.JTextField cantidaddescarga;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel medida;
    // End of variables declaration//GEN-END:variables
}
