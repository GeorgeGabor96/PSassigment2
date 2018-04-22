package Shop.Model.Repositories;

import Shop.Model.Entities.Category;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Transactional
    void deleteCategoriesByName(String name);
}
