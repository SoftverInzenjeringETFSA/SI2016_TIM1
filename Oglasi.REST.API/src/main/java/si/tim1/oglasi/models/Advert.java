package si.tim1.oglasi.models;

import si.tim1.oglasi.viewmodels.AdvertVM;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
    private UserAccount owner;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "advert", targetEntity = CategorySpecValue.class,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategorySpecValue> categorySpecValues = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "advert", targetEntity = InappropriateAdvertReport.class)
    private List<InappropriateAdvertReport> inappropriateAdvertReports = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "advert", targetEntity = AdvertSubscription.class)
    private List<AdvertSubscription> advertSubscriptions = new ArrayList<>();

    public Advert() {
        super();
    }

    public Advert(String title, String description, Boolean isContactShared,
                  UserAccount owner, Category category, List<CategorySpecValue> categorySpecValues) {
        super();
        setTitle(title);
        setDescription(description);
        setPrioritized(false);
        setContactShared(isContactShared);
        setCreationDate(new Date());
        setOwner(owner);
        setCategory(category);
        setCategorySpecValues(categorySpecValues);
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

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public List<CategorySpecValue> getCategorySpecValues() {
        return categorySpecValues;
    }

    public void setCategorySpecValues(List<CategorySpecValue> categorySpecValues) {
        for(CategorySpecValue value:categorySpecValues){
            value.setAdvert(this);
            this.categorySpecValues.add(value);
        }
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

    /**
     * Tampered by Amer
     */
    public AdvertVM mapToViewModel(){
        AdvertVM advertVM=new AdvertVM();

        advertVM.setId(getId());
        advertVM.setTitle(getTitle());
        advertVM.setDescription(getDescription());
        advertVM.setPrioritized(getPrioritized());
        advertVM.setContactShared(getContactShared());
        if(getContactShared()){
            advertVM.setOwnerEmail(getOwner().getPerson().getEmail());
            advertVM.setOwnerPhone(getOwner().getPerson().getPhone());
        }
        if(getCategory()!=null){
            advertVM.setCategoryId(getCategory().getId());
            advertVM.setCategoryTitle(getCategory().getTitle());
        }
        advertVM.setOwnerId(getOwner().getId());
        advertVM.setOwnerName(getOwner().getUsername());
        advertVM.setCreationDate(getCreationDate());
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        advertVM.setDate(df.format(getCreationDate()));

        for(CategorySpecValue csv:getCategorySpecValues()){
            advertVM.getCategorySpecValues().add(csv.mapToViewModel());
        }

        return  advertVM;
    }

}
