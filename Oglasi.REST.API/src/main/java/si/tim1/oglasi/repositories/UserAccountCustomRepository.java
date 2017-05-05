package si.tim1.oglasi.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import si.tim1.oglasi.models.UserAccount;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Adnan on 5/1/2017.
 */
public class UserAccountCustomRepository implements IUserAccountCustomRepository {

    @Autowired
    private IUserAccountRepository userAccountRepository;

    @Autowired
    private EntityManager entityManager;

    public UserAccount findByUsername(String username) {

        String hql = "SELECT ua FROM UserAccount ua WHERE ua.username = :username";
        Query query = entityManager.createQuery(hql);
        query.setParameter(":username", username);
        List results = query.getResultList();
        return (results.size() == 1) ? (UserAccount)(results.get(0)) : null;

    }


}
