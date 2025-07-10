package orm.DAI;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;
import orm.DAO.OrderDO;
import orm.DAO.OrderFlatDO;

import java.sql.ResultSet;
import java.util.List;

public interface OrderDAI extends BaseQuery{

    @Select("""
        SELECT 
            o.orderNo, o.owner, o.total, o.created,
            oi.product_id, oi.quantity,p.name, p.price
        FROM orders o 
        JOIN order_items oi ON o.orderNo = oi.orderNo
        JOIN product p ON oi.product_id = p.id
        WHERE o.orderNo = ?{1}
            """)
    List<OrderFlatDO> fetchOrderProducts(String orderNo);

    @Select("SELECT * FROM orders where owner=?{1}")
    List<OrderDO> getOrdersByOwner(String owner);
    
    //Still to add user class
}