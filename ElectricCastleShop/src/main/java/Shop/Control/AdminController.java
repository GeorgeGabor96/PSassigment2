package Shop.Control;

import Shop.Model.Entities.Category;
import Shop.Model.Entities.Product;
import Shop.Model.Services.CategoryService;
import Shop.Model.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    @Qualifier(value = "productServiceImp")
    private ProductService productService;

    @Autowired
    @Qualifier(value = "categoryServiceImp")
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "/Admin/CategoryDelete")
    public ModelAndView getAll8()
    {
        return getModelAndView("adminDeleteCategory", -1);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Admin/CategoryDelete/{id}")
    public ModelAndView getAll9(@PathVariable Integer id)
    {
        return getModelAndView("adminDeleteCategory", id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Admin/CategoryDelete")
    public ModelAndView deleteCategory(@RequestParam("id") Integer id)
    {
        categoryService.deleteCategory(id);
        return getModelAndView("adminDeleteCategory", -1);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/Admin/CategoryName/{name}")
    public String deleteCategory(@PathVariable String name)
    {
        categoryService.deleteCategory(name);
        return "Category deleted";
    }



    @RequestMapping(method = RequestMethod.GET, value = "/Admin/Category")
    public ModelAndView getAll2()
    {
        return getModelAndView("adminCategory", -1);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Admin/Category/{id}")
    public ModelAndView getAll3(@PathVariable Integer id)
    {
        return getModelAndView("adminCategory", id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Admin/Category")
    public ModelAndView createCategory(@RequestParam("name") String name, @RequestParam("parent") Integer parent)
    {
        Category category = new Category();
        category.setName(name);
        Category parentCategory = new Category();
        parentCategory.setId(parent);
        category.setParent(parentCategory);

        categoryService.createCategory(category);

        ModelAndView modelAndView = getModelAndView("adminCategory", -1);

        return modelAndView;
    }



    @RequestMapping(method = RequestMethod.GET, value = "/Admin/ProductDelete")
    public ModelAndView getAll6()
    {
        return getModelAndView("adminDeleteProduct", -1);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Admin/ProductDelete/{id}")
    public ModelAndView getAll7(@PathVariable Integer id)
    {
        return getModelAndView("adminDeleteProduct", id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Admin/ProductDelete")
    public ModelAndView deleteProduct(@RequestParam("id") Integer id)
    {
        productService.deleteProduct(id);
        return getModelAndView("adminDeleteProduct", -1);
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/Admin/ProductName/{name}")
    public String deleteProduct(@PathVariable String name)
    {
        productService.deleteProduct(name);
        return "Product deleted";
    }



    @RequestMapping(method = RequestMethod.GET, value = "/Admin/Product")
    public ModelAndView getAll4()
    {
        return getModelAndView("adminProduct", -1);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Admin/Product/{id}")
    public ModelAndView getAll5(@PathVariable Integer id)
    {
        return getModelAndView("adminProduct", id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Admin/Product")
    public ModelAndView createProduct(@RequestParam("name") String name, @RequestParam("price") Integer price, @RequestParam("parent") Integer parent)
    {
        Category parentCategory = new Category();
        parentCategory.setId(parent);

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(parentCategory);
        productService.createProduct(product);

        ModelAndView modelAndView = getModelAndView("adminProduct", -1);

        return modelAndView;
    }

    private ModelAndView getModelAndView(String viewName, int id)
    {
        List<Category> categories = categoryService.getCategoryHierarchy();
        List<Product> products = productService.getProductsWithParent(categories, id);

        ModelAndView modelAndView = new ModelAndView(viewName, "categories", categories);
        modelAndView.addObject("products", products);

        return modelAndView;
    }
}
