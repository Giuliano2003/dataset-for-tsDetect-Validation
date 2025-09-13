
package ModelTest;

import mySimple.DAOImpl.UserDaoImpl;
import mySimple.Person;
import mySimple.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private UserDaoImpl userDAO;

    @BeforeEach
    void initTest() {
        this.userDAO = new UserDaoImpl();
    }


    @Test
    public void getIdTest() throws Exception {
        User steve = userDAO.getUserByEmail("steve@gmail.com");
        int expected = 1;
        int actual = steve.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getAgeTest() throws Exception {
        User steve = userDAO.getUserByEmail("steve@gmail.com");
        int expected = 15;
        int actual = steve.getAge();
        assertEquals(expected, actual);
    }
    @Test
    public void getNameTest() throws Exception {
        User steve = userDAO.getUserByEmail("steve@gmail.com");
        String expected = "steve";
        String actual = steve.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getPasswordTest() throws Exception {
        User steve = userDAO.getUserByEmail("steve@gmail.com");
        String expected = "steve123";
        String actual = steve.getPassword();
        assertEquals(expected, actual);
    }

    @Test
    public void getPESELTest() throws Exception {
        User steve = userDAO.getUserByEmail("steve@gmail.com");
        String expected = "95012615798";
        String actual = steve.getPESEL();
        assertEquals(expected, actual);
    }

    @Test
    public void getNIPTest() throws Exception {
        User steve = userDAO.getUserByEmail("steve@gmail.com");
        String expected = "1234567891";
        String actual = steve.getNIP();
        assertEquals(expected, actual);
    }

    @Test
    public void getId_shoppingCartTest() throws Exception {
        User steve = userDAO.getUserByEmail("steve@gmail.com");
        int expected = 1;
        int actual = steve.getId_shoppingCart();
        assertEquals(expected, actual);
    }


    @Test
    public void setAgeTest() throws Exception {
        Person steve = userDAO.getUserByEmail("steve@gmail.com");
        steve.setAge(30);
        int expected = 30;
        int actual = steve.getAge();
        assertEquals("Expected and actual age of user didn't match",expected, actual);
    }


    @Test
    public void setNameTest() throws Exception {
        Person steve = userDAO.getUserByEmail("steve@gmail.com");
        steve.setName("Peter");
        String expected = "Peter";
        String actual = steve.getName();
        assertEquals("Expected and actual name of user didn't match",expected, actual);
    }



    @Test
    public void setPasswordTest() throws Exception {
        User steve = userDAO.getUserByEmail("steve@gmail.com");
        String expected = "qwerty";
        steve.setPassword("qwerty");
        String actual = steve.getPassword();
        assertEquals("Expected and actual password didn't match",expected, actual);
    }

    
}
