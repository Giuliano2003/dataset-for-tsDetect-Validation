
package DaoTest;

import mySimple.DAOImpl.ProductDaoImpl;
import mySimple.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


/*https://github.com/KarynaAliushkevich14/university_junit/blob/main/src/test/java/DaoTest/ProductDaoTest.java */
import static org.assertj.core.api.Assertions.assertThat;

public class ProductDaoTest {

    private ProductDaoImpl productDao;

    @BeforeEach
    void initTest(){
        this.productDao = new ProductDaoImpl();
    }


    @Test
    public void getProductByIdTest() throws Exception {
        Product laptop = productDao.getProductById(2);
        assertThat(laptop).isNotNull();
        assertThat(laptop.getId()).isEqualTo(2);
    }

    @Test
    public void findAllProductsTest() throws Exception {
        List<Product> allProducts = productDao.findAllProducts();
        assertThat(allProducts.get(1)).isEqualToComparingFieldByField(
                new Product(2, "Laptop", "Used laptop. 50% of price.", 2)
        );

        assertThat(allProducts).contains(new Product(2, "Laptop", "Used laptop. 50% of price.", 2));
    }
}
