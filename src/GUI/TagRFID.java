/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.OrderdetailBUS;
import BUS.Tag_BUS;
import DTO.Product;
import DTO.RFID;
import DTO.Tag;
import Lib.RoundedBorder;
import com.example.sdksamples.SampleProperties;
import com.example.sdksamples.TagReportListener1;
import com.example.sdksamples.TagReportListenerImplementation;
import com.formdev.flatlaf.FlatLightLaf;
import com.impinj.octane.AntennaConfigGroup;
import com.impinj.octane.ImpinjReader;
import com.impinj.octane.OctaneSdkException;
import com.impinj.octane.ReaderMode;
import com.impinj.octane.ReportConfig;
import com.impinj.octane.ReportMode;
import com.impinj.octane.Settings;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.openide.util.Exceptions;

/**
 *
 * @author MSI
 */
public class TagRFID extends javax.swing.JFrame {

    public static Set<RFID> listScan;
    public static DefaultTableModel model, model1;
    List<Tag> tvList = new ArrayList<>();
    Tag_BUS bus = new Tag_BUS();
    OrderdetailBUS bus1 = new OrderdetailBUS();
    public static Map<String, RFID> map = new HashMap<>();
    boolean isStop=true;

    /**
     * Creates new form TagRFID
     */
    public TagRFID() {
        initComponents();

//btn_add_all.setContentAreaFilled(false);
        //btn_add_all.setBorder(new RoundedBorder(10));
        //btn_add_all.setBackground(Color.CYAN);
        //btn_add_all.setFocusPainted(false);
//btn_add_all.setOpaque(true);
//btn_add_all.setFocusPainted(false);
        model = (DefaultTableModel) tbl_tag_rfid.getModel();
        model1 = (DefaultTableModel) tbl_tag.getModel();
        showD();
        //if(listScan==null){
        //System.out.println("Du lieu rong");
        //}else{
        //showResult();
        //}
        getCb_Box_Product();
    }

    private void showD() {
        tvList = bus.getListV();
        model1.setRowCount(0);
        tvList.forEach((tv) -> {
            model1.addRow(new Object[]{tv.getTag_id(), tv.getProduct_id(), tv.getDate(), tv.getGate()});
        });

    }

