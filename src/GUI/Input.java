/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Tag_BUS;
import DAO.TagDAO;
import DTO.RFID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public class Input {

    //public static Set<RFID> listScan1 = new HashSet<>();;
    Set<String> tempList = new HashSet<>();
    Tag_BUS tagBUS = new Tag_BUS();
    int count = 0;
    Set<String> colData;

    public Input() {
        InventoryGUI a = new InventoryGUI();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
    }

    List<String> getTags() {
        List<String> list = new ArrayList<>();
        for (int i = 51; i < 61; i++) {
            list.add("300F 4FB7 3AD0 01C0 8369 A" + i);
        }
//        for (int i = 30; i < 50; i++) {
//            list.add("300F 4FB7 3AD0 01C0 8369 A" + i);
//        }

//            for (int i =50; i < 60; i++) {
//            list.add("300F 4FB7 3AD0 01C0 8369 A" + i);
//        }
        

        return list;
    }

    public void scan() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //tempList=new HashSet<>();

        for (String s : getTags()) {
            InventoryGUI.map1.put(s, new RFID(dtf.format(now), "1"));
            InventoryGUI.model1.setRowCount(0);

            for (Map.Entry<String, RFID> entry : InventoryGUI.map1.entrySet()) {

                String k = entry.getKey();
                RFID v = entry.getValue();
                InventoryGUI.model1.addRow(new Object[]{k, v.getDate(), v.getGate()});
                InventoryGUI.tbl_scan.setModel(InventoryGUI.model1);
                tagBUS.updateTimeScanTag(k, v.getDate());
                tempList.add(k);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Input1.class.getName()).log(Level.SEVERE, null, ex);
            }
            showProduct();
        }
        //showProduct();          
    }

    public void show() {
        InventoryGUI.model2.setRowCount(0);
        Vector data = InventoryGUI.model1.getDataVector();
        Vector row = (Vector) data.elementAt(0);
        int mColIndex = 0;
        Set<String> colData = new HashSet<>(InventoryGUI.tbl_scan.getRowCount());

        for (int i = 0; i < InventoryGUI.tbl_scan.getRowCount(); i++) {
            row = (Vector) data.elementAt(i);
            colData.add(row.get(mColIndex).toString());
        }

        for (String s : colData) {
            System.out.println(s);
            String element = tagBUS.query_product_id(s);

            if (InventoryGUI.map.containsKey(element)) {
                InventoryGUI.map.put(element, InventoryGUI.map.get(element) + 1);
            } else {
                InventoryGUI.map.put(element, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : InventoryGUI.map.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
            System.out.println(k + " + " + v);
            InventoryGUI.model2.addRow(new Object[]{k, v});
        }
    }

    private void showProduct() {
        
                InventoryGUI.model2.setRowCount(0);
                InventoryGUI.map = new HashMap<>();
                for (String ls : tempList) {
                    if(TagDAO.CheckPrimaryKey(ls)){
                    String element = tagBUS.query_product_id(ls);

                    System.out.println(element);
                    if (InventoryGUI.map.containsKey(element)) {
                        InventoryGUI.map.put(element, InventoryGUI.map.get(element) + 1);
                    } else {
                        InventoryGUI.map.put(element, 1);
                    }
                    }else{
                        System.out.println("Tag ID: "+ls+" khong chua duoc dinh danh");
                    }
                }

                for (Map.Entry<String, Integer> entry : InventoryGUI.map.entrySet()) {
                    String k = entry.getKey();
                    int v = entry.getValue();
                    //System.out.println(k + " + " + v);
                    InventoryGUI.model2.addRow(new Object[]{k, v});
                }
    
    }
}
