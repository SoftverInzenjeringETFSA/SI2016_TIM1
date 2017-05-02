package si.tim1.oglasi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.tim1.oglasi.services.UserAccountService;
import si.tim1.oglasi.viewmodels.UserAccountVM;

/**
 * Created by Adnan on 5/1/2017.
 */
@RestController
@RequestMapping(path = "/account")
public class UserAccountController {

    private UserAccountService userAccountService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Boolean register(@RequestBody UserAccountVM userAccountVM)
    {
        return userAccountService.registerUserAccount(userAccountVM);
    }

    @Autowired
    public void setUserAccountService(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }
}
