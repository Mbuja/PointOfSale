package api;
import databaseManagement.DatabaseManager;
import io.javalin.http.Context;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiParam;
import io.javalin.openapi.OpenApiResponse;
import net.lemnik.eodsql.QueryTool;
import orm.DAI.CompanyDAI;
import orm.DAO.CompanyDO;
import io.javalin.openapi.OpenApiContent;
import point.of.sale.Company;

import java.sql.SQLException;

import com.google.gson.Gson;

public class CompanyHandler {
    private DatabaseManager dbManager;

    public CompanyHandler(){
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
        try{
            //Company company = dbManager.getCompanyByName(name);
            if(isConnected()){
                CompanyDAI companies = QueryTool.getQuery(dbManager.getConnection(), CompanyDAI.class);
                CompanyDO com = companies.getCompanyByName(name);
                Company company = com.toCompanyObject();
                Gson gson = new Gson();
                String companyJson = gson.toJson(company);
                context.status(200);
                context.json(companyJson);
            }
        }catch(SQLException e){
            System.out.println("Connection to database failed!!");
            e.printStackTrace();
        }
    }



    @OpenApi(
        summary = "Returns list of companies stored in database",
        operationId = "listCompanies",
        path = "/companies",
        tags = {"Company"},
        methods = HttpMethod.GET,
        responses = {
            @OpenApiResponse (status = "200",content = {
                @OpenApiContent (from = Company[].class )
            })
        }
    )
    public void listCompanies(Context context){

    }

    private boolean isConnected() throws SQLException{
        return (!dbManager.getConnection().isClosed() || dbManager.getConnection()!=null);
    }

}
