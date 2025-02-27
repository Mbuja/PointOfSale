package point.of.sale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    Product product = new Product("1", "Chef's Special", "Combos", 89.0, "Egg roll,served with side of chips and juice", null, null);
    
    @Test
    public void createNewProductTest(){
        assertNotNull(product);
        assertEquals("1", product.getId());
        assertEquals("Chef's Special",product.getName());
        assertEquals("Combos",product.getCategory());
        assertEquals(89.0, product.getPrice());
    

    }  
    
    public void invalidDescriptionTest(){
        String invalidDescription = "At [Your Company Name], we are dedicated to innovating solutions that empower businesses and individuals in a " +
        "rapidly changing digital world. Specializing in software development, data analytics," +
        " and scalable cloud services, we bridge technology with strategy to meet the evolving needs of our clients. " +
        "Our team of skilled professionals collaborates closely with partners across industries, " +
        "tailoring solutions to enhance productivity, drive sustainable growth, and foster digital transformation. " +
        "With a commitment to excellence, security, and customer satisfaction, " +
        "[Your Company Name] consistently delivers impactful results that redefine the possibilities of tomorrow.";
        assertFalse(product.isValidDescription(invalidDescription));

    }
}
