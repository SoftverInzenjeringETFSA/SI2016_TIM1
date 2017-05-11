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

import si.tim1.oglasi.services.AdvertService;
import si.tim1.oglasi.viewmodels.AdvertSubscriptionVM;
import si.tim1.oglasi.viewmodels.AdvertVM;
import si.tim1.oglasi.viewmodels.SubscriptionListItemVM;


import java.security.Principal;
import java.util.Collections;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by Adnan on 4/29/2017.
 */
@RestController
@RequestMapping(path="/advert")
public class AdvertController {
    @Autowired
    private AdvertService advertService;


    @RequestMapping(value = "/all", method = RequestMethod.GET) // prikaz svih oglasa
    public Iterable<AdvertVM> getAllAdverts() {
        return advertService.findAllAdverts();
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET) // prikaz svih oglasa po kategoriji
    public List<AdvertVM> getAdvertsByCategory(@RequestParam("id") long id){
        return advertService.findAdvertsByCategoryId(id);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST) // objavljivanje oglasa
    public ResponseEntity register(@RequestBody AdvertVM advertVM) {
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(advertService.registerAdvert(advertVM));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }

    }

    /**
     *  Tampered by Amer
     **/
    //@PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/update", method = RequestMethod.PUT) // update oglasa
    public ResponseEntity update(@RequestBody AdvertVM advertVM) {
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(advertService.update(advertVM));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }
    }

    /**
     *  Tampered by Amer
     **/
    @RequestMapping(value ="", method = RequestMethod.GET)
    public String getAdvertDetails(@RequestParam("id") long id, Principal principal){ // detalji oglasa
        return advertService.getAdvertDetails(id);
    }


    @RequestMapping(value ="details/{id}", method = RequestMethod.GET)
    public AdvertVM getAdvertByID(@PathVariable("id") long id){
        return advertService.getAdvertByID(id);
    }

    /**
     * WORKING!!
     */
    /*@RequestMapping(value = "/subscribe/{id}", method = RequestMethod.POST) // prijava na oglas
    public long subscribeToAdvert(@RequestParam("advertID") long advertID) {
        return advertID;
    }*/
    @RequestMapping(value = "/subscribe", method = RequestMethod.POST) // objavljivanje oglasa
    public ResponseEntity subscribeToAdvert(@RequestBody AdvertSubscriptionVM advSubscriotionVM) {
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(true);
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
    public List<SubscriptionListItemVM> getSubscriptionsForAdvert(@PathVariable Long id, Principal principal) {
        try {
            return advertService.getSubscriptionsForAdvert(id, principal.getName());
        }
        catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{id}/subscriptions/{s_id}", method = RequestMethod.GET) // pregled detalja prijave na oglas
    public void getSubscriptionDetails(@PathVariable Long id, @PathVariable Long s_id) {
        //TODO
    }




}
