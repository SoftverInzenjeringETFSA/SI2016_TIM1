package si.tim1.oglasi.models;

import si.tim1.oglasi.viewmodels.AdvertVM;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Adnan on 4/29/2017.
 */
@Entity
public class Advert extends BaseEntityModel {

    private String title;
    private String description;
    private Boolean isPrioritized;
    private Boolean isContactShared;
    private Date creationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "advert", targetEntity = CategorySpecValue.class)
    private List<CategorySpecValue> categorySpecValues = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "advert", targetEntity = InappropriateAdvertReport.class)
    private List<InappropriateAdvertReport> inappropriateAdvertReports = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "advert", targetEntity = AdvertSubscription.class)
    private List<AdvertSubscription> advertSubscriptions = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
    private UserAccount owner;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
    private Category category;

    public Advert() {}

    public Advert(String title, String description, Boolean isPrioritized, Boolean isContactShared, Date creationDate) {
        this.title = title;
        this.description = description;
        this.isPrioritized = isPrioritized;
        this.isContactShared = isContactShared;
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

    public Boolean getPrioritized() {
        return isPrioritized;
    }

    public void setPrioritized(Boolean prioritized) {
        isPrioritized = prioritized;
    }

    public Boolean getContactShared() {
        return isContactShared;
    }

    public void setContactShared(Boolean contactShared) {
        isContactShared = contactShared;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<CategorySpecValue> getCategorySpecValues() {
        return categorySpecValues;
    }

    public void setCategorySpecValues(List<CategorySpecValue> categorySpecValues) {
        this.categorySpecValues = categorySpecValues;
    }

    public List<InappropriateAdvertReport> getInappropriateAdvertReports() {
        return inappropriateAdvertReports;
    }

    public void setInappropriateAdvertReports(List<InappropriateAdvertReport> inappropriateAdvertReports) {
        this.inappropriateAdvertReports = inappropriateAdvertReports;
    }

    public List<AdvertSubscription> getAdvertSubscriptions() {
        return advertSubscriptions;
    }

    public void setAdvertSubscriptions(List<AdvertSubscription> advertSubscriptions) {
        this.advertSubscriptions = advertSubscriptions;
    }

    public UserAccount getOwner() {
        return owner;
    }

    public void setOwner(UserAccount owner) {
        this.owner = owner;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Tampered by Amer
     */
    public AdvertVM mapToViewModel(){
        return new AdvertVM(this.getId(), title, description, category.getTitle(), category.getId(), owner.getUsername(), owner.getId(), creationDate.toString());
    }

}
