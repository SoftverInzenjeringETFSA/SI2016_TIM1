package si.tim1.oglasi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.tim1.oglasi.models.Category;
import si.tim1.oglasi.models.CategorySpec;
import si.tim1.oglasi.repositories.ICategoryRepository;
import si.tim1.oglasi.viewmodels.CategoryVM;

import java.util.*;

/**
 * Created by Adnan on 5/5/2017.
 */
@Service
public class CategoryService extends BaseService<Category, ICategoryRepository> {

    @Autowired
    private ICategoryRepository categoryRepository;


    public Boolean createCategory(CategoryVM categoryVM){

        if (categoryVM == null || categoryVM.getValues() == null)
            return false;

        Category newCategory = new Category(categoryVM.getTitle());

        List<CategorySpec> myCategrySpecs = new ArrayList<CategorySpec>();
        for (String value:
              categoryVM.getValues()) {

            CategorySpec newCS = new CategorySpec(value);
            myCategrySpecs.add(newCS);
        }

        newCategory.setCategorySpecs(myCategrySpecs);

        Category success = categoryRepository.save(newCategory);
        return (success!=null);


    }

}
