package si.tim1.oglasi.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import si.tim1.oglasi.models.InappropriateAdvertReport;

/**
 * Created by Adnan on 5/11/2017.
 */
public interface IAdvertReportRepository extends PagingAndSortingRepository<InappropriateAdvertReport, Long> {

    InappropriateAdvertReport findInappropriateAdvertReportBy(long id);
}
