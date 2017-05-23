package si.tim1.oglasi.viewmodels;

import java.util.List;

/**
 * Created by Siii on 5/21/2017.
 */
public class CategoryVM {

    private Long id;
    private String title;
    private List<String> values;
    private List<Long> valuesId;

    public CategoryVM(String title, List<String> values) {
        this.title = title;
        this.values = values;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getValues() {
        return values;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryVM(Long id, String title, List<String> values) {
        this.id = id;
        this.title = title;
        this.values = values;
    }

    public CategoryVM() {
    }

    public List<Long> getValuesId() {
        return valuesId;
    }

    public void setValuesId(List<Long> valuesId) {
        this.valuesId = valuesId;
    }
}
