package si.tim1.oglasi.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import si.tim1.oglasi.models.AdvertSubscription;

/**
 * Created by Adnan on 5/10/2017.
 */
public interface IAdvertSubscriptionRepository extends PagingAndSortingRepository<AdvertSubscription, Long>{

    AdvertSubscription findAdvertSubscriptionBy(long id);

}
