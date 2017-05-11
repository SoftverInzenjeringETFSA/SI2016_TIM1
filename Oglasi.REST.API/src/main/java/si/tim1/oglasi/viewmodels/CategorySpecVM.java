package si.tim1.oglasi.viewmodels;

import si.tim1.oglasi.models.CategorySpecValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infloop on 5/11/17.
 */
public class CategorySpecVM {
    private String title;
    private List<CategorySpecValue> categorySpecValues = new ArrayList<>();

    public String getTitle() {
        return title;
    }
    public List<CategorySpecValue> getCategorySpecValues(){return categorySpecValues;}
}
