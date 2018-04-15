package Shop.Model.Services.Implementation.Dummy;

import Shop.Model.Entities.Category;
import Shop.Model.Entities.Product;
import Shop.Model.Services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceHardcode implements CategoryService {

    private static List<Category> categories = new ArrayList<>();

    public static List<Category> getCategories()
    {
        return categories;
    }

    public CategoryServiceHardcode()
    {
        Category category1 = new Category("haine");
        category1.setId(1);

        Category category2 = new Category("Pantaloni");
        category2.setId(2);

        Category category3 = new Category("Tricouri");
        category3.setId(3);

        Category category4 = new Category("Accesorii");
        category4.setId(4);

        category1.getSubcategories().add(category2);
        category2.setParent(category1);
        category1.getSubcategories().add(category3);
        category3.setParent(category1);

        Product product1 = new Product("Pantaloni Lungi", 100);
        product1.setId(1);
        product1.setCategory(category2);
        category2.getProducts().add(product1);

        Product product2 = new Product("Pantaloni Scurti", 200);
        product2.setId(2);
        product2.setCategory(category2);
        category2.getProducts().add(product2);

        Product product3 = new Product("Tricou cu guler", 50);
        product3.setId(3);
        product3.setCategory(category3);
        category3.getProducts().add(product3);

        Product product4 = new Product("Lant de aur", 1000);
        product4.setId(4);
        product4.setCategory(category4);
        category4.getProducts().add(product4);

        categories.add(category1);
        categories.add(category4);
    }

    @Override
    public List<Category> getCategoryHierarchy() {
        return categories;
    }


    @Override
    public void deleteCategory(Integer id) {
        List<Category> categories = CategoryServiceHardcode.getCategories();

        for (Category category: categories)
        {
            if (category.getId() == id)
            {
                categories.remove(category);
            }
            else
            {
                deleteCategory(category, id);
            }
        }
    }

    private void deleteCategory(Category category, int id)
    {
        List<Category> subcategories = category.getSubcategories();
        for (Category subcategory: subcategories)
        {
            if (subcategory.getId() == id)
            {
                subcategories.remove(subcategory);
            }
            else
            {
                deleteCategory(subcategory, id);
            }
        }
    }


    @Override
    public void deleteCategory(String name) {
        List<Category> categories = CategoryServiceHardcode.getCategories();

        for (Category category: categories)
        {
            if (category.getName().equals(name))
            {
                categories.remove(category);
            }
            else
            {
                deleteCategory(category, name);
            }
        }
    }

    private void deleteCategory(Category category, String name)
    {
        List<Category> subcategories = category.getSubcategories();
        for (Category subcategory: subcategories)
        {
            if (subcategory.getName().equals(name))
            {
                subcategories.remove(subcategory);
            }
            else
            {
                deleteCategory(subcategory, name);
            }
        }
    }


    @Override
    public void createCategory(Category category) {
        List<Category> categories = CategoryServiceHardcode.getCategories();

        for (Category subcategory: categories)
        {
            if (subcategory.getName().equals(category.getParent().getName()))
            {
                subcategory.getSubcategories().add(category);
                break;
            }
            createCategory(subcategory, category);
        }
    }

    public void createCategory(Category category, Category newCategory)
    {
        List<Category> categories = category.getSubcategories();

        for (Category subcategory: categories)
        {
            if (subcategory.getName().equals(newCategory.getParent().getName()))
            {
                subcategory.getSubcategories().add(newCategory);
                break;
            }
            createCategory(subcategory, newCategory);
        }
    }
}
