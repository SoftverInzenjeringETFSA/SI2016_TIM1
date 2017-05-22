package si.tim1.oglasi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import si.tim1.oglasi.models.BaseEntityModel;

/**
 * Created by Adnan on 4/29/2017.
 */
public class BaseService<M extends BaseEntityModel, R extends PagingAndSortingRepository<M, Long>> {
    @Autowired
    private R repository;

    public Iterable<M> findAll() {
        return repository.findAll();
    }
    public M findById(long id) {
        return repository.findOne(id);
    }
    public M add(M m) {
        m.setActive(true);
        return repository.save(m);
    }
    public M update(M m) {
        return repository.save(m);
    }
    public void archive(M m) {
        m.setActive(false);
        repository.save(m);
    }
}
