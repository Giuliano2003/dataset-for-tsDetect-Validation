
package mySimple.DAOImpl;

import mySimple.DAO.ProductDao;
import mySimple.DAO.ShoppingCartDao;
import mySimple.Product;
import mySimple.ShoppingCart;

import java.util.Arrays;
import java.util.List;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

    private List<ShoppingCart> shoppingCarts;

    public ShoppingCartDaoImpl() {
        this.shoppingCarts = Arrays.asList(
                new ShoppingCart(1, 1, 2,1)
        );
    }

    @Override
    public ShoppingCart getShoppingCartById (int id) throws Exception {
        return shoppingCarts.stream().filter(s -> s.getId()==id)
                .findAny().orElse(null);
    }
}
