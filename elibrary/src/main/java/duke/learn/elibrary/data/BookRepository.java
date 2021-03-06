/**
 * 
 */
package duke.learn.elibrary.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import duke.learn.elibrary.data.model.Book;

/**
 * @author Kazi
 *
 */
@Repository
public class BookRepository {

    private final static Logger LOGGER = LoggerFactory.getLogger(BookRepository.class);

    @PersistenceContext(unitName = "entityManager")
    private EntityManager entityManager;

    public Book addUpdateBook(Book book) {
	if (book != null) {
	    if (book.getBookId() != null) {
		// merge
		entityManager.merge(book);
	    } else {
		// persist
		entityManager.persist(book);
	    }
	}
	return book;
    }

    public Book getBook(Integer bookId) {
	Book book = null;
	try {
	    book = (Book) entityManager.createQuery("select b from Book b where b.bookId = :bookId")
		    .setParameter("bookId", bookId).getSingleResult();
	} catch (Exception e) {
	    LOGGER.error("error getting book by id", e);
	}
	return book;
    }

    public Book getBook(String isbn) {
	Book book = null;
	try {
	    book = (Book) entityManager.createQuery("select b from Book b where b.isbn = :isbn")
		    .setParameter("isbn", isbn).getSingleResult();
	} catch (Exception e) {
	    LOGGER.error("error getting book by isbn", e);
	}
	return book;
    }

    @SuppressWarnings("unchecked")
    public List<Book> getBooks(String query) {
	List<Book> book = null;
	try {
	    book = (List<Book>) entityManager.createQuery(
		    "select b from Book b where b.name like :name OR b.author like :author OR b.isbn like :isbn")
		    .setParameter("name", "%" + query + "%").setParameter("author", "%" + query + "%")
		    .setParameter("isbn", "%" + query + "%").getResultList();
	} catch (Exception e) {
	    LOGGER.error("error getting book by query", e);
	}
	return book;
    }

    public void deleteBook(Integer bookId) {
	try {
	    entityManager.createQuery("delet from Book b where b.bookId = :bookId").setParameter("bookId", bookId)
		    .executeUpdate();
	} catch (Exception e) {
	    LOGGER.error("error deleting book", e);
	}
    }

}
