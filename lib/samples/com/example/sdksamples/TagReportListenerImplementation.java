package com.example.sdksamples;

import BUS.Tag_BUS;
import DTO.RFID;
import GUI.InventoryGUI;
import com.impinj.octane.ImpinjReader;
import com.impinj.octane.Tag;
import com.impinj.octane.TagReport;
import com.impinj.octane.TagReportListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TagReportListenerImplementation implements TagReportListener {

    public static Set<RFID> listScan;
    Map<String, RFID> map1;
    Map<String, Integer> map;
    DefaultTableModel model1, model2;
    Set<RFID> tempList;
    Tag_BUS tagBUS = new Tag_BUS();

    public TagReportListenerImplementation() {
    }

    public TagReportListenerImplementation(Map<String, RFID> map1, Map<String, Integer> map, DefaultTableModel model1, DefaultTableModel model2) {
        this.map1 = map1;
        this.map = map;
        this.model1 = model1;
        this.model2 = model2;
    }

    @Override
    public void onTagReported(ImpinjReader reader, TagReport report) {
        List<Tag> tags = report.getTags();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Tag t : tags) {
                    String epc = t.getEpc().toString();
                    String time = dtf.format(now);
                    String gate = String.valueOf(t.getAntennaPortNumber());
                    map1.put(epc, new RFID(time, gate));
                    model1.setRowCount(0);

                    for (Map.Entry<String, RFID> entry : map1.entrySet()) {
                        String k = entry.getKey();
                        RFID v = entry.getValue();
                        model1.addRow(new Object[]{k, v.getDate(), v.getGate()});
                        InventoryGUI.tbl_scan.setModel(model1);
                    }

                }
                show();
            }
        }).start();

    }

    private void showProduct() {
        model2.setRowCount(0);
        for (RFID ls : tempList) {
            String element = tagBUS.query_product_id(ls.getTagID());
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

    void show() {
        model2.setRowCount(0);
        Vector data = model1.getDataVector();
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

}
