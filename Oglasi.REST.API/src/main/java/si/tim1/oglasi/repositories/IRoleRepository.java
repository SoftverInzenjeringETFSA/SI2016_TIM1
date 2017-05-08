package si.tim1.oglasi.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import si.tim1.oglasi.models.Role;

/**
 * Created by Adnan on 5/8/2017.
 */
public interface IRoleRepository extends PagingAndSortingRepository<Role, Long> {
    Role findRoleByName(String name);
}
