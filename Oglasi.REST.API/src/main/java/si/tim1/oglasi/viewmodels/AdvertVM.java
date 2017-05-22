package si.tim1.oglasi.viewmodels;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by amer on 5/9/17.
 */
public class AdvertVM {

    private Long id;
    private String title;
    private String description;
    private Boolean prioritized;
    private Boolean contactShared;
    private Long categoryId;
    private String categoryTitle;
    private Long ownerId;
    private String ownerName;
    private Date creationDate;
    private List<CategorySpecValueVM> categorySpecValues=new ArrayList<>();

    public AdvertVM(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getPrioritized() {
        return prioritized;
    }

    public void setPrioritized(Boolean prioritized) {
        this.prioritized = prioritized;
    }

    public Boolean getContactShared() {
        return contactShared;
    }

    public void setContactShared(Boolean contactShared) {
        this.contactShared = contactShared;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<CategorySpecValueVM> getCategorySpecValues() {
        return categorySpecValues;
    }

    public void setCategorySpecValues(List<CategorySpecValueVM> categorySpecValues) {
        this.categorySpecValues = categorySpecValues;
    }
}
