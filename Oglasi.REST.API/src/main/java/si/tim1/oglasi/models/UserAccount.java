package si.tim1.oglasi.models;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import si.tim1.oglasi.viewmodels.UserAccountVM;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adnan on 4/30/2017.
 */
@Entity
public class UserAccount {

    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = {@Parameter(name = "property", value = "person")})
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "generator")
    private Long id;

    private String username;
    private String passwordHash;
    private Boolean isBlocked;

    @OneToOne(fetch = FetchType.LAZY)
    //@PrimaryKeyJoinColumn => this makes Hibernate doesn't create FK, but don't delete, we need to check that
    private Person person;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", targetEntity = Advert.class)
    private List<Advert> adverts = new ArrayList<>();

    @ManyToOne(targetEntity = Role.class)
    private Role role;

    public UserAccount() {}

    public UserAccount(String username, String passwordHash, Boolean isBlocked, Person person) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.isBlocked = isBlocked;
        this.person = person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserAccountVM mapToViewModel() {
        return new UserAccountVM(id,username, person.getFirstName(), person.getLastName(),
                                person.getCompanyName(), person.getPhone(), person.getEmail(), null, null, role.getName());
    }
}
