package si.tim1.oglasi.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import si.tim1.oglasi.models.Advert;
import si.tim1.oglasi.services.AdvertService;
import si.tim1.oglasi.viewmodels.AdvertSubscriptionVM;
import si.tim1.oglasi.viewmodels.AdvertVM;
import si.tim1.oglasi.viewmodels.InappropriateAdvertReportVM;

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


    @RequestMapping(value = "/all", method = RequestMethod.GET) // prikaz svih oglasa
    public Iterable<Advert> getAllAdverts() {
        return advertService.findAll();
    }


    @RequestMapping(value = "/category", method = RequestMethod.GET) // prikaz svih oglasa po kategoriji
    @PreAuthorize("hasRole('ROLE_USER')")
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

    @RequestMapping(value = "/subscribe", method = RequestMethod.GET)                           // naziv i vlasnik oglasa
    public String getAdvertTitleAndOwner(@RequestParam("id") long id, Principal principal) {
        return advertService.getAdvertTitleAndOwner(id);
    }

    @RequestMapping(value = "/subscribe", method = RequestMethod.POST) // prijava na oglas
    public ResponseEntity setSubscription(@RequestBody AdvertSubscriptionVM advertSubscriptionVM) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(advertService.setAdvertSubscription(advertSubscriptionVM));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }
    }

    @RequestMapping(value = "/report", method = RequestMethod.POST) // prijava oglasa
    public ResponseEntity setReport(@RequestBody InappropriateAdvertReportVM inappropriateAdvertReportVM) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(advertService.setInappropriateAdvertReport(inappropriateAdvertReportVM));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }
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
