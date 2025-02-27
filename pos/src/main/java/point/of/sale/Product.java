package point.of.sale;


public class Product {
    private String id;
    private String name;
    private String category;
    private double price;
    private String description;
    private String companyId;
    private String serialNo;
    

    //Still to pass through validators
    public Product(String id,String name,String category ,Double price,String description,String companyId,String serialNo){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price= price;
        this.companyId = companyId;
        this.description = description;
        this.serialNo = serialNo;
    }

    public void setId(String id){
        this.id = id;

    }
    
    public String getId(){
        return id;
    }


    public void setName (String name){
        if(isValidName(name)){
            this.name = name;}
        else{
            throw new IllegalArgumentException("Invalid name"); 
        }
    }

    public String getName(){
        return name;
    }


    public void setCategory(String cat){
        this.category = cat;
    }

    public String getCategory(){
        return category;
    }
    
    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setCompanyId(String supplierId){
        this.companyId = supplierId;
    }

    public String getCompanyId(){
        return companyId;
    }

    public void setSerialNo(String serialNo){
        this.serialNo = serialNo;
    }

    public String getSerialNo(){
        return serialNo;
    }

    public boolean isValidDescription(String description) {
        return description.length()<=250;
    }

    public boolean isValidName(String name) {
        return name.length()>1;
    } 
}
