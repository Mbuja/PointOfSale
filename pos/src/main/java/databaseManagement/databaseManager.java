package databaseManagement;

import orm.DAI.CompanyDAI;
import orm.DAO.CompanyDO;

import java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import net.lemnik.eodsql.QueryTool;

public class databaseManager {
    public static final String DISK_DB_URL = "jdbc:sqlite:pos/src/main/resources/pos.db";
    private Connection connection;


    public void connect() throws SQLException {
        connection = DriverManager.getConnection(DISK_DB_URL);
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String [] args) throws SQLException {
        databaseManager manager = new databaseManager();
        try{
            manager.connect();
            CompanyDAI companies = QueryTool.getQuery(manager.getConnection(), CompanyDAI.class);
            CompanyDO com = companies.getCompanyByName("Test Company");
            CompanyDO com2 = companies.getCompanyById(2);
            System.out.println("Made it past this stage so comapanies aren't null");
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