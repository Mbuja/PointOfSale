package orm.DAO;

public class ProductDO {

    private String id;
    private String name;
    private String company;
    private double price;
    private String description;
    private String product_no;
    private String serial_no;


    public ProductDO(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void  setProductNo(String productNo){
        this.product_no = productNo;
    }

    public String getProductNo(){
        return this.product_no;
    }

    public void setPrice(double price){
        this.price  = price;
    }
    
    public double getPrice(){
        return this.price;
    }

    public String getCompany(){
        return this.company;
    }

    public void setCompany(String company){
        this.company = company;
    }

    //Validation required for serial no?
    public void setSerialNo(String serial){
        this.serial_no = serial;
    }

    public String getSerialNo(){
        return this.serial_no;
    }
}
