package capstone.elibraries.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String genre;

    @ManyToMany(mappedBy = "genre")
    private List<Book> books;

    public Genre(){
        // default
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String toString(){
        return this.genre;
    }
}