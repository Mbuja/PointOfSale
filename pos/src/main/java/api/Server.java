package api;

import io.javalin.Javalin;

public class Server {
    private Javalin server;
    private int DEFAULT_PORT = 5001;
    private Handler handler;
    public static void main(String [] args){

    }

    private void config(){
        //Configuration  of server
        this.server = Javalin.create();
        server.get("/company/{name}",context->handler.getCompany(context));
    }

    public void start(){
        this.server.start(DEFAULT_PORT);
    }

    public void start(int port){
        this.server.start(port);
    }
}
