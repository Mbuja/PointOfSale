package orm.DAI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import orm.DAO.OrderDO;
import orm.DAO.OrderFlatDO;
import point.of.sale.Product;

public class OrderMapper {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static OrderDO toOrderDO(List<OrderFlatDO> rows) {
        if (rows.isEmpty()) return null;

        OrderFlatDO first = rows.get(0);

        OrderDO order = new OrderDO();
        order.setOrderNo(first.order_no);
        order.setOwner(first.owner);
        order.setTotal(first.total);
        System.out.println("Time: " + first.created);
        order.setDate(first.created);

        Map<Product, Integer> productMap = new HashMap<>();
        for (OrderFlatDO row : rows) {
            Product p = new Product();
            p.setId(Integer.toString(row.product_id));
            p.setName(row.name);
            p.setPrice(row.price);

            productMap.put(p, row.quantity);
        }

        order.setProducts(productMap);
        return order;
    }
}
