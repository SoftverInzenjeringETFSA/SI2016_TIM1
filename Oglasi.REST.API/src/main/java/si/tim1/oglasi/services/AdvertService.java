package si.tim1.oglasi.services;


import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import si.tim1.oglasi.models.*;

import si.tim1.oglasi.repositories.*;
import si.tim1.oglasi.viewmodels.AdvertSubscriptionVM;
import si.tim1.oglasi.viewmodels.AdvertVM;
import si.tim1.oglasi.viewmodels.InappropriateAdvertReportVM;

import si.tim1.oglasi.repositories.IAdvertRepository;
import si.tim1.oglasi.models.AdvertSubscription;
import si.tim1.oglasi.repositories.IAdvertRepository;
import si.tim1.oglasi.viewmodels.AdvertSubscriptionVM;
import si.tim1.oglasi.viewmodels.AdvertVM;
import si.tim1.oglasi.viewmodels.SubscriptionListItemVM;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IUserAccountRepository userAccountRepository;

    @Autowired
    private ICategorySpecValueRepository categorySpecValueRepository;

    private Iterable<Advert> getAll(){
        return advertRepository.findAllByIsActiveTrueOrderByIsPrioritizedDescCreationDateDesc();
    }

    private Iterable<Advert> getAllByCategory(Long categoryId){
        return advertRepository.findAllByIsActiveTrueAndCategoryIdOrderByIsPrioritizedDescCreationDateDesc(categoryId);
    }

    private Iterable<Advert> getAllByOwner(Long ownerId){
        return advertRepository.findAllByIsActiveTrueAndOwnerIdOrderByIsPrioritizedDescCreationDateDesc(ownerId);
    }


    public String getAdvertDetails(long id){
        Advert advert = advertRepository.findAdvertById(id);
        return advert.getDescription();
    }

    public List<AdvertVM> findAllAdverts(){
        Iterable<Advert> adverts = getAll();
        ArrayList<AdvertVM> advertsVM = new ArrayList<>();

        for(Advert advert : adverts){
            advertsVM.add(advert.mapToViewModel());
        }

        return advertsVM;
    }

    public AdvertVM getAdvertByID(long id){
        Advert advert=findById(id);

        return advert==null ? null : advert.mapToViewModel();
    }

    public List<AdvertVM> findAdvertsByCategoryId(Long categoryId){
        Iterable<Advert> adverts = getAllByCategory(categoryId);
        ArrayList<AdvertVM> advertsVM = new ArrayList<>();

        for(Advert advert : adverts){
            advertsVM.add(advert.mapToViewModel());
        }

        return advertsVM;
    }

    public List<AdvertVM> findAdvertsByOwnerId(Long ownerId){
        Iterable<Advert> adverts = getAllByOwner(ownerId);
        ArrayList<AdvertVM> advertsVM = new ArrayList<>();

        for(Advert advert : adverts){
            advertsVM.add(advert.mapToViewModel());
        }

        return advertsVM;
    }

    public List<AdvertVM> findAdvertsWithReport(){
        List<Advert> adverts = (List<Advert>)getAll();
        adverts=adverts.stream().filter(a->a.getInappropriateAdvertReports().size()!=0).collect(Collectors.toList());
        ArrayList<AdvertVM> advertsVM = new ArrayList<>();

        for(Advert advert : adverts){
            advertsVM.add(advert.mapToViewModel());
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
        String title=advertVM.getTitle();
        String description=advertVM.getDescription();
        Boolean isContactShared=advertVM.getContactShared();
        UserAccount owner=userAccountRepository.findOne(advertVM.getOwnerId());
        Category category=categoryRepository.findOne(advertVM.getCategoryId());

        if(owner==null || category==null){
            return false;
        }

        int size=category.getCategorySpecs().size();
        if(advertVM.getCategorySpecValues().size()!=size){
            return false;
        }

        List<CategorySpecValue> categorySpecValues=new ArrayList<>();
        for(int i=0;i<size;i++){
            String value=advertVM.getCategorySpecValues().get(i).getValue();
            CategorySpec categorySpec=category.getCategorySpecs().get(i);
            CategorySpecValue categorySpecValue=new CategorySpecValue(value, categorySpec);
            categorySpecValues.add(categorySpecValue);
        }

        Advert advert=new Advert(title, description, isContactShared, owner, category, categorySpecValues);
        Advert created = add(advert);

        return created!=null;
    }

    public Boolean updateAdvert(AdvertVM advertVM){
        Advert advert=findById(advertVM.getId());

        if(advert==null){
            return false;
        }

        String title=advertVM.getTitle();
        String description=advertVM.getDescription();
        Boolean isContactShared=advertVM.getContactShared();
        Boolean isPrioritized=advertVM.getPrioritized();
        UserAccount owner=userAccountRepository.findOne(advertVM.getOwnerId());
        Category category=categoryRepository.findOne(advertVM.getCategoryId());

        if(owner==null || category==null){
            return false;
        }

        int size=category.getCategorySpecs().size();
        if(advertVM.getCategorySpecValues().size()!=size){
            return false;
        }

        advert.setTitle(title);
        advert.setDescription(description);
        advert.setContactShared(isContactShared);
        advert.setPrioritized(isPrioritized);
        advert.setOwner(owner);

        if(advert.getCategory()==null || advert.getCategory().getId()!=category.getId()){
            if(advert.getCategory()!=null){
                advert.getCategorySpecValues().clear();
            }

            List<CategorySpecValue> categorySpecValues=new ArrayList<>();
            for(int i=0;i<size;i++){
                String value=advertVM.getCategorySpecValues().get(i).getValue();
                CategorySpec categorySpec=category.getCategorySpecs().get(i);
                CategorySpecValue categorySpecValue=new CategorySpecValue(value, categorySpec);
                categorySpecValues.add(categorySpecValue);
            }

            advert.setCategory(category);
            advert.setCategorySpecValues(categorySpecValues);
        }
        else{
            for(int i=0;i<size;i++){
                String value=advertVM.getCategorySpecValues().get(i).getValue();
                advert.getCategorySpecValues().get(i).setValue(value);
            }
        }

        Advert created = update(advert);

        return created!=null;
    }

    public Boolean deleteAdvert(Long id){
        Advert advert=findById(id);

        if(advert==null){
            return false;
        }

        for(CategorySpecValue csv:advert.getCategorySpecValues()){
            csv.setActive(false);
        }

        categorySpecValueRepository.save(advert.getCategorySpecValues());
        archive(advert);

        return true;
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
