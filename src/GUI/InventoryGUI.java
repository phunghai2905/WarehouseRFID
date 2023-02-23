/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.OrderBUS;
import BUS.OrderdetailBUS;
import BUS.ProductBUS;
import BUS.Tag_BUS;
import DTO.Orderdetail;
import DTO.Order;
import DTO.Product;
import DTO.RFID;
import DTO.Test;
import static GUI.TagRFID.listScan;
import static GUI.TagRFID.model;
import TagReportListenerImplementation.MyTagReportListener1;
import com.example.sdksamples.SampleProperties;
import com.example.sdksamples.TagReportListenerImplementation;
import com.formdev.flatlaf.FlatLightLaf;
import com.impinj.octane.AntennaConfigGroup;
import com.impinj.octane.ImpinjReader;
import com.impinj.octane.OctaneSdkException;
import com.impinj.octane.ReaderMode;
import com.impinj.octane.ReportConfig;
import com.impinj.octane.ReportMode;
import com.impinj.octane.Settings;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.openide.util.Exceptions;

/**
 *
 * @author MSI
 */
public class InventoryGUI extends javax.swing.JFrame {

    public static DefaultTableModel model, model1, model2;
    List<Orderdetail> dList = new ArrayList<>();
    OrderdetailBUS bus = new OrderdetailBUS();
    Set<RFID> list_rfid;
    Tag_BUS tagBUS = new Tag_BUS();
    TagRFID tagrfid = new TagRFID();
    Set<String> tempList = new HashSet<>();
    OrderBUS bus1 = new OrderBUS();
    public static Map<String, Integer> map;
    public static Map<String, RFID> map1 = new HashMap<>();
    public static Map<String, RFID> map2 = new HashMap<>();

    public InventoryGUI() {
        initComponents();
        model = (DefaultTableModel) tbl_orderdetail.getModel();
        model1 = (DefaultTableModel) tbl_scan.getModel();
        model2 = (DefaultTableModel) tbl_count.getModel();
        showD();
        //showResult();
        //showProduct();
        getCb_Box_Order();
        //getCb_Box_Product();

    }

    private void showD() {
        dList = bus.getListV();
        model.setRowCount(0);
        dList.forEach((tv) -> {
            model.addRow(new Object[]{tv.getOrder_id(), tv.getProduct_id(), tv.getQuanity()});
        });

    }

    public void getCb_Box_Order() {

        List<Order> listcbb = new ArrayList<>();
        listcbb = bus.fill_cbb_order();
        for (Order item : listcbb) {
            cbb_order_id.addItem(item.getOrder_id());
        }

    }

