package mySimple.DAOImpl;

import mySimple.DAO.ProductDao;
import mySimple.Product;
import java.util.Arrays;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private List<Product> products;

    public ProductDaoImpl() {
        this.products = Arrays.asList(
                new Product(1, "Lamp", "Very good new lamp!", 1),
                new Product(2, "Laptop", "Used laptop. 50% of price.", 2)
        );
    }

    @Override
    public Product getProductById (int id) throws Exception {
        return products.stream().filter(product -> product.getId()==id)
                .findAny().orElse(null);
    }

    @Override
    public List<Product> findAllProducts() {
        return products;
    }
}