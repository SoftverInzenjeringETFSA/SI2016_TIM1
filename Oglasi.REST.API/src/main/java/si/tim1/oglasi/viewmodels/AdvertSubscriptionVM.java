package si.tim1.oglasi.viewmodels;


/**
 * Created by Adnan on 5/10/2017.
 */
public class AdvertSubscriptionVM {

    private Long id;
    private String subscriber;
    private String message;
    private String date;

    private Long advertId;
    private String firstName;
    private String lastName;
    private String mail;
    private String phone;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public AdvertSubscriptionVM(){}

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

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}