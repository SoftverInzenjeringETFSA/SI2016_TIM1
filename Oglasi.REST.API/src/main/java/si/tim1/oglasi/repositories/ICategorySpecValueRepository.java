package si.tim1.oglasi.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import si.tim1.oglasi.models.CategorySpecValue;

/**
 * Created by Dell on 21.5.2017..
 */
public interface ICategorySpecValueRepository extends PagingAndSortingRepository<CategorySpecValue, Long> {
}
