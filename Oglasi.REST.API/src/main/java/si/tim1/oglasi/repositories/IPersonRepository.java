package si.tim1.oglasi.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import si.tim1.oglasi.models.Person;

/**
 * Created by Adnan on 4/29/2017.
 */
public interface IPersonRepository extends PagingAndSortingRepository<Person, Long> {

}
