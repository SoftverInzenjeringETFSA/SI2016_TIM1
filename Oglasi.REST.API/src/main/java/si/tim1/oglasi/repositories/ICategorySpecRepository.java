package si.tim1.oglasi.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import si.tim1.oglasi.models.Category;
import si.tim1.oglasi.models.CategorySpec;

/**
 * Created by Siii on 5/26/2017.
 */
public interface ICategorySpecRepository extends PagingAndSortingRepository<CategorySpec, Long> {

}
