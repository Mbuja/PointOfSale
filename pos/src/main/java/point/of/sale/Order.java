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
    
    public Order(String  order,String owner,Map<Product,Integer>products,float total,LocalDateTime date){
        this.orderNo = order;
        this.owner = owner;
        this.products = products;
        this.total = total;
        this.created = date;

    }
    

}
