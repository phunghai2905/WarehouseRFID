/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Tag_BUS;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI
 */
public class Input1 {

    public Input1() {
        TagRFID a=new TagRFID();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
    }


    void scan() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Scanner sc = new Scanner(System.in);
        long start = System.currentTimeMillis();
        long end = start + 20 * 1000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (System.currentTimeMillis() < end) {
                    System.out.println("Nhap tag id: ");
                    String tagid = sc.nextLine();
                    String date = dtf.format(now);
                    //System.out.println("Nhap gate: ");
                    String gate = "1";
                    TagRFID.map.put(tagid, new RFID(date, gate));
                    TagRFID.model.setRowCount(0);

                    for (Map.Entry<String, RFID> entry : TagRFID.map.entrySet()) {
                        //tempList=new HashSet<>();
                        String k = entry.getKey();
                        RFID v = entry.getValue();
                        TagRFID.model.addRow(new Object[]{k, v.getDate(), v.getGate()});
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Input1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();

    }
    
    List<String> getTags(){
        List<String> list=new ArrayList<>();
        for(int i=51;i<61;i++){
            list.add("300F 4FB7 3AD0 01C0 8369 A"+i);
        }
                      
        return list;
    }
    public void scan2(){  
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
                for(String s: getTags()) {                   
                    TagRFID.map.put(s, new RFID(dtf.format(now),"1"));
                    TagRFID.model.setRowCount(0);

                    for (Map.Entry<String, RFID> entry : TagRFID.map.entrySet()) {
                        //tempList=new HashSet<>();
                        String k = entry.getKey();
                        RFID v = entry.getValue();
                        TagRFID.model.addRow(new Object[]{k, v.getDate(), v.getGate()});
                        TagRFID.tbl_tag_rfid.setModel(TagRFID.model);                       
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Input1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
         
    }

}
