package si.tim1.oglasi.viewmodels;

import si.tim1.oglasi.models.AdvertSubscription;

/**
 * Created by amer on 5/10/17.
 */
public class AdvertSubscriptionVM {

    private long advertID;
    private PersonVM subscriber;
    private String text;

    public AdvertSubscriptionVM(long advertID, PersonVM subscriber, String text){
        this.advertID = advertID;
        this.subscriber = subscriber;
        this.text = text;
    }

    public long getAdvertID() {
        return advertID;
    }

    public void setAdvert(long advertID) {
        this.advertID = advertID;
    }

    public PersonVM getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(PersonVM subscriber) {
        this.subscriber = subscriber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
