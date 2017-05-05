package si.tim1.oglasi.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import si.tim1.oglasi.models.Category;

/**
 * Created by Adnan on 5/5/2017.
 */
public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long>{
}
