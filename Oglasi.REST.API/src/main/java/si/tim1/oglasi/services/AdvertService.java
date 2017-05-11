package si.tim1.oglasi.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import si.tim1.oglasi.models.Advert;
import si.tim1.oglasi.models.UserAccount;
import si.tim1.oglasi.repositories.IAdvertRepository;
import si.tim1.oglasi.repositories.ICategoryRepository;
import si.tim1.oglasi.viewmodels.AdvertVM;

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
    private ICategoryRepository categoryRepository;

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

}
