package Shop.Model.Services.Implementation.Database;

import Shop.Model.Entities.Product;
import Shop.Model.Repositories.ProductRepository;
import Shop.Model.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImp implements ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteProduct(String name) {
        productRepository.deleteProductByName(name);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }


}
