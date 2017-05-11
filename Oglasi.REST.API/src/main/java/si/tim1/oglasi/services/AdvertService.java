package si.tim1.oglasi.services;


import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import si.tim1.oglasi.models.Advert;

import si.tim1.oglasi.models.AdvertSubscription;
import si.tim1.oglasi.models.InappropriateAdvertReport;
import si.tim1.oglasi.repositories.IAdvertReportRepository;
import si.tim1.oglasi.repositories.IAdvertRepository;
import si.tim1.oglasi.repositories.IAdvertSubscriptionRepository;
import si.tim1.oglasi.viewmodels.AdvertSubscriptionVM;
import si.tim1.oglasi.viewmodels.AdvertVM;
import si.tim1.oglasi.viewmodels.InappropriateAdvertReportVM;

import si.tim1.oglasi.models.UserAccount;
import si.tim1.oglasi.repositories.IAdvertRepository;
import si.tim1.oglasi.repositories.ICategoryRepository;
import si.tim1.oglasi.models.AdvertSubscription;
import si.tim1.oglasi.repositories.IAdvertRepository;
import si.tim1.oglasi.viewmodels.AdvertSubscriptionVM;
import si.tim1.oglasi.viewmodels.AdvertVM;
import si.tim1.oglasi.viewmodels.SubscriptionListItemVM;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adnan on 4/29/2017.
 */
@Service
public class AdvertService extends BaseService<Advert, IAdvertRepository> {

    @Autowired
    private IAdvertRepository advertRepository;

    @Autowired
    private IAdvertSubscriptionRepository advertSubscriptionRepository;

    @Autowired
    private IAdvertReportRepository advertReportRepository;

    private ICategoryRepository categoryRepository;


    public String getAdvertDetails(long id){
        Advert advert = advertRepository.findAdvertById(id);
        return advert.getDescription();
    }

    public List<AdvertVM> findAllAdverts(){
        Iterable<Advert> adverts = advertRepository.findAll();
        ArrayList<AdvertVM> advertsVM = new ArrayList<AdvertVM>();

        for(Advert adv : adverts){
            advertsVM.add(adv.mapToViewModel());
        }

        return advertsVM;
    }

    public AdvertVM getAdvertByID(long id){
        Advert adv = advertRepository.findAdvertById(id);
        AdvertVM advVM = adv.mapToViewModel();
        return advVM;
    }

    public List<AdvertVM> findAdvertsByCategoryId(long id){
        Iterable<Advert> adverts = advertRepository.findAdvertsByCategoryId(id);
        ArrayList<AdvertVM> advertsVM = new ArrayList<AdvertVM>();

        for(Advert adv : adverts){
            advertsVM.add(adv.mapToViewModel());
        }

        return advertsVM;
    }


    public String getAdvertTitleAndOwner(long id){
        Advert advert = advertRepository.findAdvertById(id);
        return advert.getTitle() + "/" + advert.getOwner().getUsername();
    }

    public boolean setAdvertSubscription(AdvertSubscriptionVM advertSubscriptionVM) {

        AdvertSubscription advertSubscription = new AdvertSubscription();
        advertSubscription.setText(advertSubscriptionVM.getMessage());
        advertSubscriptionRepository.save(advertSubscription);

        return true;

        //throw new ServiceException("Error!");
    }

    public boolean setInappropriateAdvertReport(InappropriateAdvertReportVM inappropriateAdvertReportVM) {

        InappropriateAdvertReport inappropriateAdvertReport = new InappropriateAdvertReport();
        inappropriateAdvertReport.setText(inappropriateAdvertReportVM.getMessage());
        advertReportRepository.save(inappropriateAdvertReport);

        return true;

        //throw new ServiceException("Error!");
    }
    public Boolean registerAdvert(AdvertVM advertVM){

        Advert advert = new Advert(advertVM.getTitle(),
                                    advertVM.getDescription(),
                                    null,
                                    null,
                                    null);


        Advert createdADV = advertRepository.save(advert);

        return createdADV != null;
    }

    public Boolean update(AdvertVM advertVM){

        Advert advert = advertRepository.findAdvertById(advertVM.getAdvertID());
        advert.setTitle(advertVM.getTitle());
        advert.setDescription(advertVM.getDescription());
        /**
         * Add other parameters we wish to change depending on the category
         */

        // In case we want to give an opportunity to change the category of an advert
        // in the future.
        // --> advert.setCategory(categoryRepository.findCategoryById(advertVM.getCategoryID()));

        Advert createdADV = advertRepository.save(advert);
        return createdADV != null;
    }

    public List<SubscriptionListItemVM> getSubscriptionsForAdvert(Long advertID, String callerUsername) {
        Advert advert = advertRepository.findAdvertById(advertID);
        if(advert.getOwner().getUsername().equals(callerUsername)) {
            List<AdvertSubscription> advertSubscriptions = advert.getAdvertSubscriptions();
            List<SubscriptionListItemVM> subscriptionList = new ArrayList<>();
            for (AdvertSubscription advertSubscription : advertSubscriptions) {
                SubscriptionListItemVM itemVM = new SubscriptionListItemVM();

                if(advertSubscription.getSubscriber().getCompanyName() != null) {
                    itemVM.setSubscriberName(advertSubscription.getSubscriber().getCompanyName());
                }
                else {
                    String name = advertSubscription.getSubscriber().getFirstName() + " " + advertSubscription.getSubscriber().getLastName();
                    itemVM.setSubscriberName(name);
                }
                itemVM.setDatetime("hard coded DATE TIME"); // TODO
                itemVM.setId(advertSubscription.getId());
                subscriptionList.add(itemVM);
            }
            return subscriptionList;
        }
        else {
            throw new ServiceException("You don't have a permission to view the subscription list for this advert");
        }

    }
    public AdvertSubscriptionVM getSubscriptionDetails(Long id) {
        return null; // TODO

    }
}
