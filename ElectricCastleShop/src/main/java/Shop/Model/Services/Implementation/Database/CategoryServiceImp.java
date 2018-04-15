package Shop.Model.Services.Implementation.Database;

import Shop.Model.Entities.Category;
import Shop.Model.Repositories.CategoryRepository;
import Shop.Model.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategoryHierarchy() {
        List<Category> categories = new ArrayList<>();
        Iterable<Category> resultCategories = categoryRepository.findAll();

        for(Category category: resultCategories)
        {
            if (category.getParent() == null)
            {
                categories.add(category);
            }
        }

        return categories;
    }


    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteCategory(String name) {
        categoryRepository.deleteCategoriesByName(name);
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
}
