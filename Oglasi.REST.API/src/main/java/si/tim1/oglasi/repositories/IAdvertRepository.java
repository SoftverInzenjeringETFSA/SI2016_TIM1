package si.tim1.oglasi.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import si.tim1.oglasi.models.Advert;
import si.tim1.oglasi.models.Role;

import java.util.List;

/**
 * Created by Adnan on 4/29/2017.
 */
public interface IAdvertRepository extends PagingAndSortingRepository<Advert, Long> {
    Advert findAdvertById(long id);
    Iterable<Advert> findAdvertsByCategoryId(long id);
}
