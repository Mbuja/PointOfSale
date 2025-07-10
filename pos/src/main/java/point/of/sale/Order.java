package point.of.sale;

import java.time.LocalDateTime;
import java.util.Map;

enum Status{
    SETTLED,
    UNPAID,
    PARTIALLY_PAID,
    ARREARS
}
public class Order {

    private String orderNo;
    private String owner;
    private Map<Product,Integer> products;
    private float total;
    private LocalDateTime created;
    private Status status;
    

    public Order(){
        this.orderNo = "";
        this.owner = "";
        this.products = null;
        this.total = 0.0f;
        this.created = LocalDateTime.now();
        this.status = Status.UNPAID; // Default status
    }
    
    public Order(String  order,String owner,Map<Product,Integer>products,float total,LocalDateTime date,Status status){
        this.orderNo = order;
        this.owner = owner;
        this.products = products;
        this.total = total;
        this.created = date;
        this.status = status;

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

    public void setDate(LocalDateTime date){
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

    public LocalDateTime getCreationDate(){
        return this.created;
    }
    
    
}
