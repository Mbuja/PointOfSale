package api;


import databaseManagement.DatabaseManager;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiResponse;
import net.lemnik.eodsql.QueryTool;
import orm.DAI.OrderDAI;
import orm.DAI.ProductDAI;
import orm.DAO.OrderDO;
import orm.DAO.OrderFlatDO;
import orm.DAO.ProductDO;
import io.javalin.openapi.OpenApiContent;
import io.javalin.openapi.OpenApiParam;
import point.of.sale.Product;
import io.javalin.http.Context;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import api.serializers.ProductMapSerializer;

public class OrderHandler {

    private DatabaseManager dbManager;

    public OrderHandler(){
        dbManager  = new DatabaseManager();
    }

    public void getOrderByNo(Context context){
        System.out.println("Getting order by order no");
        String orderNo = context.pathParam("order_no");
        try{
            if(isConnected()){
                OrderDAI orderQuery = QueryTool.getQuery(dbManager.getConnection(), OrderDAI.class);
                //OrderDO orderDo = orderQuery.getOrderByNo(orderNo);
                List<OrderFlatDO> rs = orderQuery.fetchOrderProducts(orderNo);
                OrderDO orderDo = orm.DAI.OrderMapper.toOrderDO(rs);
                Gson gson = new GsonBuilder()
                    .registerTypeAdapter(
                        new TypeToken<Map<Product, Integer>>() {}.getType(),
                        new ProductMapSerializer()
                )
                .setPrettyPrinting()
                .create();

                String orderJson = gson.toJson(orderDo);
                context.status(200);
                context.json(orderJson);
            }
        }catch(SQLException e){
            System.out.println("Connection to database failed");
            e.printStackTrace();
        }

    }


    private boolean isConnected() throws SQLException{
        return (!dbManager.getConnection().isClosed() || dbManager.getConnection()!=null);
    
    }
}
