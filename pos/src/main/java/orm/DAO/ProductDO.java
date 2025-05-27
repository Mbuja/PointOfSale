package orm.DAO;

public class ProductDO {

    private String id;
    private String name;
    private String category;
    private double price;
    private String description;
    private String companyId;
    private String serialNo;


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
    
    public void  setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }

    public void setPrice(double price){
        this.price  = price;
    }
    
    public double getPrice(){
        return this.price;
    }

    public String getCompany(){
        return this.companyId;
    }

    public void setCompany(String company){
        this.companyId = company;
    }

    //Validation required for serial no?
    public void setSerialNo(String serial){
        this.serialNo = serial;
    }

    public String getSerialNo(){
        return this.serialNo;
    }
}
