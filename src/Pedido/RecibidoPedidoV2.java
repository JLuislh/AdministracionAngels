/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Pedido;

import ClasesAngels.BDConexion_server;
import ClassAngels.TextAreaRenderer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author it
 */
public class RecibidoPedidoV2 extends javax.swing.JPanel {
    String Fecha;
    int id_pedido;
    int id_producto;
    int id_productoin;
    
    /**
     * Creates new form Solicitud
     */
    public RecibidoPedidoV2() {
        initComponents();
        ListarPedidosRecibido();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Solicitado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JTextField();
        NoPedido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablePedidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setPreferredSize(new java.awt.Dimension(1420, 556));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                formAncestorRemoved(evt);
            }
        });

        Solicitado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Solicitado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SolicitadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Solicitado);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("FECHA");

        TxtFecha.setEditable(false);

        NoPedido.setEditable(false);

        jLabel1.setText("No. PEDIDO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(TxtFecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "No.", "Fecha"
            }
        ));
        TablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePedidosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablePedidos);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Next.png"))); // NOI18N
        jButton1.setText("CERAR PEDIDO ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save2.png"))); // NOI18N
        jButton2.setText("GUARDAR CANTIDADES RECIBIDAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1259, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(391, 391, 391))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    /*private void ListarProductos(){
        
        /* DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
         Fecha = df.format(Fe.getDate());*/
     
     /*   ArrayList<ClassProductos> result = BDIngresosConsultas.ListarProductos(Integer.parseInt(NoPedido.getText()));
        RecargarTablaDetallado(result);  
    }
     private void RecargarTablaDetallado(ArrayList<ClassProductos> list) {
         //DecimalFormat df = new DecimalFormat("#.00");
              Object[][] datos = new Object[list.size()][3];
              int i = 0;
              for(ClassProductos t : list)
              {
                  datos[i][0] = t.getId_producto();
                  datos[i][1] = t.getDescripcion();
                  datos[i][2] = t.getUnidad();
                  //datos[i][2] = df.format(t.getTotal());
                  i++;
              }    
             Productos.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "CODIGO","DESCRIPCION","MEDIDA"
             })
             {  
                 @Override
                 public boolean isCellEditable(int row, int column){
                 return false;

             }
             });
             Productos.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
             TableColumn columna1 = Productos.getColumn("CODIGO");
             columna1.setPreferredWidth(-20);
             TableColumn columna2 = Productos.getColumn("DESCRIPCION");
             columna2.setPreferredWidth(255);
             TableColumn columna3 = Productos.getColumn("MEDIDA");
             columna3.setPreferredWidth(55);
     }*/
     
      private void CerrarPedidoRecibido(){
     
         if(NoPedido.getText().compareTo("")!=0 && TxtFecha.getText().compareTo("")!=0){
            
          int resp=JOptionPane.showConfirmDialog(null,"PEDIDO No. = "+NoPedido.getText()+" DE FECHA = "+TxtFecha.getText()+" PASARA A HISTORIAL");
          if (JOptionPane.OK_OPTION == resp){
          
        ClassProductos m = new ClassProductos();
        try {
            
           m.setId_pedido(Integer.parseInt(NoPedido.getText()));
           BDIngresosConsultas.CerrarPedidoRecibido(m);
           NoPedido.setText("0");
           TxtFecha.setText("");
           ListarPedidosRecibido();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "MENSAJE"+e);
        }
        }
        }else{JOptionPane.showMessageDialog(null, "Ingrese Una Fecha o Seleccione Un Trabajo");}
     
     }
      private void ListarProductosSolicitados(){
  
        ArrayList<ClassProductos> result = BDIngresosConsultas.ListarProductosSolicitadosV2Re(Integer.parseInt(NoPedido.getText()));
        RecargarTabla(result);  
    }
     private void RecargarTabla(ArrayList<ClassProductos> list) {
              Object[][] datos = new Object[list.size()][8];
              int i = 0;
              for(ClassProductos t : list)
              {
                  datos[i][0] = t.getId_producto();
                  datos[i][1] = t.getDescripcion();
                  datos[i][2] = t.getUnidad();
                  datos[i][3] = t.getCsantaines();
                  datos[i][4] = t.getCResi();
                  datos[i][5] = t.getCpuertanegra();
                  datos[i][6] = t.getCparaiso();
                  datos[i][7] = t.getCpalencia();
                  i++;
              }    
             Solicitado.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "CODIGO","DESCRIPCION","MEDIDA","SANTA INES","RESIDENCIALES","SAN LUIS","PARAISO","PALENCIA"
             })
             {  
                 @Override
                 public boolean isCellEditable(int row, int column){
                 return !(column == 0) && !(column == 1) && !(column == 2);       
                 //return true;
             }
             });
             Solicitado.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
             TableColumn columna1 = Solicitado.getColumn("CODIGO");
             columna1.setPreferredWidth(-20);
             TableColumn columna2 = Solicitado.getColumn("DESCRIPCION");
             columna2.setPreferredWidth(100);
             TableColumn columna3 = Solicitado.getColumn("MEDIDA");
             columna3.setPreferredWidth(0);
             TableColumn columna4 = Solicitado.getColumn("SANTA INES");
             columna4.setPreferredWidth(0);
             TableColumn columna5 = Solicitado.getColumn("RESIDENCIALES");
             columna5.setPreferredWidth(0);
             TableColumn columna6 = Solicitado.getColumn("SAN LUIS");
             columna6.setPreferredWidth(0);
             TableColumn columna7 = Solicitado.getColumn("PARAISO");
             columna7.setPreferredWidth(0);
             TableColumn columna8 = Solicitado.getColumn("PALENCIA");
             columna8.setPreferredWidth(0);
     }
    
    
     public void insertarProducto(){
         
     try {
            ClassProductos p = new ClassProductos();
            p.setId_pedido(Integer.parseInt(NoPedido.getText()));
            p.setId_producto(id_producto);
            BDIngresosConsultas.InsertarProductosPedido(p);
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
     
    /*  private void Buscarinformacion() {
       try {
           
            id_pedido = Integer.parseInt(NoPedido.getText());
            ClassProductos c = BDIngresosConsultas.buscarProducto(id_pedido,id_productoin);
            Descripcion.setText(c.getDescripcion());
            cantidad1.setText(String.valueOf(c.getCsantaines()));
            cantidad2.setText(String.valueOf(c.getCpuertanegra()));
            cantidad3.setText(String.valueOf(c.getCparaiso()));
            cantidad4.setText(String.valueOf(c.getCpalencia()));
            cantidad5.setText(String.valueOf(c.getCResi()));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error"+e);
        }
    }*/
      
   /* private void actualizarCantidad(){
     try {
            ClassProductos p = new ClassProductos();
            p.setId_pedido(Integer.parseInt(NoPedido.getText()));
            p.setId_producto(id_productoin);
            p.setCsantaines(cantidad1.getText());
            p.setCpuertanegra(cantidad2.getText());
            p.setCparaiso(cantidad3.getText());
            p.setCpalencia(cantidad4.getText());
            p.setCResi(cantidad5.getText());
            BDIngresosConsultas.ActualizarCantidad(p);
            JOptionPane.showMessageDialog(null, "Cantidad Actualizadas");
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     
    }*/
    
   /* private void actualizarCantidadRecibida(){
     try {
            ClassProductos p = new ClassProductos();
            p.setId_pedido(Integer.parseInt(NoPedido.getText()));
            p.setId_producto(id_productoin);
            p.setCsantaines(cantidad1.getText());
            p.setCpuertanegra(cantidad2.getText());
            p.setCparaiso(cantidad3.getText());
            p.setCpalencia(cantidad4.getText());
            p.setCResi(cantidad5.getText());
            BDIngresosConsultas.ActualizarCantidadRecibida(p);
            JOptionPane.showMessageDialog(null, "Cantidad Actualizadas");
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     
    }*/
    
    private void ListarPedidosRecibido(){
  
        ArrayList<ClassProductos> result = BDIngresosConsultas.ListarPedidosRecibido();
        RecargarTablaPedidos(result);  
    }
     private void RecargarTablaPedidos(ArrayList<ClassProductos> list) {
              Object[][] datos = new Object[list.size()][2];
              int i = 0;
              for(ClassProductos t : list)
              {
                  datos[i][0] = t.getId_pedido();
                  datos[i][1] = t.getFechain();
                  i++;
              }    
             TablePedidos.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "No.","FECHA"
             })
             {  
                 @Override
                 public boolean isCellEditable(int row, int column){
                 return false;
             }
             });
             TablePedidos.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
             TableColumn columna1 = TablePedidos.getColumn("No.");
             columna1.setPreferredWidth(-20);
             TableColumn columna2 = TablePedidos.getColumn("FECHA");
             columna2.setPreferredWidth(255);
           
     }
     
     private void ActualizartablaProductosResibidos() throws SQLException {
        if (Solicitado.getRowCount() > 0) {
            BDConexion_server conecta = new BDConexion_server();
                try (Connection cn = conecta.getConexion()) {
                    PreparedStatement ps;
            for (int i = 0; i < Solicitado.getRowCount(); i++) {
                    //ps = null;  "CODIGO = 0","DESCRIPCION = 1","MEDIDA = 2","SANTA INES = 3","RESIDENCIALES = 4","SAN LUIS = 5","PARAISO = 6","PALENCIA = 7"
                    ps = cn.prepareStatement("update productos_pedido SET R_SANTAINES = " + Solicitado.getValueAt(i, 3) + ",R_RESIDENCIALES = " + Solicitado.getValueAt(i, 4) + ",R_PUERTANE = " + Solicitado.getValueAt(i, 5) + ",R_PARAISO = " + Solicitado.getValueAt(i, 6) + ",R_PALENCIA = " + Solicitado.getValueAt(i, 7) + " WHERE ID_PEDIDO = " + NoPedido.getText() + " AND ID_PRODUCTO = " + Solicitado.getValueAt(i, 0));
                    ps.executeUpdate();
                    ps.close();
                    }
             
                    
            }
        } else {
            JOptionPane.showMessageDialog(this, "La lista esta Vacia");
        }
    }
     
    /* private void Limpiar(){
     
         Descripcion.setText("");
         cantidad1.setText("");
         cantidad2.setText("");
         cantidad3.setText("");
         cantidad4.setText("");
         cantidad5.setText("");
     
     }*/
    
    private void SolicitadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SolicitadoMouseClicked
        
    }//GEN-LAST:event_SolicitadoMouseClicked

    private void TablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePedidosMouseClicked
        NoPedido.setText((String.valueOf(TablePedidos.getModel().getValueAt(TablePedidos.getSelectedRow(), 0))));
        TxtFecha.setText((String.valueOf(TablePedidos.getModel().getValueAt(TablePedidos.getSelectedRow(), 1))));
        //if(Solicitado.getRowCount() > 0){try {ActualizartablaProductosResibidos();} catch (SQLException ex) {System.out.println("ERROR "+ex);}}
        ListarProductosSolicitados();
    }//GEN-LAST:event_TablePedidosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        CerrarPedidoRecibido();
        ListarProductosSolicitados();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try {
            ActualizartablaProductosResibidos();
            JOptionPane.showMessageDialog(null, "CANTIDADES ACTUALIZADAS...");
            ListarProductosSolicitados();
        } catch (SQLException ex) {
            System.out.println("EROR "+ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorRemoved
      /*  try {ActualizartablaProductosResibidos();} catch (SQLException ex) {System.out.println("ERROR "+ex);
        }*/
    }//GEN-LAST:event_formAncestorRemoved
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NoPedido;
    private javax.swing.JTable Solicitado;
    private javax.swing.JTable TablePedidos;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
