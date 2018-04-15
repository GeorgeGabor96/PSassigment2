package Shop.Model.Repositories;

import Shop.Model.Entities.Product;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Transactional
    void deleteProductByName(String name);
}
