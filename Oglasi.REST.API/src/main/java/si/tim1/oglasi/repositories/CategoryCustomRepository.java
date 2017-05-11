package si.tim1.oglasi.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import si.tim1.oglasi.models.Category;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.List;

public class CategoryCustomRepository implements ICategoryCustomRepository {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private EntityManager entityManager;

    public CategoryCustomRepository() {
    }

    public Category findByTitle(String title) {

        String hql = "SELECT category FROM Category category WHERE category.title = :title";
        Query query = (Query) entityManager.createQuery(hql);
        query.setParameter(":title", title);
        List results = query.getResultList();
        return (results.size() == 1) ? (Category)(results.get(0)) : null;

    }
}