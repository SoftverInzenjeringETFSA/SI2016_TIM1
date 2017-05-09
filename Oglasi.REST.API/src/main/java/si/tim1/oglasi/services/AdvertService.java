package si.tim1.oglasi.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.tim1.oglasi.models.Advert;
import si.tim1.oglasi.repositories.IAdvertRepository;
import si.tim1.oglasi.viewmodels.AdvertVM;

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
}
