package point.of.sale;

import java.math.BigInteger;
import java.util.regex.*;

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

    public boolean isEmailValid(String validMail) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(validMail);
        return matcher.matches();
    }

    public boolean isValidDescription(String description) {
        return description.length()<=250;
    }

    public boolean isValidName(String name) {
        return name.length()>1;
    }

    public boolean isPhoneNumberValid(String telephoneNumber) {
        String regex = "^(\\+\\d{1,3}[- ]?)?\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telephoneNumber);
        return matcher.matches();
    }
}
