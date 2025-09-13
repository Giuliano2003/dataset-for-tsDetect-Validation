package DaoTest;

import mySimple.DAOImpl.ProductDaoImpl;
import mySimple.DAOImpl.ShoppingCartDaoImpl;
import mySimple.Product;
import mySimple.ShoppingCart;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartDaoTest {

    private ShoppingCartDaoImpl shoppingCartDao;

    @BeforeEach
    public void initTest(){
        this.shoppingCartDao = new ShoppingCartDaoImpl();
    }

    @AfterEach
    public void tearDown(){
        shoppingCartDao = null;
    }

    @Test
    public void getShoppingCartByIdTest() throws Exception {
        ShoppingCart shoppingCart = shoppingCartDao.getShoppingCartById(1);
        assertThat(shoppingCart).isNotNull();
        assertThat(shoppingCart.getId()).isEqualTo(1);
    }
}