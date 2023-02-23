/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.OrderDAO;
import DTO.Order;
import DTO.Report;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class OrderBUS {
    public List<Report> report;
    public List<Order> dsmh;
    //public List<Integer> list;
    OrderDAO data = new OrderDAO();
    public OrderBUS(){
        
    }
    public List<Order> getListV(){
        if(dsmh==null) dsmh=new ArrayList<>();
        dsmh=data.getListMH();
        return dsmh;
    }
    public static void docDSTV(){
        //if(dstv==null) dstv=new ArrayList<>();
        //dstv=data.getListTV();
    }
    public void them(Order tv){
        data.them(tv);
        dsmh.add(tv);
    }
    public void sua(Order tv,String dk){
        
        data.sua(tv,dk);
    }
    public void xoa(Order tv){
        data.xoa(tv);
    }
    public void updateStatus(String id){
        data.updateStatus(id);
    }
    public List<Report> reports(String from, String to){
        if(report==null) report=new ArrayList<>();
        report=data.report(from, to);
        return report;
    }
    public int getStatusOrder(String id){
        return data.getStatusOrder(id);
    }
}
