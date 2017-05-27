package si.tim1.oglasi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.tim1.oglasi.models.Advert;
import si.tim1.oglasi.models.Category;
import si.tim1.oglasi.models.CategorySpec;
import si.tim1.oglasi.repositories.IAdvertRepository;
import si.tim1.oglasi.repositories.ICategoryRepository;
import si.tim1.oglasi.repositories.ICategorySpecRepository;
import si.tim1.oglasi.viewmodels.CategoryVM;

import javax.swing.text.StyledEditorKit;
import java.util.*;

/**
 * Created by Adnan on 5/5/2017.
 */
@Service
public class CategoryService extends BaseService<Category, ICategoryRepository> {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IAdvertRepository iAdvertRepository;

    @Autowired
    private ICategorySpecRepository iCategorySpecRepository;


    public Boolean createCategory(CategoryVM categoryVM){

        if (categoryVM == null || categoryVM.getValues() == null)
            return false;

        Category newCategory = new Category(categoryVM.getTitle());
        categoryRepository.save(newCategory);
        List<CategorySpec> myCategrySpecs = new ArrayList<CategorySpec>();
        for (String value:
              categoryVM.getValues()) {

            CategorySpec newCS = new CategorySpec(value);
            newCS.setCategory(newCategory);

            newCS = iCategorySpecRepository.save(newCS);

            myCategrySpecs.add(newCS);

        }

        newCategory.setCategorySpecs(myCategrySpecs);

        Category success = categoryRepository.save(newCategory);
        return (success!=null);

    }

    public List<CategoryVM> getCategories(){
        Iterable<Category> categories=findAll();
        List<CategoryVM> categoriesVM=new ArrayList<>();

        for(Category c:categories){
            categoriesVM.add(c.mapToViewModel());
        }

        return categoriesVM;
    }

    public CategoryVM getCategory(Long id)
    {
        Category myCategory = categoryRepository.findCategoryById(id);

        if(myCategory != null){
            List<String> mySpecs = new ArrayList<>();
            List<Long> ids = new ArrayList<>();

            for (CategorySpec cs :myCategory.getCategorySpecs()){
                mySpecs.add(cs.getTitle());
                ids.add(cs.getId());
            }

            CategoryVM myCategoryVM = new CategoryVM(myCategory.getId(), myCategory.getTitle(), mySpecs);
            myCategoryVM.setValuesId(ids);

            return myCategoryVM;
        }


        return null;
    }

    public Boolean deleteCategory(Long id)
    {
        Category category = categoryRepository.findCategoryById(id);

        if(category == null){
            return false;
        }

        //ako vec postoje neki oglasi u ovoj kategoriji, ne moze se obrisati

//        Iterable<Advert> myAdverts = new ArrayList<>();
//
//        myAdverts = iAdvertRepository.findAdvertsByCategoryId(id);
//
//        if(myAdverts.spliterator().getExactSizeIfKnown() == 0)
//            return false;



        categoryRepository.delete(id);

        return true;
    }

}
