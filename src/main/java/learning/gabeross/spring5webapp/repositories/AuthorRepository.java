package learning.gabeross.spring5webapp.repositories;

import learning.gabeross.spring5webapp.models.Author;
import org.springframework.data.repository.CrudRepository;

// We only need to provide the interface, and at runtime spring data JPA
// is going to provide the implementation for us for all of these repo commands

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
