package point.of.sale;

import java.math.BigInteger;

public class Company {

    private String name;
    private String email;
    private String address;
    private String telephoneNumber;
    private String accountNumber;
    private String description;

    public Company(){
        name = "";
        email = "";
        address = "";
        telephoneNumber = "";
        accountNumber = "";
        description = "";


    }

    public Company(String name,String email,String address,String telephoneNumber,String accountNumber,String description){
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.accountNumber = accountNumber;
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return  "";
    }
}