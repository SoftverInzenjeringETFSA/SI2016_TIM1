package si.tim1.oglasi.services;


import com.sun.org.apache.bcel.internal.generic.RETURN;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    @Autowired
    private IPersonRepository personRepository;

    private Iterable<Advert> getAll(){
        return advertRepository.findAllByIsActiveTrueOrderByIsPrioritizedDescCreationDateDesc();
    }

    private Iterable<Advert> getAllByCategory(Long categoryId){
        return advertRepository.findAllByIsActiveTrueAndCategoryIdOrderByIsPrioritizedDescCreationDateDesc(categoryId);
    }

    private Iterable<Advert> getAllByOwner(Long ownerId){
        return advertRepository.findAllByIsActiveTrueAndOwnerIdOrderByIsPrioritizedDescCreationDateDesc(ownerId);
    }

    public List<AdvertVM> findAllAdverts(){
        Iterable<Advert> adverts = getAll();
        ArrayList<AdvertVM> advertsVM = new ArrayList<>();

        for(Advert advert : adverts){
            advertsVM.add(advert.mapToViewModel());
        }

        return advertsVM;
    }

    public AdvertVM getAdvertByID(Long id){
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

    public List<InappropriateAdvertReportVM> getAllReports(Long id){
        Iterable<InappropriateAdvertReport> reportsAll = advertReportRepository.findAll();
        List<InappropriateAdvertReportVM> reports = new ArrayList<InappropriateAdvertReportVM>();

        for(InappropriateAdvertReport inappropriateAdvertReport : reportsAll){
            if(inappropriateAdvertReport.getAdvert().getId().equals(id)){
                InappropriateAdvertReportVM item = new InappropriateAdvertReportVM();

                item.setPrijavitelj(inappropriateAdvertReport.getReporter().getFirstName() + "  " + inappropriateAdvertReport.getReporter().getLastName());
                item.setMessage(inappropriateAdvertReport.getText());
                item.setId(inappropriateAdvertReport.getId());

                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                item.setDate(df.format(inappropriateAdvertReport.getAdvert().getCreationDate()));

                reports.add(item);
            }
        }

        return reports;
    }

    public InappropriateAdvertReportVM findOneReport(Long id){
        InappropriateAdvertReport inappropriateAdvertReport = advertReportRepository.findOne(id);
        InappropriateAdvertReportVM item = new InappropriateAdvertReportVM();

        item.setId(id);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        item.setDate(df.format(inappropriateAdvertReport.getAdvert().getCreationDate()));
        item.setMessage(inappropriateAdvertReport.getText());
        item.setPrijavitelj(inappropriateAdvertReport.getReporter().getFirstName() + "  " + inappropriateAdvertReport.getReporter().getLastName());

        return item;
    }

    public Boolean deleteReport(Long r_id){
        InappropriateAdvertReport inappropriateAdvertReport = advertReportRepository.findOne(r_id);
        if(inappropriateAdvertReport == null)
            return false;

        advertReportRepository.delete(r_id);

        return true;
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
        //advert
        inappropriateAdvertReport.setAdvert(advertRepository.findAdvertById(inappropriateAdvertReportVM.getAdvertId()));
        //reporter
        Person reporter = new Person();

        if (inappropriateAdvertReportVM.getIsGuest()) {
            reporter.setFirstName(inappropriateAdvertReportVM.getUsername());
            reporter = personRepository.save(reporter);

        }else
            reporter = userAccountRepository.findByUsername(inappropriateAdvertReportVM.getUsername()).getPerson();

        inappropriateAdvertReport.setReporter(reporter);
        inappropriateAdvertReport.setText(inappropriateAdvertReportVM.getMessage());
        inappropriateAdvertReport = advertReportRepository.save(inappropriateAdvertReport);

        return inappropriateAdvertReport != null;

        //throw new ServiceException("Error!");
    }
    public Boolean registerAdvert(AdvertVM advertVM){
        String title=advertVM.getTitle();
        String description=advertVM.getDescription();
        Boolean isContactShared=advertVM.getContactShared();
        UserAccount owner=userAccountRepository.findOne(advertVM.getOwnerId());
        Category category=advertVM.getCategoryId()==null ? null : categoryRepository.findOne(advertVM.getCategoryId());

        if(owner==null){
            return false;
        }

        List<CategorySpecValue> categorySpecValues=new ArrayList<>();
        if(category!=null){
            int size=category.getCategorySpecs().size();
            if(advertVM.getCategorySpecValues().size()!=size){
                return false;
            }

            for(int i=0;i<size;i++){
                String value=advertVM.getCategorySpecValues().get(i).getValue();
                CategorySpec categorySpec=category.getCategorySpecs().get(i);
                CategorySpecValue categorySpecValue=new CategorySpecValue(value, categorySpec);
                categorySpecValues.add(categorySpecValue);
            }
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
        UserAccount owner=userAccountRepository.findOne(advertVM.getOwnerId());
        Category category=advertVM.getCategoryId()==null ? null : categoryRepository.findOne(advertVM.getCategoryId());

        if(owner==null){
            return false;
        }

        advert.setTitle(title);
        advert.setDescription(description);
        advert.setContactShared(isContactShared);
        advert.setOwner(owner);

        if(category!=null){
            int size=category.getCategorySpecs().size();
            if(advertVM.getCategorySpecValues().size()!=size){
                return false;
            }

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
        }
        else{
            if(advert.getCategory()!=null){
                advert.getCategorySpecValues().clear();
                advert.setCategory(category);
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

        return archive(advert)!=null;
    }

    public Boolean changeAdvertPriority(Long id){
        Advert advert=findById(id);

        if(advert==null){
            return false;
        }

        advert.setPrioritized(!advert.getPrioritized());

        return update(advert)!=null;
    }

    public List<SubscriptionListItemVM> getSubscriptionsForAdvert(Long advertID) {
        Advert advert = advertRepository.findAdvertById(advertID);
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
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            itemVM.setDatetime(df.format(advert.getCreationDate()));
            itemVM.setId(advertSubscription.getId());
            itemVM.setAdvertID(advert.getId());

            if(advertSubscription.getActive())
                itemVM.setActive("DA");
            else
                itemVM.setActive("NE");

            subscriptionList.add(itemVM);
        }
        return subscriptionList;

    }
    public AdvertSubscriptionVM getSubscriptionDetails(Long advertID, Long subscriptionID) {
        AdvertSubscription advertSubscription = advertSubscriptionRepository.findOne(subscriptionID);

        if(!advertSubscription.getActive()) {
            advertSubscription.setActive(true);
            advertSubscriptionRepository.save(advertSubscription);
        }

        Advert advert = advertRepository.findOne(advertID);
        AdvertSubscriptionVM advertSubscriptionVM = new AdvertSubscriptionVM();

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        advertSubscriptionVM.setDate(df.format(advert.getCreationDate()));
        advertSubscriptionVM.setMessage(advertSubscription.getText());
        advertSubscriptionVM.setId(advertSubscription.getId());
        advertSubscriptionVM.setSubscriber(advertSubscription.getSubscriber().getFirstName() + " " +advertSubscription.getSubscriber().getLastName());
        advertSubscriptionVM.setMessage(advertSubscription.getSubscriber().getEmail());

        return advertSubscriptionVM;

    }

    public Boolean deleteSubscription(Long advertId, Long id){
        AdvertSubscription advertSubscription = advertSubscriptionRepository.findOne(id);
        if(advertSubscription == null)
            return false;

        advertSubscriptionRepository.delete(id);

        return true;
    }

    public Boolean addAdvertSubscription(AdvertSubscriptionVM advertSubscriptionVM){

        AdvertSubscription advertSubscription = new AdvertSubscription();


        Person p;

        if(advertSubscriptionVM.getSubscriber() == null){
            p = new Person();
            p.setActive(false);
            p.setEmail(advertSubscriptionVM.getMail());
            p.setFirstName(advertSubscriptionVM.getFirstName());
            p.setLastName(advertSubscriptionVM.getLastName());
            p.setPhone(advertSubscriptionVM.getPhone());
            p = personRepository.save(p);

        }else p = userAccountRepository.findByUsername(advertSubscriptionVM.getSubscriber()).getPerson();

        advertSubscription.setSubscriber(p);
        advertSubscription.setAdvert(advertRepository.findAdvertById(advertSubscriptionVM.getAdvertId()));
        advertSubscription.setText(advertSubscriptionVM.getMessage());
        advertSubscription.setActive(true);

        advertSubscription = advertSubscriptionRepository.save(advertSubscription);

        return advertSubscription != null;
    }
}
