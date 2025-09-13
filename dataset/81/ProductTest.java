
package ModelTest;

import mySimple.DAO.ProductDao;
import mySimple.DAOImpl.ProductDaoImpl;
import mySimple.DAOImpl.UserDaoImpl;
import mySimple.Product;
import mySimple.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/*https://github.com/KarynaAliushkevich14/university_junit/blob/main/src/test/java/ModelTest/ProductTest.java */

public class ProductTest {
    private ProductDaoImpl productDAO;

    @BeforeEach
    void initTest() {
        this.productDAO = new ProductDaoImpl();
    }


    @Test
    public void getIdTest() throws Exception {
        Product laptop = productDAO.getProductById(2);
        int expected = 2;
        int actual = laptop.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getTitleTest() throws Exception {
        Product laptop = productDAO.getProductById(2);
        String expected = "Laptop";
        String actual = laptop.getTitle();
        assertEquals(expected, actual);
    }


    @Test
    public void setId_userTest() throws Exception {
        Product laptop = productDAO.getProductById(2);
        laptop.setId_user(4);
        final Field field = laptop.getClass().getDeclaredField("id_user");
        field.setAccessible(true);
        assertEquals("Expected and actual id of user didn't match",4, field.get(laptop));
    }
}
