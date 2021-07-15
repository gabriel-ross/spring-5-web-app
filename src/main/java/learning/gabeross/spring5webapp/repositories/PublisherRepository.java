package learning.gabeross.spring5webapp.repositories;

import learning.gabeross.spring5webapp.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
