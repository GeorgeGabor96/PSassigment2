package Shop.Model.Services;

import Shop.Model.Entities.Category;
import Shop.Model.Entities.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    void deleteProduct(Integer id);

    void deleteProduct(String name);

    void createProduct(Product product);
}
