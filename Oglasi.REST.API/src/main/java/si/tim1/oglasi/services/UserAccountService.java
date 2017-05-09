package si.tim1.oglasi.services;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.tim1.oglasi.models.Person;
import si.tim1.oglasi.models.UserAccount;
import si.tim1.oglasi.repositories.IRoleRepository;
import si.tim1.oglasi.repositories.IUserAccountRepository;
import si.tim1.oglasi.viewmodels.UserAccountVM;

/**
 * Created by Adnan on 5/1/2017.
 */
@Service
public class UserAccountService {

    @Autowired
    private IUserAccountRepository userAccountRepository;

    @Autowired
    private IRoleRepository roleRepository;

    public Boolean registerUserAccount(UserAccountVM userAccountVM) {

        if(userAccountVM.getPwHash()
                        .equals(userAccountVM.getConfirmPwHash())) {

            if(userAccountRepository.findByUsername(userAccountVM.getUsername()) != null) {
                throw new ServiceException("Username already exists!");
            }

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
            userAccount.setRole(roleRepository.findRoleByName("ROLE_USER"));

            UserAccount createdUA = userAccountRepository.save(userAccount);

            return createdUA != null;

        }
        throw new ServiceException("The pw field and the confirm pw field don't match!");
    }

    public Boolean updateAccount(UserAccountVM userAccountVM) {
        UserAccount userAccount = userAccountRepository.findByUsername(userAccountVM.getUsername());
        if(userAccount != null) {
            return false;
        }
        return false;
         //not implemented yet
    }

    public UserAccountVM getUserAccountDetails(String username) {
        UserAccount userAccount = userAccountRepository.findByUsername(username);
        if(userAccount != null) {
            return userAccount.mapToViewModel();
        }
        return null;
    }


}
