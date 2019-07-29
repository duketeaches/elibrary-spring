/**
 * 
 */
package duke.learn.elibrary.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import duke.learn.elibrary.data.model.Book;

/**
 * @author Kazi
 *
 */
public class BookRepository {

    private final static Logger LOGGER = LoggerFactory.getLogger(BookRepository.class);

    @PersistenceContext(unitName = "entityManager")
    private EntityManager entityManager;

    Book addUpdateBook(Book book) {
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

    Book getBook(Integer bookId) {
	Book book = null;
	try {
	    book = (Book) entityManager.createQuery("select b from Book b where b.bookId = :bookId")
		    .setParameter("bookId", bookId).getSingleResult();
	} catch (Exception e) {
	    LOGGER.error("error getting book by id", e);
	}
	return book;
    }

    Book getBook(String isbn) {
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
    List<Book> getBooks(String query) {
	List<Book> book = null;
	try {
	    book = (List<Book>) entityManager.createQuery(
		    "select b from Book b where b.name like :name OR b.author like :author OR b.year like :year  OR b.isbn like :isbn")
		    .setParameter("name", "%" + query + "%").setParameter("author", "%" + query + "%")
		    .setParameter("year", "%" + query + "%").setParameter("isbn", "%" + query + "%").getResultList();
	} catch (Exception e) {
	    LOGGER.error("error getting book by query", e);
	}
	return book;
    }

    void deleteBook(Integer bookId) {
	try {
	    entityManager.createQuery("delet from Book b where b.bookId = :bookId").setParameter("bookId", bookId)
		    .executeUpdate();
	} catch (Exception e) {
	    LOGGER.error("error deleting book", e);
	}
    }

}
