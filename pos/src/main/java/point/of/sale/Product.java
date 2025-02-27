package point.of.sale;


public class Product {
    private String id;
    private String name;
    private String category;
    private Double price;
    private String description;
    private String supplierId;
    private String serialNo;
    

    //Still to pass through validators
    public Product(String id,String name,String category ,Double price,String description,String supplierId,String serialNo){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price= price;
        this.supplierId = supplierId;
        this.description = description;
        this.serialNo = serialNo;
    }

    public void setId(String id){
        this.id = id;

    }

    public void setName (String name){
        this.name = name;
    }

    public void setCategory(String cat){
        this.category = cat;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setSupplierId(String supplierId){
        this.supplierId = supplierId;
    }

    public void setSerialNo(String serialNo){
        this.serialNo = serialNo;
    }

    public boolean isValidDescription(String description) {
        return description.length()<=250;
    }

    public boolean isValidName(String name) {
        return name.length()>1;
    } 
}