    private void showProduct() {
        model2.setRowCount(0);
        map = new HashMap<>();
        for (RFID ls : MyTagReportListener1.scan) {
            map2.put(ls.getTagID(), new RFID(ls.getDate(), ls.getGate()));
        }
        for (Map.Entry<String, RFID> entry : map2.entrySet()) {
            String k = entry.getKey();

            //System.out.println("KQ: "+k);
            String element = tagBUS.query_product_id(k);
            System.out.println(element);

            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }

        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
            System.out.println(k + " + " + v);
            model2.addRow(new Object[]{k, v});
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_orderdetail = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_scan = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_count = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_refresh = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbb_order_id = new javax.swing.JComboBox<>();
        btnCheck = new javax.swing.JButton();
        btn_new_order = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        tbl_orderdetail.setBackground(new java.awt.Color(153, 204, 255));
        tbl_orderdetail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_orderdetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Order ID", "Product ID", "Quanity"
            }
        ));
        tbl_orderdetail.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_orderdetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_orderdetailMouseClicked(evt);
            }
        });
        tbl_orderdetail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_orderdetailKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_orderdetail);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 280, 527, 300));

        jScrollPane2.setBorder(null);

        tbl_scan.setBackground(new java.awt.Color(153, 153, 255));
        tbl_scan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_scan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Date", "Gate"
            }
        ));
        tbl_scan.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tbl_scan);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 280, 488, 300));

        jScrollPane3.setBorder(null);

        tbl_count.setBackground(new java.awt.Color(0, 204, 102));
        tbl_count.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl_count.setForeground(new java.awt.Color(255, 255, 255));
        tbl_count.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_ID", "QTY"
            }
        ));
        tbl_count.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tbl_count);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 118, 488, 124));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Số lượng theo loại");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 95, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Scan Tag");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 257, 147, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nhập kho");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(450, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1044, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_refresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_refresh_20px.png"))); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        jPanel2.add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 140, 50));

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_save_20px.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 120, 50));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_exit_20px.png"))); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 120, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Order ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        cbb_order_id.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbb_order_id.setForeground(new java.awt.Color(51, 51, 51));
        cbb_order_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_order_idItemStateChanged(evt);
            }
        });
        cbb_order_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbb_order_idMouseClicked(evt);
            }
        });
        cbb_order_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_order_idActionPerformed(evt);
            }
        });
        jPanel2.add(cbb_order_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 204, -1));

        btnCheck.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_check_30px.png"))); // NOI18N
        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });
        jPanel2.add(btnCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 120, 50));

        btn_new_order.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_new_order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_add_30px.png"))); // NOI18N
        btn_new_order.setText("Order");
        btn_new_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_new_orderActionPerformed(evt);
            }
        });
        jPanel2.add(btn_new_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_sync_20px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 84, 540, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Orderdetail tv = new Orderdetail();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
            tv.setOrder_id(cbb_order_id.getSelectedItem().toString());
            tv.setProduct_id(k);
            tv.setQuanity(v);
            bus.them(tv);
            //tagBUS.updateTag(tv.getProduct_id(), cbb_order_id.getSelectedItem().toString());
            bus.updateWarehouse(tv.getProduct_id(), tv.getQuanity());

        }
        bus1.updateStatus(cbb_order_id.getSelectedItem().toString());
        JOptionPane.showMessageDialog(rootPane, "Đã thêm");
        tbl_orderdetail.setModel(model);
        showD();
        for (Map.Entry<String, RFID> entry : map1.entrySet()) {
            String k = entry.getKey();
            tagBUS.updateTag(k, cbb_order_id.getSelectedItem().toString());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tbl_orderdetailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_orderdetailKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_orderdetailKeyPressed

    private void tbl_orderdetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_orderdetailMouseClicked

    }//GEN-LAST:event_tbl_orderdetailMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        model1.setRowCount(0);
        model2.setRowCount(0);
        map1 = new HashMap<>();
        map = new HashMap<>();

    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        List<Test> products = new ArrayList<>();
        products = bus.getListProductID(cbb_order_id.getSelectedItem().toString());
        int count = 0;
        int size = products.size();
        if (bus1.getStatusOrder(cbb_order_id.getSelectedItem().toString()) == 3) {
            System.out.println("Hóa đơn này đã hoàn thành!!!");
        } else {
            for (Test t : products) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    String k = entry.getKey();
                    int v = entry.getValue();
                    //System.out.println("Map: "+k + ": " + v);
                    if (k.equals(t.getProduct_id())) {
                        if (v == Integer.parseInt(t.getQty())) {
                            JOptionPane.showMessageDialog(null, "Product ID " + t.getProduct_id() + " Đã đủ số lượng trong hóa đơn!!!");
                            //System.out.println("Product ID "+t.getProduct_id()+" Đã đủ số lượng trong hóa đơn!!!");
                            count++;
                            if (count == size) {
                                System.out.println("Set status thanh cong");
                                bus1.updateStatus(cbb_order_id.getSelectedItem().toString());
                            }
                        } else if (v < Integer.parseInt(t.getQty())) {
                            JOptionPane.showMessageDialog(null, "Product ID " + t.getProduct_id() + " chưa đủ số lượng trong hóa đơn!!!");
                            //System.out.println("Product ID"+t.getProduct_id()+" chưa đủ số lượng trong hóa đơn!!!");
                        } else if (v > Integer.parseInt(t.getQty())) {
                            JOptionPane.showMessageDialog(null, "Product ID " + t.getProduct_id() + " thừa số lượng trong hóa đơn!!!");
                            System.out.println("Product ID" + t.getProduct_id() + " thừa số lượng trong hóa đơn!!!");
                        }
                    }//else if(!k.contains(t.getProduct_id())){
                    //System.out.println(k+" so sanh trung hoac khong co trong hóa đơn");
                    //}

                }
                //System.out.println(t.getProduct_id()+": "+t.getQty());
            }

            if (count == size) {

                for (Map.Entry<String, RFID> entry : map1.entrySet()) {
                    String k = entry.getKey();
                    tagBUS.updateTag(k, cbb_order_id.getSelectedItem().toString());
                }
                for (Test t : products) {
                    bus.updateWarehouse(t.getProduct_id(), Integer.parseInt(t.getQty()));
                    System.out.println("Cập nhật số lượng tồn thành công");
                }
            }
        }

    }//GEN-LAST:event_btnCheckActionPerformed

    private void cbb_order_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_order_idActionPerformed

    }//GEN-LAST:event_cbb_order_idActionPerformed

    private void btn_new_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_new_orderActionPerformed
        Order_GUI a = new Order_GUI();
        a.setVisible(true);
        a.setLocationRelativeTo(null);

    }//GEN-LAST:event_btn_new_orderActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        cbb_order_id.removeAllItems();
        getCb_Box_Order();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void cbb_order_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbb_order_idMouseClicked
        List<Test> products = new ArrayList<>();
        products = bus.getListProductID(cbb_order_id.getSelectedItem().toString());
        model.setRowCount(0);
        for (Test t : products) {
            model.addRow(new Object[]{cbb_order_id.getSelectedItem().toString(), t.getProduct_id(), t.getQty()});
        }
    }//GEN-LAST:event_cbb_order_idMouseClicked

    private void cbb_order_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_order_idItemStateChanged
//        List<Test> products=new ArrayList<>();
//        products=bus.getListProductID(cbb_order_id.getSelectedItem().toString());
//        model.setRowCount(0);
//        for(Test t: products){
//            model.addRow(new Object[] {cbb_order_id.getSelectedItem().toString(),t.getProduct_id(),t.getQty()});
//        }
    }//GEN-LAST:event_cbb_order_idItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            UIManager.setLookAndFeel(new FlatLightLaf());
            //</editor-fold>
            //</editor-fold>
        } catch (UnsupportedLookAndFeelException ex) {
            Exceptions.printStackTrace(ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btn_new_order;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JComboBox<String> cbb_order_id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable tbl_count;
    private javax.swing.JTable tbl_orderdetail;
    public static javax.swing.JTable tbl_scan;
    // End of variables declaration//GEN-END:variables
}
