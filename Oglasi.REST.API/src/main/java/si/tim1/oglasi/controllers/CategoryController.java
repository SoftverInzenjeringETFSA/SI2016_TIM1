package si.tim1.oglasi.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import si.tim1.oglasi.models.Category;
import si.tim1.oglasi.services.CategoryService;
import si.tim1.oglasi.viewmodels.CategoryVM;

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


}
