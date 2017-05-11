package si.tim1.oglasi.services;


import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.tim1.oglasi.models.Advert;
import si.tim1.oglasi.models.AdvertSubscription;
import si.tim1.oglasi.models.InappropriateAdvertReport;
import si.tim1.oglasi.repositories.IAdvertReportRepository;
import si.tim1.oglasi.repositories.IAdvertRepository;
import si.tim1.oglasi.repositories.IAdvertSubscriptionRepository;
import si.tim1.oglasi.viewmodels.AdvertSubscriptionVM;
import si.tim1.oglasi.viewmodels.AdvertVM;
import si.tim1.oglasi.viewmodels.InappropriateAdvertReportVM;

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
}
