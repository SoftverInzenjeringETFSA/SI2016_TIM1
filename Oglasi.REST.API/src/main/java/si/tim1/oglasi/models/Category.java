package si.tim1.oglasi.models;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", targetEntity = Advert.class)
    private List<Advert> adverts = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", targetEntity = CategorySpec.class)
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
}
