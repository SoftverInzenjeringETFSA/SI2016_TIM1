package si.tim1.oglasi.repositories;

import si.tim1.oglasi.models.Category;

/**
 * Created by infloop on 5/11/17.
 */
public interface ICategoryCustomRepository {
    Category findByTitle(String title);
}
