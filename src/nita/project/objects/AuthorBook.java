/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.objects;

/**
 *
 * @author Anil Bhaskar
 */  
public class AuthorBook {
    private Book book;
    private Author author;
    private Branch branch;
    private BookIndividual bi;

    public void setBi(BookIndividual bi) {
        this.bi = bi;
    }

    public BookIndividual getBi() {
        return bi;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    

}
