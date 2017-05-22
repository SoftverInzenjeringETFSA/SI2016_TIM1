package si.tim1.oglasi.viewmodels;

/**
 * Created by Dell on 20.5.2017..
 */
public class CategorySpecValueVM {

    private String value;
    private Long categorySpecId;
    private String categorySpecTitle;

    public CategorySpecValueVM() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getCategorySpecId() {
        return categorySpecId;
    }

    public void setCategorySpecId(Long categorySpecId) {
        this.categorySpecId = categorySpecId;
    }

    public String getCategorySpecTitle() {
        return categorySpecTitle;
    }

    public void setCategorySpecTitle(String categorySpecTitle) {
        this.categorySpecTitle = categorySpecTitle;
    }

}
