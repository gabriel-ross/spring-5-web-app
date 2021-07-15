package learning.gabeross.spring5webapp.bootstrap;

import learning.gabeross.spring5webapp.models.Author;
import learning.gabeross.spring5webapp.models.Book;
import learning.gabeross.spring5webapp.models.Publisher;
import learning.gabeross.spring5webapp.repositories.AuthorRepository;
import learning.gabeross.spring5webapp.repositories.BookRepository;
import learning.gabeross.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// spring will look for instances of this type and run them
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("gabe publishing", "fake street");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driven design", "12345");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "56789");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        Publisher john = new Publisher("John", "642 terrace avenue");

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(john);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        System.out.println(publisher.getBooks().size());

        System.out.println("Number of Publishers (expected 2): " + publisherRepository.count());

    }
}
