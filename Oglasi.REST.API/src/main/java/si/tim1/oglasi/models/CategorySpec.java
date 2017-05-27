package si.tim1.oglasi.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adnan on 4/30/2017.
 */
@Entity
public class CategorySpec extends BaseEntityModel{
    private String title;

    public CategorySpec() {
        super();
    }

    public CategorySpec(String title) {
        super();
        setTitle(title);
    }

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categorySpec", targetEntity = CategorySpecValue.class, cascade = CascadeType.ALL)
    private List<CategorySpecValue> categorySpecValues = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<CategorySpecValue> getCategorySpecValues() {
        return categorySpecValues;
    }

    public void setCategorySpecValues(List<CategorySpecValue> categorySpecValues) {
        this.categorySpecValues = categorySpecValues;
    }

    public CategorySpec(String title, Category category) {
        this.title = title;
        this.category = category;
    }
}
