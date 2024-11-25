package databaseManagement;

import orm.DAI.CompanyDAI;
import orm.DAO.CompanyDO;

import point.of.sale.Company;

import java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.SQLException;

import net.lemnik.eodsql.QueryTool;

public class DatabaseManager {
    public static final String DISK_DB_URL = "jdbc:sqlite:pos/src/main/resources/pos.db";
    private Connection connection;


    public DatabaseManager(){
        try{
            connect();
        }catch(SQLException e){
            //Possible connection error
            e.printStackTrace();
        }
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(DISK_DB_URL);
    }

    public Connection getConnection() {
        return connection;
    }
    public Company getCompanyByName(String name){
        try {
            if (!connection.isClosed() || connection != null) {
                CompanyDAI companies = QueryTool.getQuery(connection, CompanyDAI.class);
                CompanyDO com = companies.getCompanyByName(name);
                return com.toCompanyObject();
            }
        }catch(SQLException e){
            System.out.println("Connection to database failed!!");
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String [] args) throws SQLException {
        DatabaseManager manager = new DatabaseManager();
        try{
            manager.connect();
            CompanyDAI companies = QueryTool.getQuery(manager.getConnection(), CompanyDAI.class);
            CompanyDO com = companies.getCompanyByName("Test Company");
            CompanyDO com2 = companies.getCompanyById(2);
            System.out.println("Made it past this stage so companies aren't null");
            System.out.println(com.toCompanyObject());
            System.out.println(com2);

        }catch (SQLException e){
            e.printStackTrace();

        }
        finally {
            if(manager.getConnection() !=null && !manager.getConnection().isClosed()){
                manager.getConnection().close();
            }

        }


}
}