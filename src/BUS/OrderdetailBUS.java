/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.OrderdetailDAO;
import DTO.Orderdetail;
import DTO.Order;
import DTO.Product;
import DTO.Report;
import DTO.Test;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class OrderdetailBUS {
    public List<Orderdetail> dsd;
    public List<Report> report;
    public List<Test> list;
    OrderdetailDAO data = new OrderdetailDAO();
    public OrderdetailBUS(){
        
    }
    public List<Orderdetail> getListV(){
        if(dsd==null) dsd=new ArrayList<>();
        dsd=data.getListD();
        return dsd;
    }
    public static void docDSTV(){
        //if(dstv==null) dstv=new ArrayList<>();
        //dstv=data.getListTV();
    }
    public void them(Orderdetail tv){
        data.them(tv);
        dsd.add(tv);
    }
    public void sua(Orderdetail tv,String dk,String dk2){
        
        data.sua(tv,dk,dk2);
    }
    public void xoa(Orderdetail tv){
        data.xoa(tv);
    }
    public List<Order> fill_cbb_order() {
        List<Order> list = new ArrayList<>();
        list = data.fill_cbb_order();
        return list;
    }
    
     public List<Product> fill_cbb_product() {
        List<Product> list = new ArrayList<>();
        list = data.fill_cbb_product();
        return list;
    }
     public String query_product_name(String id){
        return data.query_product_name(id);
    }
     public int query_quanity(String id){
        return data.query_quanity(id);
    }
     public List<Report> reports(String from, String to){
        if(report==null) report=new ArrayList<>();
        report=data.report(from, to);
        return report;
    }
     public List<Test> getListProductID(String orderId){
        if(list==null) list=new ArrayList<>();
        list=data.getProductID(orderId);
        return list;
    }
     public void updateWarehouse(String productId, int qty){
         data.updateWarehouse(productId, qty);
     }
}
