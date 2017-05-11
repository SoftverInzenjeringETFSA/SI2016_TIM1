package si.tim1.oglasi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.tim1.oglasi.models.Category;
import si.tim1.oglasi.models.CategorySpec;
import si.tim1.oglasi.repositories.ICategoryRepository;
import si.tim1.oglasi.viewmodels.CategoryVM;

import javax.xml.rpc.ServiceException;

import java.util.List;

public class CategoryService extends BaseService<Category, ICategoryRepository> {

    @Autowired
    private ICategoryRepository categoryRepository;

    //Creating category

    public Boolean createCategory(CategoryVM category) throws ServiceException {

        //Check if name is unique if so create one
        if(categoryRepository.findByTitle(category.getTitle()) != null){
            throw new ServiceException("Category already exists!");
        }

        Category createdCategory = new Category(category.getTitle());

        //Check if category specs exist and create them

        List<CategorySpec> categorySpecs = category.getCategorySpecs();

        if(!categorySpecs.isEmpty()){

            List<CategorySpec> createdCategorySpecs = categorySpecs;

            if(createdCategory == null) throw new SecurityException("Failed to create category specs!");

            createdCategory.setCategorySpecs(createdCategorySpecs);

        }

        //Save created category and check if it is created

        Category createdC = categoryRepository.save(createdCategory);

        return createdC != null;

    }

    public Boolean addCategorySpec(CategoryVM category, CategorySpec categorySpec) throws ServiceException {

        //Check if category exists

        Category updatedCategory = categoryRepository.findByTitle(category.getTitle());

        if(updatedCategory == null){
            throw new ServiceException("Selected category doesn't exist!");
        }

        //Check if category spec doesn't exist

        List<CategorySpec> categorySpecList = category.getCategorySpecs();

        for (CategorySpec i : categorySpecList
             ) {

            if(categorySpec.getTitle().equals(categorySpec.getTitle()))
                throw new ServiceException("Category spec with selected name already exists");

        }

        categorySpecList.add(categorySpec);

        updatedCategory.setCategorySpecs(categorySpecList);

        Category updatedC = categoryRepository.save(updatedCategory);

        return updatedC != null;

    }

}
