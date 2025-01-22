package api;
import databaseManagement.DatabaseManager;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiParam;
import io.javalin.openapi.OpenApiResponse;
import io.javalin.openapi.OpenApiContent;
import point.of.sale.Company;
import com.google.gson.Gson;

public class Handler {
    private DatabaseManager dbManager;

    public Handler(){
        dbManager = new DatabaseManager();
    }
    @OpenApi(
        summary = "Get Company Details based on name of company",
        operationId = "getCompany",
        path = "/company/{name}",
        methods = HttpMethod.GET,
        pathParams = {@OpenApiParam(name = "name",type = String.class,description = "Name of the company")},
        tags = {"Company"},
        responses = {
            @OpenApiResponse(status = "200" ,content = {@OpenApiContent(from = Company.class)})
        }
    )
    public void getCompany(Context context){
        System.out.println("Running handler");
        String name = context.pathParam("name");
        Company company = dbManager.getCompanyByName(name);
        Gson gson = new Gson();
        String companyJson = gson.toJson(company);
        context.status(200);
        context.json(companyJson);
    }
}
