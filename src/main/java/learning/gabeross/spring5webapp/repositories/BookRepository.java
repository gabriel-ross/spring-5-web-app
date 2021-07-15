package learning.gabeross.spring5webapp.repositories;


import learning.gabeross.spring5webapp.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
