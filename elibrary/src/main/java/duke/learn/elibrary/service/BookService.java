/**
 * 
 */
package duke.learn.elibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duke.learn.elibrary.data.BookRepository;
import duke.learn.elibrary.data.model.Book;

/**
 * @author Kazi
 *
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks(String query) {
	List<Book> books = null;
	query = query == null ? "" : query;
	books = bookRepository.getBooks(query);
	return books;
    }

}
