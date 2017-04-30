package si.tim1.oglasi.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by Adnan on 4/30/2017.
 */
@Entity
public class AdvertSubscription extends BaseEntityModel {

    private String text;

    @ManyToOne(targetEntity = Advert.class, fetch = FetchType.LAZY)
    private Advert advert;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    private Person subscriber;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    public Person getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Person subscriber) {
        this.subscriber = subscriber;
    }
}
