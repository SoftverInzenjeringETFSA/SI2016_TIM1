package si.tim1.oglasi.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adnan on 5/2/2017.
 */
@Entity
public class Role extends BaseEntityModel {
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", targetEntity = UserAccount.class)
    private List<UserAccount> users = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserAccount> getUsers() {
        return users;
    }

    public void setUsers(List<UserAccount> users) {
        this.users = users;
    }
}
