package si.tim1.oglasi.models;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2RTFDTM;
import si.tim1.oglasi.viewmodels.CategoryVM;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adnan on 4/30/2017.
 */
@Entity
public class Category extends BaseEntityModel {
    private String title;

    public Category(){
        super();
    }

    public Category(String title, List<CategorySpec> categorySpecs) {
        super();
        setTitle(title);
        setCategorySpecs(categorySpecs);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", targetEntity = Advert.class)
    private List<Advert> adverts = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", targetEntity = CategorySpec.class, cascade = CascadeType.ALL)
    private List<CategorySpec> categorySpecs = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CategorySpec> getCategorySpecs() {
        return categorySpecs;
    }

    public void setCategorySpecs(List<CategorySpec> categorySpecs) {
        this.categorySpecs = categorySpecs;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    public Category(String title) {
        this.title = title;
    }

    public CategoryVM mapToViewModel(){
        CategoryVM categoryVM=new CategoryVM();

        categoryVM.setId(getId());
        categoryVM.setTitle(getTitle());
        List<String> values=new ArrayList<>();
        List<Long> valuesId=new ArrayList<>();
        for(CategorySpec cs:categorySpecs){
            valuesId.add(cs.getId());
            values.add(cs.getTitle());
        }
        categoryVM.setValues(values);
        categoryVM.setValuesId(valuesId);

        return categoryVM;
    }
}
