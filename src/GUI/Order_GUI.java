/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.OrderBUS;
import BUS.ProductBUS;
import DTO.Product;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI
 */
public class Order_GUI extends javax.swing.JFrame {

   DefaultTableModel model;
    List<DTO.Order> mhList = new ArrayList<>();
    OrderBUS bus = new OrderBUS();
    
    public Order_GUI() {
        initComponents();
        model = (DefaultTableModel) tbl_order.getModel();
        showMh();
    }
    private void showMh(){
        mhList=bus.getListV();
        model.setRowCount(0);
        mhList.forEach((tv)->{
        model.addRow(new Object[] {tv.getOrder_id(),
        tv.getOrder_date(),tv.getStatus()});
        });
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        txt_order_id = new javax.swing.JTextField();
        cbb_status = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_order = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnXoaMH = new javax.swing.JButton();
        btnThemMH = new javax.swing.JButton();
        btnSuaMH = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Order Id:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 143, -1, -1));
        getContentPane().add(txt_order_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 140, 260, 30));

        cbb_status.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        getContentPane().add(cbb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 201, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Status:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jScrollPane1.setBorder(null);

        tbl_order.setBackground(new java.awt.Color(204, 204, 255));
        tbl_order.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Order ID", "Order Date", "Status"
            }
        ));
        tbl_order.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_orderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_order);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 263, 836, 250));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quản lí hóa đơn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(285, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(280, 280, 280))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 836, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_exit_20px.png"))); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 110, 40));

        btnXoaMH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_delete_20px.png"))); // NOI18N
        btnXoaMH.setText("Xóa");
        btnXoaMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMHActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoaMH, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 110, 40));

        btnThemMH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_save_20px.png"))); // NOI18N
        btnThemMH.setText("Save");
        btnThemMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMHActionPerformed(evt);
            }
        });
        jPanel2.add(btnThemMH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 40));

        btnSuaMH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_update_20px_1.png"))); // NOI18N
        btnSuaMH.setText("Update");
        btnSuaMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMHActionPerformed(evt);
            }
        });
        jPanel2.add(btnSuaMH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 117, 400, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMHActionPerformed
        DTO.Order tv = new DTO.Order();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
                tv.setOrder_id(txt_order_id.getText());
                tv.setOrder_date(dtf.format(now));               
                tv.setStatus(Integer.parseInt(cbb_status.getSelectedItem().toString()));
                bus.them(tv);
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");
                tbl_order.setModel(model);
                showMh();
    }//GEN-LAST:event_btnThemMHActionPerformed

    private void btnSuaMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMHActionPerformed
        int i = tbl_order.getSelectedRow();
        String id=(tbl_order.getValueAt(i, 0).toString());
        DTO.Order tv = new DTO.Order();      
        tv.setStatus(Integer.parseInt(cbb_status.getSelectedItem().toString()));
        model.setValueAt(tv.getStatus(), i, 2); 
        bus.sua(tv,id);
        JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
        showMh();
    }//GEN-LAST:event_btnSuaMHActionPerformed

    private void btnXoaMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMHActionPerformed
        int i = tbl_order.getSelectedRow();
       
        DTO.Order tv = bus.dsmh.get(i);
        int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
            if(option == 0){
            bus.xoa(tv);
            if (bus.dsmh.remove(i) == null) {
            model.removeRow(i);
            }
            tbl_order.setModel(model);
                showMh();
        }
    }//GEN-LAST:event_btnXoaMHActionPerformed

    private void tbl_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_orderMouseClicked
        int Row = tbl_order.getSelectedRow();
           txt_order_id.setText(tbl_order.getModel().getValueAt(Row, 0).toString());
           cbb_status.setSelectedItem(tbl_order.getModel().getValueAt(Row, 2).toString());
    }//GEN-LAST:event_tbl_orderMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaMH;
    private javax.swing.JButton btnThemMH;
    private javax.swing.JButton btnXoaMH;
    private javax.swing.JComboBox<String> cbb_status;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_order;
    private javax.swing.JTextField txt_order_id;
    // End of variables declaration//GEN-END:variables
}
