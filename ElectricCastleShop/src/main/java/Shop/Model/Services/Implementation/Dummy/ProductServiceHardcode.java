package Shop.Model.Services.Implementation.Dummy;

import Shop.Model.Entities.Category;
import Shop.Model.Entities.Product;
import Shop.Model.Services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceHardcode implements ProductService {

    @Override
    public void deleteProduct(Integer id) {
        List<Category> categories = CategoryServiceHardcode.getCategories();

        for (Category category: categories)
        {
            List<Product> products = category.getProducts();
            for (Product product: products) {
                if (product.getId() == id) {
                    products.remove(product);
                    System.out.println(product);
                }
            }
            deleteProduct(category, id);
        }
    }

    private void deleteProduct(Category category, int id)
    {
        List<Category> subcategories = category.getSubcategories();
        for (Category subcategory: subcategories)
        {
            List<Product> products = subcategory.getProducts();
            for (Product product: products) {
                if (product.getId() == id) {
                    products.remove(product);
                    System.out.println(product);
                }
            }
            deleteProduct(subcategory, id);
        }
    }


    @Override
    public void deleteProduct(String name) {
        List<Category> categories = CategoryServiceHardcode.getCategories();

        for (Category category: categories)
        {
            List<Product> products = category.getProducts();
            for (Product product: products) {
                if (product.getName().equals(name)) {
                    products.remove(product);
                }
            }
            deleteProduct(category, name);
        }
    }

    private void deleteProduct(Category category, String name)
    {
        List<Category> subcategories = category.getSubcategories();
        for (Category subcategory: subcategories)
        {
            List<Product> products = subcategory.getProducts();
            for (Product product: products) {
                if (product.getName().equals(name)) {
                    products.remove(product);
                }
            }
            deleteProduct(subcategory, name);
        }
    }


    @Override
    public void createProduct(Product product) {
        List<Category> categories = CategoryServiceHardcode.getCategories();

        for (Category subcategory: categories)
        {
            if (subcategory.getName().equals(product.getCategory().getName()))
            {
                subcategory.getProducts().add(product);
                break;
            }
            createProduct(subcategory, product);
        }
    }

    public void createProduct(Category category, Product product)
    {
        List<Category> categories = category.getSubcategories();

        for (Category subcategory: categories)
        {
            if (subcategory.getName().equals(product.getCategory().getName()))
            {
                subcategory.getProducts().add(product);
                break;
            }
            createProduct(subcategory, product);
        }
    }
}
