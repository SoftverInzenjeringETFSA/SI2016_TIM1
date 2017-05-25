package si.tim1.oglasi.services;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.tim1.oglasi.models.Person;
import si.tim1.oglasi.models.UserAccount;
import si.tim1.oglasi.repositories.IRoleRepository;
import si.tim1.oglasi.repositories.IUserAccountRepository;
import si.tim1.oglasi.viewmodels.ListVM;
import si.tim1.oglasi.viewmodels.UserAccountVM;

import java.util.ArrayList;

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
                                                        person, new java.sql.Date((new java.util.Date()).getTime()));
            userAccount.setRole(roleRepository.findRoleByName("ROLE_USER"));

            UserAccount createdUA = userAccountRepository.save(userAccount);

            return createdUA != null;

        }
        throw new ServiceException("The pw field and the confirm pw field don't match!");
    }

    public Boolean updateAccount(UserAccountVM userAccountVM) {
        UserAccount userAccount = userAccountCustomRepository.findByUsername(userAccountVM.getUsername());

        userAccount.getPerson().setFirstName(userAccountVM.getFirstName());
        userAccount.getPerson().setLastName(userAccountVM.getLastName());
        userAccount.getPerson().setEmail(userAccountVM.getEmail());
        userAccount.getPerson().setCompanyName(userAccountVM.getCompanyName());
        userAccount.getPerson().setPhone(userAccountVM.getPhone());
        // userAccount.setUsername(userAccountVM.getUsername());
        // userAccount.setPasswordHash(userAccountVM.getPwHash());

        UserAccount createUser = userAccountRepository.save(userAccount);

        return createUser != null;


    }

    public UserAccountVM getUserAccountDetails(String username) {
        UserAccount userAccount = userAccountRepository.findByUsername(username);
        if(userAccount != null) {
            return userAccount.mapToViewModel();
        }
        return null;
    }

    public ListVM<UserAccountVM> getAllUsers(){
        Iterable<UserAccount> userAccounts = userAccountRepository.findAll();
        ArrayList<UserAccountVM> fr = new ArrayList<>();

        for(UserAccount ua: userAccounts){
            if(!ua.getRole().getName().equals("ROLE_ADMIN"))
                fr.add(ua.mapToViewModelAdmin());
        }

        return new ListVM<>(fr);
    }

    public Boolean changeUserBlock(String username){
        UserAccount userAccount = userAccountRepository.findByUsername(username);
        userAccount.setBlocked(!userAccount.getBlocked());
        userAccount.getPerson().setActive(!userAccount.getPerson().getActive());
        UserAccount createUser = userAccountRepository.save(userAccount);

        return createUser != null;
    }


}
