package si.tim1.oglasi.viewmodels;

/**
 * Created by Adnan on 5/11/2017.
 */
public class SubscriptionListItemVM {
    private Long id;
    private String subscriberName;
    private String datetime;

    public SubscriptionListItemVM() {}

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}