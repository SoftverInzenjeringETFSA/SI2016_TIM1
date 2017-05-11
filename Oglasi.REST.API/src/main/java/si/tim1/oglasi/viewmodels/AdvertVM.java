package si.tim1.oglasi.viewmodels;

import java.util.Date;

/**
 * Created by amer on 5/9/17.
 */
public class AdvertVM {

    private String title;
    private String description;
    private String category;
    private String owner;
    private String creationDate;

    public AdvertVM(){}

    public AdvertVM(String title, String description, String category, String owner, String creationDate){
        this.title = title;
        this.description = description;
        this.category = category;
        this.owner = owner;
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
