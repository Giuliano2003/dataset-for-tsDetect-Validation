package DaoTest;

import mySimple.DAOImpl.UserDaoImpl;
import mySimple.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/* https://github.com/KarynaAliushkevich14/university_junit/blob/main/src/test/java/DaoTest/UserDaoTest.java*/

public class UserDaoTest {

    private UserDaoImpl userDAO;

    @BeforeEach
    void initTest(){
        this.userDAO = new UserDaoImpl();
    }


    @Test
    public void getUserByEmailTest() throws Exception {
        User steve = userDAO.getUserByEmail("steve@gmail.com");
        assertThat(steve).isNotNull();
        assertThat(steve.getEmail()).isEqualTo("steve@gmail.com");
    }

    @Test
    public void getUserByEmail_dont_exist() throws Exception {
        User alex = userDAO.getUserByEmail("alex@gmail.com");
        assertThat(alex).isNull();
    }

    @Test
    public void findAllUsersTest() throws Exception {
        List<User> allUsers = userDAO.findAllUsers();
        assertThat(allUsers.get(0)).isEqualToComparingFieldByField(
                new User(1, 15, "steve", "steve@gmail.com", "steve123","95012615798","1234567891", 1)
        );

        assertThat(allUsers).contains(new User(1, 15, "steve", "steve@gmail.com", "steve123","95012615798","1234567891", 1));
    }

}