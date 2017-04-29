package si.tim1.oglasi.models;

import javax.persistence.*;
import java.util.Date;

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
}
