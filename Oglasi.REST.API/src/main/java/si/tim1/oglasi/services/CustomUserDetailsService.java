package si.tim1.oglasi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import si.tim1.oglasi.models.Role;
import si.tim1.oglasi.models.UserAccount;
import si.tim1.oglasi.repositories.IUserAccountRepository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Adnan on 5/5/2017.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserAccount userAccount = userAccountRepository.findByUsername(s);
        if(userAccount == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new User(userAccount.getUsername(), userAccount.getPasswordHash(), getGrantedAuthorities(userAccount));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(UserAccount user) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if(user.getRole() != null) {
            Role role = user.getRole();
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
}
