package si.tim1.oglasi.viewmodels;

import java.sql.Date;

/**
 * Created by Adnan on 5/2/2017.
 */
public class UserAccountVM {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String companyName;
    private String phone;
    private String email;
    private String pwHash;
    private String confirmPwHash;
    private String roleName;

    private Boolean isBlocked;
    private Date creationDate;

    public UserAccountVM() {}

    public UserAccountVM(Long id,String username, String firstName, String lastName, String companyName, String phone, String email, String pwHash, String confirmPwHash, String roleName, Boolean isBlocked, Date creationDate) {
        this.setId(id);
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.pwHash = pwHash;
        this.confirmPwHash = confirmPwHash;
        this.roleName = roleName;
        this.isBlocked = isBlocked;
        this.creationDate = creationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwHash() {
        return pwHash;
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }

    public String getConfirmPwHash() {
        return confirmPwHash;
    }

    public void setConfirmPwHash(String confirmPwHash) {
        this.confirmPwHash = confirmPwHash;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
