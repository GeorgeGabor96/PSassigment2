package Shop.Control;

import Shop.Model.Entities.Category;
import Shop.Model.Entities.Product;
import Shop.Model.Services.CategoryService;
import Shop.Model.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    @Qualifier(value = "categoryServiceImp")
    private CategoryService categoryService;

    @Autowired
    @Qualifier(value = "productServiceImp")
    private ProductService productService;

    @RequestMapping("/User")
    public ModelAndView returnHierarchyAllProducts()
    {
        List<Category> categories = categoryService.getCategoryHierarchy();
        List<Product> products = productService.getProductsWithParent(categories, -1);

        ModelAndView modelAndView = new ModelAndView("user", "categories", categories);
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @RequestMapping("/User/{id}")
    public ModelAndView returnHierarchySpecificProducts(@PathVariable Integer id)
    {
        List<Category> categories = categoryService.getCategoryHierarchy();
        List<Product> products = productService.getProductsWithParent(categories, id);

        ModelAndView modelAndView = new ModelAndView("user", "categories", categories);
        modelAndView.addObject("products", products);

        return modelAndView;
    }

}
