package si.tim1.oglasi.models;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adnan on 4/30/2017.
 */
@Entity
public class Person extends BaseEntityModel{
    private String firstName;
    private String lastName;
    private String companyName;
    private String email;
    private String phone;

    public Person() {}

    public Person(String firstName, String lastName, String companyName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.email = email;
        this.phone = phone;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reporter", targetEntity = InappropriateAdvertReport.class)
    private List<InappropriateAdvertReport> inappropriateAdvertReports = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriber", targetEntity = AdvertSubscription.class)
    private List<AdvertSubscription> advertSubscriptions = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class, mappedBy = "person", cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private UserAccount userAccount;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
