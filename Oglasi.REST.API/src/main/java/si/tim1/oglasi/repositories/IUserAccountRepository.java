package si.tim1.oglasi.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import si.tim1.oglasi.models.UserAccount;

/**
 * Created by Adnan on 5/1/2017.
 */
public interface IUserAccountRepository extends PagingAndSortingRepository<UserAccount, Long>, IUserAccountCustomRepository{

}
