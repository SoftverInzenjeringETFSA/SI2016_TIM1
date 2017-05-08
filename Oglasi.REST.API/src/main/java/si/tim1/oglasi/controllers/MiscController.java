package si.tim1.oglasi.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import si.tim1.oglasi.services.UserAccountService;
import si.tim1.oglasi.viewmodels.UserAccountVM;

import java.security.Principal;

/**
 * Created by Adnan on 5/1/2017.
 */
@RestController
public class MiscController {

    // ne hvata fino, cek
    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity returnOk()
    {
        return ResponseEntity.ok(true);
    }

}
