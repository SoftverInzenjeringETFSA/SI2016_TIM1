package si.tim1.oglasi.viewmodels;

import si.tim1.oglasi.models.Person;

/**
 * Created by amer on 5/10/17.
 */
public class PersonVM {

    private String firstName;
    private String lastName;
    private String companyName;
    private String email;
    private String phone;

    public PersonVM(String firstName, String lastName, String companyName, String email, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.email = email;
        this.phone = phone;
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
}
