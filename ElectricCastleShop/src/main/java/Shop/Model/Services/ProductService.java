package Shop.Model.Services;

import Shop.Model.Entities.Category;
import Shop.Model.Entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getProductsWithParent(List<Category> categories, int id);

    void deleteProduct(Integer id);

    void deleteProduct(String name);

    void createProduct(Product product);
}
