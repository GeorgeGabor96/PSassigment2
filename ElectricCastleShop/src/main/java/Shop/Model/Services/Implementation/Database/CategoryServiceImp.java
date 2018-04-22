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
                addSubcategories(categories, category.getSubcategories(), 1);
            }
        }

        return categories;
    }

    private String getPadding(int level)
    {
        StringBuilder padding = new StringBuilder();
        for (int i = 0; i < level; ++i)
        {
            padding.append("    ");
        }
        return padding.toString();
    }

    private void addSubcategories(List<Category> categories, List<Category> subcategories, int level)
    {
        if (null == subcategories)
        {
            return;
        }
        for (Category category: subcategories)
        {
            String padding = getPadding(level);
            category.setName(padding + category.getName());
            categories.add(category);
            addSubcategories(categories, category.getSubcategories(), level + 1);
        }
    }

    @Override
    public void deleteCategory(Integer id) {
        try {
            categoryRepository.deleteById(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(String name) {
        categoryRepository.deleteCategoriesByName(name);
    }

    @Override
    public void createCategory(Category category) {
        try {
            categoryRepository.save(category);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
