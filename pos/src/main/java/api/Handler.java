package api;
import databaseManagement.DatabaseManager;
import io.javalin.Javalin;
import io.javalin.http.Context;
import point.of.sale.Company;
import com.google.gson.Gson;

public class Handler {
    DatabaseManager dbManager;
    public void getCompany(Context context){
        String name = context.pathParam("name");
        Company company = dbManager.getCompanyByName(name);
        Gson gson = new Gson();
        String companyJson = gson.toJson(company);
        context.status(200);
        context.json(companyJson);
    }
}
