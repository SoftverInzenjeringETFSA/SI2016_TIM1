package si.tim1.oglasi.viewmodels;

import si.tim1.oglasi.models.Advert;
import si.tim1.oglasi.models.CategorySpec;

import java.util.ArrayList;
import java.util.List;

public class CategoryVM {

    private String title;
    private List<Advert> adverts = new ArrayList<>();
    private List<CategorySpec> categorySpecs = new ArrayList<>();


    public CategoryVM(String title){
        this.title = title;
    }

    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}
    public List<CategorySpec> getCategorySpecs() {
        return categorySpecs;
    }
    public List<Advert> getAdverts() {
        return adverts;
    }

}