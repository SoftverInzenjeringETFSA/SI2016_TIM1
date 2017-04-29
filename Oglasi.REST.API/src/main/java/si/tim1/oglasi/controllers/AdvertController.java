package si.tim1.oglasi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import si.tim1.oglasi.models.Advert;
import si.tim1.oglasi.services.AdvertService;

/**
 * Created by Adnan on 4/29/2017.
 */
@RestController
@RequestMapping(path="/advert")
public class AdvertController {
    @Autowired
    private AdvertService advertService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Advert> getAllAdverts() {
        return advertService.findAll();
    }


}
