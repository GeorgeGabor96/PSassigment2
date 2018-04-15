package Shop.Control;

import Shop.Model.Entities.Category;
import Shop.Model.Entities.Product;
import Shop.Model.Services.CategoryService;
import Shop.Model.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    @Qualifier(value = "productServiceImp")
    private ProductService productService;

    @Autowired
    @Qualifier(value = "categoryServiceImp")
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.DELETE, value = "/Admin/CategoryId/{id}")
    public String deleteCategory(@PathVariable Integer id)
    {
        categoryService.deleteCategory(id);
        return "Category deleted";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Admin/CategoryName/{name}")
    public String deleteCategory(@PathVariable String name)
    {
        categoryService.deleteCategory(name);
        return "Category deleted";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Admin/Category")
    public String createCategory(@RequestBody Category category)
    {
        categoryService.createCategory(category);
        return "Category added";
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/Admin/ProductId/{id}")
    public String deleteProduct(@PathVariable Integer id)
    {
        productService.deleteProduct(id);
        return "Product deleted";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Admin/ProductName/{name}")
    public String deleteProduct(@PathVariable String name)
    {
        productService.deleteProduct(name);
        return "Product deleted";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Admin/Product")
    public String deleteProduct(@RequestBody Product product)
    {
        productService.createProduct(product);
        return "Product added";
    }
}
