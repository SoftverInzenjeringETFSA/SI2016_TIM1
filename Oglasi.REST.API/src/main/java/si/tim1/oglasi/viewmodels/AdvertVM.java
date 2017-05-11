package si.tim1.oglasi.viewmodels;

import java.util.Date;

/**
 * Created by amer on 5/9/17.
 */
public class AdvertVM {

    private long advertID;
    private String title;
    private String description;
    private long categoryID;
    private String category;
    private String owner;
    private long ownerID;
    private String creationDate;

    public AdvertVM(){};

    public AdvertVM(long advertID, String title, String description, String category, long categoryID, String owner, long ownerID, String creationDate){
        this.advertID = advertID;
        this.title = title;
        this.description = description;
        this.category = category;
        this.categoryID = categoryID;
        this.owner = owner;
        this.ownerID = ownerID;
        this.creationDate = creationDate;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public long getAdvertID() {
        return advertID;
    }

    public void setAdvertID(long advertID) {
        this.advertID = advertID;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
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
