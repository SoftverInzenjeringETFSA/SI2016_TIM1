package si.tim1.oglasi.services;


import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.tim1.oglasi.models.Advert;
import si.tim1.oglasi.models.AdvertSubscription;
import si.tim1.oglasi.repositories.IAdvertRepository;
import si.tim1.oglasi.viewmodels.AdvertSubscriptionVM;
import si.tim1.oglasi.viewmodels.AdvertVM;
import si.tim1.oglasi.viewmodels.SubscriptionListItemVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adnan on 4/29/2017.
 */
@Service
public class AdvertService extends BaseService<Advert, IAdvertRepository> {

    @Autowired
    private IAdvertRepository advertRepository;

    public String getAdvertDetails(long id){
        Advert advert = advertRepository.findAdvertById(id);
        return advert.getDescription();
    }

    public List<AdvertVM> findAdvertsByCategoryId(long id){
        Iterable<Advert> adverts = advertRepository.findAdvertsByCategoryId(id);
        ArrayList<AdvertVM> advertsVM = new ArrayList<AdvertVM>();

        for(Advert adv : adverts){
            advertsVM.add(adv.mapToViewModel());
        }

        return advertsVM;
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
