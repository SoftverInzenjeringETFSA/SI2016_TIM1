package si.tim1.oglasi.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.tim1.oglasi.models.Category;
import si.tim1.oglasi.services.CategoryService;
import si.tim1.oglasi.viewmodels.CategoryVM;

import java.util.List;

/**
 * Created by Adnan on 5/5/2017.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {


    private CategoryService categoryService;

    @Autowired
    public void setService (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createCategory(@RequestBody CategoryVM myCategory) {

        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(categoryService.createCategory(myCategory));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }

    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<CategoryVM> getCategories() {
        return categoryService.getCategories();
    }


    @RequestMapping(value = "/get/{categoryId}", method = RequestMethod.GET) // deletedvert oglasa
    public CategoryVM  getOneCategory(@PathVariable("categoryId") Long categoryId) {
        try {
            return categoryService.getCategory(categoryId);
        }
        catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/delete/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity deleteCategory(@PathVariable("categoryId") Long categoryId) {
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(categoryService.deleteCategory(categoryId));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }
    }

}
