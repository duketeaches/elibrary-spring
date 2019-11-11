package duke.learn.elibrary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duke.learn.elibrary.data.model.Book;
import duke.learn.elibrary.service.BookService;
import duke.learn.elibrary.utils.Constants;
import duke.learn.elibrary.view.model.AddBookForm;

/**
 * 
 * @author Kazi
 *
 */
@Controller
public class BookController implements Constants {

    @Autowired
    private BookService bookService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping(path = ENDPOINT_BOOKS)
    public String books(@RequestParam(name = "id", required = false) Integer id,
	    @RequestParam(name = "query", required = false) String query) {
	List<Book> books = bookService.getBooks(query);
	request.setAttribute("books", books);
	return "book-gallery";
    }

    // @PostMapping(path = "/addBook")
    // public String addBook(@RequestParam(name = "image") MultipartFile imageFile,
    // @RequestParam(name = "content") MultipartFile file, @RequestParam Map<String,
    // Object> book) {
    // return books(null, null);
    // }

    @PostMapping(path = "/addBook")
    public String addBook(@ModelAttribute AddBookForm bookForm) {
	return books(null, null);
    }
}
