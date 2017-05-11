package si.tim1.oglasi.viewmodels;

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
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
