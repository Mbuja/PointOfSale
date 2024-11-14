package point.of.sale;

import org.junit.jupiter.api.Test;


import point.of.sale.Company;

import java.util.function.ToDoubleBiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest{
    Company company = new Company("CompanyABC","abc@mail.com","5 Nowell Street,Brakpan","+271112345678","655124568","A logistics company");

    @Test
    public void createNewCompanyTest(){

        assertNotNull(company);
        assertEquals("CompanyABC",company.getName());
        assertEquals("abc@mail.com",company.getEmail());
        assertEquals("5 Nowell Street,Brakpan",company.getAddress());
        assertEquals("+271112345678",company.getTelephoneNumber());
    }

    @Test
    public void validEmailTest(){
        String validMail = "emailito@valid.com";
        assertTrue(company.isEmailValid(validMail));
    }

    @Test
    public void invalidEmailTest(){
        String invalidMail = "email#to@valid.com";
        assertFalse(company.isEmailValid(invalidMail));
    }

    @Test
    public void setNameTest(){
        String name = company.getName();
        assertTrue(company.isValidName(name));
        assertFalse(company.isValidName(""));

    }

    @Test
    public void invalidPhoneNumberTest(){
        String telNo = "@90999899";
        assertFalse(company.isPhoneNumberValid( "@90999899"));
    }

    @Test
    public void validPhoneNumberTest(){
        System.out.println(company.getTelephoneNumber());

        assertTrue(company.isPhoneNumberValid(company.getTelephoneNumber()));
    }

    @Test
    public void longDescriptionTest() {
        String invalidDescription = "At [Your Company Name], we are dedicated to innovating solutions that empower businesses and individuals in a " +
                "rapidly changing digital world. Specializing in software development, data analytics," +
                " and scalable cloud services, we bridge technology with strategy to meet the evolving needs of our clients. " +
                "Our team of skilled professionals collaborates closely with partners across industries, " +
                "tailoring solutions to enhance productivity, drive sustainable growth, and foster digital transformation. " +
                "With a commitment to excellence, security, and customer satisfaction, " +
                "[Your Company Name] consistently delivers impactful results that redefine the possibilities of tomorrow.";

        assertFalse(company.isValidDescription(invalidDescription));
    }
    @Test
    public void validDescriptionTest(){
        assertTrue(company.isValidDescription(company.getDescription()));
    }

}