    private void getCb_Box_Product() {
        List<Product> list = new ArrayList<>();
        list = bus1.fill_cbb_product();
        for (Product item : list) {
            cbb_product_id.addItem(item.getProduct_id());
        }

    }

//    private void showResult() {
//        map = new HashMap<>();
//
////        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
////        LocalDateTime now = LocalDateTime.now();
//        //listScan=TagReportListenerImplementation.list;
////        listScan = new HashSet<>();
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A28F", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A241", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A28F", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A230", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A249", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A250", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A250", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A255", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A28F", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A230", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A249", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A250", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A250", dtf.format(now), "1"));
////        listScan.add(new RFID("300F 4F57 3AD0 01C0 8369 A255", dtf.format(now), "1"));
////        Scanner sc=new Scanner(System.in);
////        for(int i=0;i<2;i++){
////            System.out.println("Nhap tag id: ");
////            String tagid=sc.nextLine();
////            String date=dtf.format(now);
////            System.out.println("Nhap gate: ");
////            String gate=sc.nextLine();
////            listScan.add(new RFID(tagid, date, gate));
////        }
//        Input.listScan1.forEach((ls) -> {
//            map.put(ls.getTagID(), new RFID(ls.getDate(), ls.getGate()));
//            //model.addRow(new Object[]{ls.getTagID(), ls.getDate(), ls.getGate()});
//        });
//
//        for (Map.Entry<String, RFID> entry : map.entrySet()) {
//            String k = entry.getKey();
//            RFID v = entry.getValue();
//            model.addRow(new Object[]{k, v.getDate(), v.getGate()});
//        }
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tag_rfid = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_tag = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb_time = new javax.swing.JLabel();
        txt_gate = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_tag_id = new javax.swing.JTextArea();
        cbb_product_id = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_refresh = new javax.swing.JButton();
        txt_save = new javax.swing.JButton();
        btn_add_all = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btnConnect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(153, 153, 255));

        tbl_tag_rfid.setBackground(new java.awt.Color(153, 204, 255));
        tbl_tag_rfid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_tag_rfid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag_ID", "date/time", "gate"
            }
        ));
        tbl_tag_rfid.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_tag_rfid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tag_rfidMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tag_rfid);

        jScrollPane2.setBackground(new java.awt.Color(51, 204, 255));
        jScrollPane2.setBorder(null);

        tbl_tag.setBackground(new java.awt.Color(204, 204, 255));
        tbl_tag.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_tag.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TagID", "Product_ID", "Date", "Gate"
            }
        ));
        tbl_tag.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_tag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tagMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_tag);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TAG ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date time");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gate");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 11, 56, -1));

        lb_time.setForeground(new java.awt.Color(255, 255, 255));
        lb_time.setText("Time");
        jPanel1.add(lb_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));
        jPanel1.add(txt_gate, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 31, 87, -1));

        txt_tag_id.setColumns(20);
        txt_tag_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tag_id.setRows(5);
        jScrollPane3.setViewportView(txt_tag_id);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, -1, 112));

        cbb_product_id.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbb_product_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_product_idActionPerformed(evt);
            }
        });
        jPanel1.add(cbb_product_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 94, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Scan");

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cấp thẻ RFID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(431, 431, 431)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(19, 19, 19))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_refresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_refresh_20px.png"))); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        jPanel3.add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 113, 59));

        txt_save.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_save_20px.png"))); // NOI18N
        txt_save.setText("Save");
        txt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_saveActionPerformed(evt);
            }
        });
        jPanel3.add(txt_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 29, 95, 60));

        btn_add_all.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_add_all.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_save_20px.png"))); // NOI18N
        btn_add_all.setText("Save ALL");
        btn_add_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_allActionPerformed(evt);
            }
        });
        jPanel3.add(btn_add_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 49));

        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_delete_20px.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel3.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, 49));

        btn_exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_exit_20px.png"))); // NOI18N
        btn_exit.setText("Exit");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        jPanel3.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 100, 49));

        btnConnect.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConnect.setText("Scan");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });
        jPanel3.add(btnConnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 100, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_allActionPerformed

        for (Map.Entry<String, RFID> entry : map.entrySet()) {
            String k = entry.getKey();
            RFID v = entry.getValue();
            Tag tag = new Tag();
            tag.setTag_id(k);
            tag.setProduct_id(cbb_product_id.getSelectedItem().toString());
            tag.setDate(v.getDate());
            tag.setGate(v.getGate());
            System.out.println(tag.getTag_id() + ", " + tag.getProduct_id() + ", " + tag.getDate());
            bus.them(tag);
            model.setRowCount(0);
        }
        JOptionPane.showMessageDialog(rootPane, "Đã thêm");
        tbl_tag.setModel(model1);
        showD();// TODO add your handling code here:
    }//GEN-LAST:event_btn_add_allActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int i = tbl_tag.getSelectedRow();

        Tag tv = bus.dssv.get(i);
        int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
        if (option == 0) {
            bus.xoa(tv);
            if (bus.dssv.remove(i) == null) {
                model1.removeRow(i);
            }
            tbl_tag.setModel(model1);
            showD();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_exitActionPerformed

    private void tbl_tag_rfidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tag_rfidMouseClicked
        int Row = tbl_tag_rfid.getSelectedRow();
        txt_tag_id.setText(tbl_tag_rfid.getModel().getValueAt(Row, 0).toString());
        txt_gate.setText(tbl_tag_rfid.getModel().getValueAt(Row, 2).toString());
        lb_time.setText(tbl_tag_rfid.getModel().getValueAt(Row, 1).toString());

    }//GEN-LAST:event_tbl_tag_rfidMouseClicked

    private void cbb_product_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_product_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_product_idActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        model.setRowCount(0);
        map = new HashMap<>();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void txt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_saveActionPerformed
        int i = tbl_tag_rfid.getSelectedRow();
        Tag tag = new Tag();
        tag.setTag_id(txt_tag_id.getText());
        tag.setProduct_id(cbb_product_id.getSelectedItem().toString());
        tag.setDate(lb_time.getText());
        tag.setGate(txt_gate.getText());
        //System.out.println(tag.getTag_id() + ", " + tag.getProduct_id() + ", " + tag.getDate());
        bus.them(tag);
        JOptionPane.showMessageDialog(rootPane, "Đã thêm");
        tbl_tag.setModel(model1);
        showD();
        map.remove(tbl_tag_rfid.getModel().getValueAt(i, 0).toString());
        model.removeRow(i);
        System.out.println(tbl_tag_rfid.getModel().getValueAt(i, 0).toString());
    }//GEN-LAST:event_txt_saveActionPerformed

    private void tbl_tagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tagMouseClicked
        int Row = tbl_tag.getSelectedRow();
        txt_tag_id.setText(tbl_tag.getModel().getValueAt(Row, 0).toString());
        txt_gate.setText(tbl_tag.getModel().getValueAt(Row, 3).toString());
        lb_time.setText(tbl_tag.getModel().getValueAt(Row, 2).toString());
        cbb_product_id.setSelectedItem(tbl_tag.getModel().getValueAt(Row, 1));

    }//GEN-LAST:event_tbl_tagMouseClicked

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed

    }//GEN-LAST:event_btnConnectActionPerformed

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
        } catch (UnsupportedLookAndFeelException ex) {
            Exceptions.printStackTrace(ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TagRFID().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btn_add_all;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JComboBox<String> cbb_product_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_time;
    private javax.swing.JTable tbl_tag;
    public static javax.swing.JTable tbl_tag_rfid;
    private javax.swing.JTextField txt_gate;
    private javax.swing.JButton txt_save;
    private javax.swing.JTextArea txt_tag_id;
    // End of variables declaration//GEN-END:variables
}
