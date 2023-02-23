/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TagReportListenerImplementation;

import DTO.RFID;
import GUI.TagRFID;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI
 */
public class MyTagReportListener implements TagReportListener{

    public MyTagReportListener() {
        TagRFID a=new TagRFID();
        a.setVisible(true);  
        a.setLocationRelativeTo(null);
    }


    @Override
    public void onTagReported(ImpinjReader reader, TagReport report) {
        List<Tag> tags = report.getTags();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        
                for (Tag t : tags) {

                    String epc = t.getEpc().toString();
                    String time = dtf.format(now);
                    String gate = String.valueOf(t.getAntennaPortNumber());

                    TagRFID.map.put(epc, new RFID(time, gate));
                  
                    TagRFID.model.setRowCount(0);
                    for (Map.Entry<String, RFID> entry : TagRFID.map.entrySet()) {

                        String k = entry.getKey();
                        RFID v = entry.getValue();
                        TagRFID.model.addRow(new Object[]{k, v.getDate(), v.getGate()});
                        TagRFID.tbl_tag_rfid.setModel(TagRFID.model);
                    }

                    System.out.print(" EPC: " + t.getEpc().toString());

                    if (reader.getName() != null) {
                        System.out.print(" Reader_name: " + reader.getName());
                    } else {
                        System.out.print(" Reader_ip: " + reader.getAddress());
                    }

                    if (t.isAntennaPortNumberPresent()) {
                        System.out.print(" antenna: " + t.getAntennaPortNumber());
                    }
                  
                    System.out.println("");
                }

            }
        
    
}
