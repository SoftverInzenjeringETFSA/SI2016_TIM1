package si.tim1.oglasi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import si.tim1.oglasi.models.Advert;
import si.tim1.oglasi.services.AdvertService;
import si.tim1.oglasi.viewmodels.AdvertVM;

import java.security.Principal;
import java.util.List;

/**
 * Created by Adnan on 4/29/2017.
 */
@RestController
@RequestMapping(path="/advert")
public class AdvertController {
    @Autowired
    private AdvertService advertService;



    @RequestMapping(value = "/all", method = RequestMethod.GET) // prikaz svih oglasa iz kategorije, treba dodati request parameter za odabranu kat.

    public Iterable<Advert> getAllAdverts() {
        return advertService.findAll();
    }


    @RequestMapping(value = "/category", method = RequestMethod.GET) // prikaz svih oglasa po kategoriji

    public List<AdvertVM> getAdvertsByCategory(@RequestParam("id") long id){
        return advertService.findAdvertsByCategoryId(id);
    }


  

    @RequestMapping(value = "/create", method = RequestMethod.POST) // objavljivanje oglasa
    public void untitledMethod() {
        //TODO
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/update", method = RequestMethod.PUT) // update oglasa
    public void untitledMethod1() {
        //TODO
    }

    /**
     *  Tampered by Amer
     **/
    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET) // detalji oglasa
    public String getAdvertDetails() {
        return null; // Test
    }*/
    @RequestMapping(value ="", method = RequestMethod.GET)
    public String getAdvertDetails(@RequestParam("id") long id, Principal principal){
        return advertService.getAdvertDetails(id);
    }


    @RequestMapping(value = "/subscribe", method = RequestMethod.POST) // prijava na oglas
    public void untitledMethod4() {
        //TODO
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{id}/subscriptions", method = RequestMethod.GET) // pregled prijava na oglas
    public void untitledMethod5() {
        //TODO
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{id}/subscriptions/{s_id}", method = RequestMethod.GET) // pregled detalja prijave na oglas
    public void untitledMethod6() {
        //TODO
    }




}
