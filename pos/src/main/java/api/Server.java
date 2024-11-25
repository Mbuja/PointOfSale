package api;

import io.javalin.Javalin;

public class Server {
    private Javalin server;
    private int DEFAULT_PORT = 5001;
    private Handler handler;
    public static void main(String [] args){
        Server server = new Server();
        server.start();


    }

    public Server(){
        config();
    }

    private void config(){
        //Configuration  of server,NB Javalin  6 config different from Javalin 5
        this.server = Javalin.create();
        handler = new Handler();
        server.get("/company/{name}",context->handler.getCompany(context));
    }

    public void start(){
        this.server.start(DEFAULT_PORT);
    }

    public void start(int port){
        this.server.start(port);
    }

    public void close(){
        server.stop();
    }
}
