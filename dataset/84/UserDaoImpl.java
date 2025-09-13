
package mySimple.DAOImpl;
import mySimple.DAO.UserDao;
import mySimple.User;
import java.util.Arrays;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private List<User> users;

    public UserDaoImpl() {
        this.users = Arrays.asList(
                new User(1,15, "steve", "steve@gmail.com", "steve123","95012615798","1234567891", 1),
                new User(2,24, "karen", "karen@gmail.com", "karen123","87012645798","7894567891", 2)
        );
    }

    @Override
    public User getUserByEmail(String email) throws Exception {
        return users.stream().filter(u -> u.getEmail().equals(email))
                .findAny().orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }
}
