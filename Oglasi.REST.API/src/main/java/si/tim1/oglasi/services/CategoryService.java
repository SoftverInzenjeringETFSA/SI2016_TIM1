package si.tim1.oglasi.services;

import org.springframework.stereotype.Service;
import si.tim1.oglasi.models.Category;
import si.tim1.oglasi.repositories.ICategoryRepository;

/**
 * Created by Adnan on 5/5/2017.
 */
@Service
public class CategoryService extends BaseService<Category, ICategoryRepository> {
}
