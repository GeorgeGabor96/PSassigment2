package Shop.Control;

import Shop.Model.Entities.Category;
import Shop.Model.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    @Qualifier(value = "categoryServiceImp")
    private CategoryService categoryService;

    @RequestMapping("/User")
    public List<Category> returnHierarchy()
    {
        List<Category> categories = categoryService.getCategoryHierarchy();
        System.out.println(categories.size());
        return categories;
    }


}
