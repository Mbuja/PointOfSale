package orm.DAO;

import point.of.sale.Company;

public class CompanyDO {
    private int id;
    private String name;
    private String address;
    private String email;
    private String telephoneNumber;
    private String accountNumber;
    private String description;
    public CompanyDO(){

    }
    public CompanyDO(int id,String name,String email,String address,String telephoneNumber,String accountNumber,String description){
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.accountNumber = accountNumber;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Company toCompanyObject(){
        return new Company(this.id,this.name,this.email,this.address,this.telephoneNumber,this.accountNumber,this.description);
    }
}
