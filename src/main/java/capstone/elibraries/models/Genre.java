package capstone.elibraries.models;

import javax.persistence.*;
import java.util.List;

@Entity @Table(name = "genres")
public class Genre {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String genre;

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

    public String toString(){
        return this.genre;
    }
}