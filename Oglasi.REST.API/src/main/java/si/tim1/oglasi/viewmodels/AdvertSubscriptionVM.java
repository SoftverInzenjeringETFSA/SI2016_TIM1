package si.tim1.oglasi.viewmodels;

<<<<<<< HEAD
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
=======
/**
 * Created by Adnan on 5/11/2017.
 */
public class AdvertSubscriptionVM {
    private String subscriberName;
    private String text;
    private String datetime;

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
>>>>>>> d8fcea88c2b37bac8899a82a2539acd8e8732dc2
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
<<<<<<< HEAD
=======

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
>>>>>>> d8fcea88c2b37bac8899a82a2539acd8e8732dc2
}
