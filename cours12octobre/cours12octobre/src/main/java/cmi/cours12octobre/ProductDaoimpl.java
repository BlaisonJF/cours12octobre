import java.util.List;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao {
public static List<Product> products = new ArrayList<>();
static {
    products.add(new Product( code 0, designation "Tablette", prix: 120));
    products.add(new Product( code 1, designation "Ordi", prix: 120));
    products.add(new Product( code 2, designation "Switch", prix: 120));
    products.add(new Product( code 3, designation "Routeur", prix: 120));
}
       @Override
        public List<Product> findAll() {
            return products;
       }

       @Override
        public Product findById(int code) {
            return products.get(code)
       }

       @Override
        public Product save(Product product) {
            products.add(product);
            return product;
       }
}