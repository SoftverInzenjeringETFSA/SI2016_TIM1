package si.tim1.oglasi.models;

import si.tim1.oglasi.viewmodels.CategorySpecValueVM;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by Adnan on 4/30/2017.
 */
@Entity
public class CategorySpecValue extends BaseEntityModel {

    private String value;

    @ManyToOne(targetEntity = Advert.class, fetch = FetchType.LAZY)
    private Advert advert;

    @ManyToOne(targetEntity = CategorySpec.class, fetch = FetchType.LAZY)
    private CategorySpec categorySpec;

    public CategorySpecValue() {
        super();
    }

    public CategorySpecValue(String value, CategorySpec categorySpec){
        super();
        setValue(value);
        setCategorySpec(categorySpec);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    public CategorySpec getCategorySpec() {
        return categorySpec;
    }

    public void setCategorySpec(CategorySpec categorySpec) {
        this.categorySpec = categorySpec;
    }

    public CategorySpecValueVM mapToViewModel(){
        CategorySpecValueVM categorySpecValueVM=new CategorySpecValueVM();

        categorySpecValueVM.setValue(getValue());
        categorySpecValueVM.setCategorySpecId(getCategorySpec().getId());
        categorySpecValueVM.setCategorySpecTitle(getCategorySpec().getTitle());

        return categorySpecValueVM;
    }


}
