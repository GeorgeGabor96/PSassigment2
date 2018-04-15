package Shop.Model.Services;


import Shop.Model.Entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> getCategoryHierarchy();

    void deleteCategory(Integer id);

    void deleteCategory(String name);

    void createCategory(Category category);
}
