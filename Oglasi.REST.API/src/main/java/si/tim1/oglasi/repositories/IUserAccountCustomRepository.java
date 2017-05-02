package si.tim1.oglasi.repositories;

import si.tim1.oglasi.models.UserAccount;

/**
 * Created by Adnan on 5/2/2017.
 */
public interface IUserAccountCustomRepository {
    UserAccount findByUsername(String username);
}
