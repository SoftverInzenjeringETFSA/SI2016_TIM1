package si.tim1.oglasi.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import si.tim1.oglasi.services.AdvertService;
import si.tim1.oglasi.viewmodels.AdvertSubscriptionVM;
import si.tim1.oglasi.viewmodels.AdvertVM;
import si.tim1.oglasi.viewmodels.InappropriateAdvertReportVM;

import si.tim1.oglasi.viewmodels.SubscriptionListItemVM;


import java.util.Collections;
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
    public List<AdvertVM> getAllAdverts() {
        return advertService.findAllAdverts();
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET) // prikaz svih oglasa po kategoriji
    public List<AdvertVM> getAdvertsByCategory(@RequestParam("categoryId") Long categoryId){
        return advertService.findAdvertsByCategoryId(categoryId);
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/owner/{ownerId}", method = RequestMethod.GET) // prikaz svih oglasa po kategoriji
    public List<AdvertVM> getAdvertsByOwner(@PathVariable("ownerId") Long ownerId){
        return advertService.findAdvertsByOwnerId(ownerId);
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/with_report", method = RequestMethod.GET) // prikaz svih oglasa po kategoriji
    public List<AdvertVM> getAdvertsWithReport(){
        return advertService.findAdvertsWithReport();
    }

    //@PreAuthorize("hasRole('ROLE_USER')")
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
    @RequestMapping(value = "/update", method = RequestMethod.POST) // updateAdvert oglasa
    public ResponseEntity update(@RequestBody AdvertVM advertVM) {
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(advertService.updateAdvert(advertVM));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }
    }

    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/delete/{advertId}", method = RequestMethod.DELETE) // deletedvert oglasa
    public ResponseEntity delete(@PathVariable("advertId") Long advertId) {
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(advertService.deleteAdvert(advertId));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/set_priority", method = RequestMethod.POST)
    public ResponseEntity changeAdvertPriority(@RequestParam("id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(advertService.changeAdvertPriority(id));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }
    }

    /**
     *  Tampered by Amer
     **/
    /*
    @RequestMapping(value ="", method = RequestMethod.GET)
    public String getAdvertDetails2(@RequestParam("advertId") long id, Principal principal){ // detalji oglasa
        return advertService.getAdvertDetails(id);
    }
    */

    @RequestMapping(value ="/details/{advertId}", method = RequestMethod.GET)
    public AdvertVM getAdvertDetails(@PathVariable("advertId") Long advertId){
        return advertService.getAdvertByID(advertId);
    }

    /**
     * WORKING!!
     */
    /*@RequestMapping(value = "/subscribe/{advertId}", method = RequestMethod.POST) // prijava na oglas
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

    //@PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{advertId}/subscriptions", method = RequestMethod.GET) // pregled prijava na oglas
    public List<SubscriptionListItemVM> getSubscriptionsForAdvert(@PathVariable("advertId") Long advertId) {
        try {
            return advertService.getSubscriptionsForAdvert(advertId);
        }
        catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    //@PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{advertId}/subscriptions/{s_id}", method = RequestMethod.GET) // pregled detalja prijave na oglas
    public AdvertSubscriptionVM getSubscriptionDetails(@PathVariable("advertId") Long advertId, @PathVariable("s_id") Long s_id) {
        try {
            return advertService.getSubscriptionDetails(advertId, s_id);
        }
        catch (Exception e) {
            return null;
        }
    }


    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/{advertId}/subscriptions/{s_id}/delete", method = RequestMethod.GET) // deletedvert oglasa
    public ResponseEntity deleteSubscription(@PathVariable("advertId") Long advertId, @PathVariable("s_id") Long s_id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(advertService.deleteSubscription(advertId, s_id));
        } catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }
    }

    @RequestMapping(value = "/check_in", method = RequestMethod.POST)
    public ResponseEntity checkInAdvert(@RequestBody AdvertSubscriptionVM advertSubscriptionVM){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(advertService.addAdvertSubscription(advertSubscriptionVM));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getLocalizedMessage());
        }
    }
}
