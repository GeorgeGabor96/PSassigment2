package Shop.Model.Services.Implementation.Database;

import Shop.Model.Entities.Category;
import Shop.Model.Entities.Product;
import Shop.Model.Repositories.ProductRepository;
import Shop.Model.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImp implements ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductsWithParent(List<Category> categories, int id) {
        List<Product> products = new ArrayList<>();

        for (Category category: categories)
        {
            if (category.getParent() == null) {
                findParentCategory(category, products, id);
                if (products.size() != 0 && id != -1) {
                    break;
                }
            }
        }

        return products;
    }


    private void findParentCategory(Category category, List<Product> products, int id)
    {
        if (category.getId() == id || id == -1)
        {
            for (Product product: category.getProducts())
            {
                products.add(product);
            }
            addProducts(category.getSubcategories(), products);
        }
        else if (null != category.getSubcategories())
        {
            for (Category subcategory: category.getSubcategories())
            {
                findParentCategory(subcategory, products, id);
            }
        }
    }

    private void addProducts(List<Category> categories, List<Product> products)
    {
        if (categories == null)
        {
            return;
        }
        for (Category category: categories)
        {
            if (category.getProducts() != null)
            {
                for (Product product: category.getProducts())
                {
                    products.add(product);
                }
            }
            addProducts(category.getSubcategories(), products);
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        try
        {
            productRepository.deleteById(id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(String name) {
        productRepository.deleteProductByName(name);
    }

    @Override
    public void createProduct(Product product) {
        try {
            productRepository.save(product);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
