package si.tim1.oglasi.controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import si.tim1.oglasi.services.UserAccountService;
import si.tim1.oglasi.viewmodels.ListVM;
import si.tim1.oglasi.viewmodels.UserAccountVM;

import java.security.Principal;

/**
 * Created by Adnan on 5/1/2017.
 */
@RestController
@RequestMapping(path = "/account")
public class UserAccountController {

    private UserAccountService userAccountService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody UserAccountVM userAccountVM)
    {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(userAccountService.registerUserAccount(userAccountVM));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }


    }
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody UserAccountVM userAccountVM) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                                .body(userAccountService.updateAccount(userAccountVM));
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }
    }
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public UserAccountVM getUserDetail(Principal principal) {
        return userAccountService.getUserAccountDetails(principal.getName());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ListVM<UserAccountVM> getAllUsers(){
        return userAccountService.getAllUsers();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value = "/block", method = RequestMethod.POST)
    public ResponseEntity blockIt(@RequestBody String username){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(userAccountService.changeUserBlock(username));
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }
    }

    @Autowired
    public void setUserAccountService(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }
}
