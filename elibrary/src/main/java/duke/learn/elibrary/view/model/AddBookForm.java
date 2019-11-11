/**
 * 
 */
package duke.learn.elibrary.view.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Kazi
 *
 */
public class AddBookForm implements CommonInput {

    private String name;
    private String author;
    private String isbn;
    private Integer year;
    private MultipartFile image;
    private MultipartFile content;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public String getIsbn() {
	return isbn;
    }

    public void setIsbn(String isbn) {
	this.isbn = isbn;
    }

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
	this.year = year;
    }

    public MultipartFile getImage() {
	return image;
    }

    public void setImage(MultipartFile image) {
	this.image = image;
    }

    public MultipartFile getContent() {
	return content;
    }

    public void setContent(MultipartFile content) {
	this.content = content;
    }

    @Override
    public String toString() {
	return "AddBookForm [name=" + name + ", author=" + author + ", isbn=" + isbn + ", year=" + year + "]";
    }

}
