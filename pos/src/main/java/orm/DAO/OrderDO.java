package orm.DAO;

import java.time.LocalDateTime;
import java.util.Map;

import point.of.sale.Product;


enum Status{
    SETTLED,
    UNPAID,
    PARTIALLY_PAID,
    ARREARS
}

public class OrderDO {
    private String orderNo;
    private String owner;
    private Map<Product,Integer> products;
    private float total;
    private String created;
    private Status status;
    
    public OrderDO(String  order,String owner,Map<Product,Integer>products,float total,String date,Status status){
        this.orderNo = order;
        this.owner = owner;
        this.products = products;
        this.total = total;
        this.created = date;
        this.status = status;

    }

    public OrderDO() {
        // Default constructor for ORM mapping
    }

    public void setOrderNo(String order){
        this.orderNo = order;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public void setProducts(Map<Product,Integer>products){
        this.products = products;
    }

    public void setTotal(float total){
        this.total = total;
    }

    public void setDate(String date){
        this.created  = date;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public String getOrderNo(){
        return this.orderNo;
    }
    
    public String getOwner(){
        return this.owner;
    }
    
    public Map<Product,Integer> getProducts(){
        return this.products;
    }

    public float getTotal(){
        return total;
    }
    
    public Status getStatus(){
        return this.status;
    }

    public String getCreationDate(){
        return this.created;
    }
    
    

}
