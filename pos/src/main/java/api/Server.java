package api;

import io.javalin.Javalin;
import io.javalin.openapi.plugin.OpenApiPlugin;
import io.javalin.openapi.plugin.redoc.ReDocConfiguration;
import io.javalin.openapi.plugin.redoc.ReDocPlugin;
import io.javalin.openapi.plugin.swagger.SwaggerConfiguration;
import io.javalin.openapi.plugin.swagger.SwaggerPlugin;
import io.javalin.openapi.OpenApiInfo;
import io.javalin.openapi.plugin.DefinitionConfiguration;

import static io.javalin.apibuilder.ApiBuilder.*;

/*Http server for serving endpoints and configuring javalin webserver socket */
public class Server {
    private Javalin server;
    private int DEFAULT_PORT = 5001;
    private CompanyHandler companyHandler;
    private ProductHandler productHandler;
    private static OrderHandler OrderHandler;
    public static void main(String [] args){
        Server server = new Server();
        server.start();

    }

    public Server(){
        config();
    }



    @SuppressWarnings("deprecation")
    private void config(){
        //Create OpenApi config
        this.server  =Javalin.create( config -> {
            config.registerPlugin(new OpenApiPlugin(pluginConfig -> {
                pluginConfig.withDocumentationPath("/openapi")
                .withDefinitionConfiguration((version, definition) -> {
                    definition.withOpenApiInfo (info -> {
                    info.setTitle("Point Of Sale API");
                    info.setDescription("Documentation for point of sale api ");
                    info.setVersion("1.0");
                });
            });
            }));
            SwaggerConfiguration swagConfig = new SwaggerConfiguration();
            swagConfig.setUiPath("swaggers");
            config.registerPlugin(new SwaggerPlugin(swaggerConfig ->{
                swaggerConfig.setUiPath("/docs");
            }));
            config.registerPlugin(new ReDocPlugin());
        });
       
        server.get("/company/{name}",context->companyHandler.getCompany(context));
        server.get("/companies",context->companyHandler.listCompanies(context));
        server.get("/product/{product_no}",context->productHandler.getProductById(context));
        server.get("order/{order_no}",context->OrderHandler.getOrderByNo(context));
    }

    public void start(){
        companyHandler = new CompanyHandler();
        productHandler = new ProductHandler();
        OrderHandler = new OrderHandler();
        this.server.start(DEFAULT_PORT);
    }

    public void start(int port){
        this.server.start(port);
    }

    public void close(){
        server.stop();
    }
}
