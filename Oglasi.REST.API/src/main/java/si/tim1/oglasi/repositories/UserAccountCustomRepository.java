package si.tim1.oglasi.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import si.tim1.oglasi.models.UserAccount;

/**
 * Created by Adnan on 5/1/2017.
 */
public class UserAccountCustomRepository implements IUserAccountCustomRepository {

    @Autowired
    private IUserAccountRepository userAccountRepository;

    public UserAccount findByUsername(String username) {
        return null;
    }


}
