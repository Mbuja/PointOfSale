package api;

import java.sql.SQLException;
import java.util.ArrayList;

import databaseManagement.DatabaseManager;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiResponse;
import net.lemnik.eodsql.QueryTool;
import orm.DAI.ProductDAI;
import orm.DAO.ProductDO;
import io.javalin.openapi.OpenApiContent;
import io.javalin.openapi.OpenApiParam;
import point.of.sale.Product;
import io.javalin.http.Context;
import com.google.gson.Gson;

public class ProductHandler {

    private DatabaseManager dbManager;

    public ProductHandler(){
        dbManager  = new DatabaseManager();
    }

    @OpenApi(
        summary = "Returns product based on product id",
        operationId = "getProduct",
        path = "/product/{product_no}",
        pathParams = {@OpenApiParam (name = "product_no",type = String.class,description = "Product no as string")},
        methods = HttpMethod.GET,
        tags = {"Product"},
        responses = {
            @OpenApiResponse(status = "200",content = {@OpenApiContent (from = Product.class)})
        }
    )

    
    public void getProductById(Context context){
        System.out.println("Getting product by product no");
        String productNo = context.pathParam("product_no");
        try{
            if(isConnected()){
                ProductDAI productQuery = QueryTool.getQuery(dbManager.getConnection(),ProductDAI.class);
                ProductDO productDo = productQuery.getProductById(productNo);
                Gson gson = new Gson();
                String productJson = gson.toJson(productDo);
                context.status(200);
                context.json(productJson);
            }
        }catch(SQLException e){
            System.out.println("Connection to database failed");
            e.printStackTrace();
        }
    }
    @OpenApi(
        summary = "Returns list of products belonging to a specific company",
        operationId = "listProducts",
        path = "/products/{company}",
        methods = HttpMethod.GET,
        responses = {
            @OpenApiResponse (status = "200",content = {
                @OpenApiContent(from = Product[].class)
            })
        },
        tags  = {"Product"},
        pathParams = {@OpenApiParam(name = "name",type = String.class,description = "Name to company")}
            
        )
    public void getProductsByCompany(){
        System.out.println("Getting products by company");
    }

    private boolean isConnected() throws SQLException{
        return (!dbManager.getConnection().isClosed() || dbManager.getConnection()!=null);
    }

}
