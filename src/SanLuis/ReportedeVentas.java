/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package SanLuis;

import ClasesAngels.BDConexion_SanLuis;
import ClassAngels.InsertarProducto;
import ClassAngels.TextAreaRenderer;
import com.sun.jdi.connect.spi.Connection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author jluis
 */
public class ReportedeVentas extends javax.swing.JPanel {
     String Fecha1;
     String Fecha2;
     int tipo;
    /**
     * Creates new form VentasPorDia
     */
    public ReportedeVentas() {
        initComponents();
        
    }
    
    private void ListarVentas(){
         DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
         Fecha1 = df.format(FechaIn.getDate());
         Fecha2 = df.format(FechaFin.getDate());
         System.out.println("DIA "+Fecha2);
        ArrayList<InsertarProducto> result = BDGastosSanLuis.ProductosVentas(Fecha1,Fecha2);
        RecargarTabla(result);  
    }
     private void RecargarTabla(ArrayList<InsertarProducto> list) {
         DecimalFormat df = new DecimalFormat("#.00");
              Object[][] datos = new Object[list.size()][5];
              int i = 0;
              for(InsertarProducto t : list)
              {
                  datos[i][0] = t.getCodigo();
                  datos[i][1] = t.getDescripcion();
                  datos[i][2] = t.getCantidad();
                  datos[i][3] = df.format(t.getPrecio());
                  datos[i][4] = df.format(t.getTotal());
                  i++;
              }    
             Ventas.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "CODIGO","DESCRIPCION","CANTIDAD","PRECIO","TOTAL"
             })
             {  
                 @Override
                 public boolean isCellEditable(int row, int column){
                 return false;

             }
             });
             Ventas.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
             TableColumn columna1 = Ventas.getColumn("CODIGO");
             columna1.setPreferredWidth(-20);
             TableColumn columna2 = Ventas.getColumn("DESCRIPCION");
             columna2.setPreferredWidth(275);
             TableColumn columna3 = Ventas.getColumn("CANTIDAD");
             columna3.setPreferredWidth(35);
             TableColumn columna4 = Ventas.getColumn("PRECIO");
             columna4.setPreferredWidth(35);
             
     }
     
     
     
     private void ListarVentasDetallado(){
        
         DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
         Fecha1 = df.format(FechaIn.getDate());
         Fecha2 = df.format(FechaFin.getDate());
     
        ArrayList<InsertarProducto> result = BDGastosSanLuis.ProductosVentasDetallado(Fecha1,Fecha2);
        RecargarTablaDetallado(result);  
    }
     private void RecargarTablaDetallado(ArrayList<InsertarProducto> list) {
         DecimalFormat df = new DecimalFormat("#.00");
              Object[][] datos = new Object[list.size()][6];
              int i = 0;
              for(InsertarProducto t : list)
              {
                  datos[i][0] = t.getCodigo();
                  datos[i][1] = t.getDescripcion();
                  datos[i][2] = t.getCantidad();
                  datos[i][3] = t.getFecha();
                  datos[i][4] = df.format(t.getPrecio());
                  datos[i][5] = df.format(t.getTotal());
                  i++;
              }    
             Ventas.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "CODIGO","DESCRIPCION","CANTIDAD","FECHA","PRECIO","TOTAL"
             })
             {  
                 @Override
                 public boolean isCellEditable(int row, int column){
                 return false;

             }
             });
             Ventas.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
             TableColumn columna1 = Ventas.getColumn("CODIGO");
             columna1.setPreferredWidth(-20);
             TableColumn columna2 = Ventas.getColumn("DESCRIPCION");
             columna2.setPreferredWidth(275);
             TableColumn columna3 = Ventas.getColumn("CANTIDAD");
             columna3.setPreferredWidth(35);
             TableColumn columna4 = Ventas.getColumn("PRECIO");
             columna4.setPreferredWidth(35);
             
     }
     
     private void imprimirventadetallado(){
            
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            Fecha1 = df.format(FechaIn.getDate());
            Fecha2 = df.format(FechaFin.getDate());
         
           BDConexion_SanLuis con= new BDConexion_SanLuis();
         java.sql.Connection conexion= con.getConexion();
            try {
                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("C:\\Reportes\\ANGELS\\VentasPorOrden.jasper");
                Map parametros = new HashMap();
                parametros.put("Fecha1", Fecha1);
                parametros.put("Fecha2", Fecha2);
                System.out.println(parametros);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parametros, conexion);
                JasperPrintManager.printReport(print, true);
            } catch (Exception e) {
                System.out.println("F" + e);
                JOptionPane.showMessageDialog(null, "ERROR EJECUTAR REPORTES =  " + e);
            }
        } 

    private void imprimirventa(){
        
            
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            Fecha1 = df.format(FechaIn.getDate());
            Fecha2 = df.format(FechaFin.getDate());
         
            BDConexion_SanLuis con= new BDConexion_SanLuis();
            java.sql.Connection conexion= con.getConexion();
            try {
                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("C:\\Reportes\\ANGELS\\VentasResumen.jasper");
                Map parametros = new HashMap();
                parametros.put("FECHA1", Fecha1);
                parametros.put("FECHA2", Fecha2);
                System.out.println(parametros);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, parametros, conexion);
                JasperPrintManager.printReport(print, true);
            } catch (Exception e) {
                System.out.println("F" + e);
                JOptionPane.showMessageDialog(null, "ERROR EJECUTAR REPORTES =  " + e);
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
        Ventas = new javax.swing.JTable();
        FechaIn = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FechaFin = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1024, 635));

        Ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Ventas);

        jButton1.setText("Consultar Resumen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("IMPRIMIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("DETALLE DE VENTAS DEL ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("AL");

        jButton3.setText("Consulta Detallado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FechaFin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(FechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       tipo = 1; //RESUMEN
      if(FechaIn.getDate() != null && FechaFin.getDate() !=null){
          ListarVentas();
        }else{        JOptionPane.showMessageDialog(null, "INGRESE UNA FECHA...");        
        }    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (FechaIn.getDate() != null) {
            if (tipo == 1) {
               imprimirventa();
            } else {
               imprimirventadetallado();
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE UNA FECHA...");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tipo = 2; //Detallado
        if(FechaIn.getDate() != null && FechaFin.getDate() !=null){
          ListarVentasDetallado();
        }else{        JOptionPane.showMessageDialog(null, "INGRESE UNA FECHA...");        
        }    
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaFin;
    private com.toedter.calendar.JDateChooser FechaIn;
    private javax.swing.JTable Ventas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
