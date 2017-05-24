package si.tim1.oglasi.viewmodels;


/**
 * Created by Adnan on 5/10/2017.
 */
public class AdvertSubscriptionVM {

    private Long id;
    private String subscriber;
    private String message;

    public AdvertSubscriptionVM() {}

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) { this.message = message; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

}