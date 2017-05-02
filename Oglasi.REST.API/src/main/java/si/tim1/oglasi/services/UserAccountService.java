package si.tim1.oglasi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.tim1.oglasi.models.Person;
import si.tim1.oglasi.models.UserAccount;
import si.tim1.oglasi.repositories.IUserAccountRepository;
import si.tim1.oglasi.viewmodels.UserAccountVM;

/**
 * Created by Adnan on 5/1/2017.
 */
@Service
public class UserAccountService {

    @Autowired
    private IUserAccountRepository userAccountRepository;

    public Boolean registerUserAccount(UserAccountVM userAccountVM) {

        if(userAccountVM.getPwHash()
                        .equals(userAccountVM.getConfirmPwHash())) {

            // of course we need some cryptography for passwords here, but we'll check this later

            Person person = new Person(userAccountVM.getFirstName(),
                                        userAccountVM.getLastName(),
                                        userAccountVM.getCompanyName(),
                                        userAccountVM.getEmail(),
                                        userAccountVM.getPhone());

            UserAccount userAccount = new UserAccount(userAccountVM.getUsername(),
                                                        userAccountVM.getPwHash(),
                                                        false,
                                                        person);

            UserAccount createdUA = userAccountRepository.save(userAccount);

            return createdUA != null;

        }
        return false;
    }


}
