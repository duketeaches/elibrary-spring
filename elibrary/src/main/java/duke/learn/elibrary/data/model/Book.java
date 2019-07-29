package duke.learn.elibrary.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Kazi
 *
 */

@Entity
@Table(name = "books")
public class Book implements Serializable {

    private static final long serialVersionUID = 5106313397494383919L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private Integer year;

    @Column
    private String isbn;

    public Integer getBookId() {
	return bookId;
    }

    public void setBookId(Integer bookId) {
	this.bookId = bookId;
    }

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

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
	this.year = year;
    }

    public String getIsbn() {
	return isbn;
    }

    public void setIsbn(String isbn) {
	this.isbn = isbn;
    }

    @Override
    public String toString() {
	return "Book [bookId=" + bookId + ", name=" + name + ", author=" + author + ", year=" + year + ", isbn=" + isbn
		+ "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((author == null) ? 0 : author.hashCode());
	result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
	result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((year == null) ? 0 : year.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Book other = (Book) obj;
	if (author == null) {
	    if (other.author != null)
		return false;
	} else if (!author.equals(other.author))
	    return false;
	if (bookId == null) {
	    if (other.bookId != null)
		return false;
	} else if (!bookId.equals(other.bookId))
	    return false;
	if (isbn == null) {
	    if (other.isbn != null)
		return false;
	} else if (!isbn.equals(other.isbn))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (year == null) {
	    if (other.year != null)
		return false;
	} else if (!year.equals(other.year))
	    return false;
	return true;
    }

}
