package capstone.elibraries.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity @Table(name = "books")
public class Book {

    @Id @GeneratedValue
    private long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String synopsis;
    @Column
    private String isbn;
    @Column
    private byte wear;
    // The image url is not set by the user. It should be
    // set automatically by javascript on through from the
    // client
    @Column
    private String imageUrl;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="genres_books",
            joinColumns={@JoinColumn(name="book_id")},
            inverseJoinColumns={@JoinColumn(name="genre_id")}
    )
    private List<Genre> genres;

    @ManyToMany(mappedBy = "books")
    private List<Ad> ads;

    public Book(){
        // default
    }

    public Book(String isbn, String title, String author, String synopsis, byte wear){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.synopsis = synopsis;
        this.wear = wear;
    }
    /*
    * Getters
    * */
    public long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public byte getWear() {
        return wear;
    }
    /*
    * Setters
    * */
    public void setId(long id) {
        if(id < 1){
            // TODO: throw exception
        }else{
            this.id = id;
        }
    }

    public void setIsbn(String isbn) {
        if(isbn == null || isbn.length() < 10){
            // TODO: throw exception
        }else{
            this.isbn = isbn;
        }
    }

    public void setTitle(String title) {
        if(title == null){
           this.title = "";
        }else{
            this.title = title;
        }
    }

    public void setAuthor(String author) {
        if(author == null){
            this.author = "";
        }else{
            this.author = author;
        }
    }

    public void setSynopsis(String synopsis) {
        if(synopsis == null){
            this.synopsis = "";
        }else{
            this.synopsis = synopsis;
        }
    }
    // In the setter, defualt to the book example image
    // when no image is provided.
    public void setImageUrl(String imageUrl){
        if(imageUrl == null || imageUrl.equals("")){
            this.imageUrl = "/images/bookexample.jpeg";
        }else{
            this.imageUrl = imageUrl;
        }
    }

    public void setWear(byte wear) {
        if(wear < 0 || wear > 5){
            // TODO: throw exception
        }else{
            this.wear = wear;
        }
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre){
        if(this.genres == null){
            this.genres = new ArrayList<>(1);
        }else if(genre == null){
            // TODO: throw exception
        }
        this.genres.add(genre);
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public void adAd(Ad ad){
        if(this.ads == null){
            this.ads = new ArrayList<>(1);
        }else if(ad == null){
            // TODO: throw exception
        }
        this.ads.add(ad);
    }

    // Default object methods
    public String toString(){
        return "{\n" +
                "\tisbn: " + isbn + ",\n" +
                "\ttitle: " + title + ",\n" +
                "\tauthor: " + author + ",\n" +
                "\tsynopsis: " + synopsis + ",\n" +
                "\timageUrl: " + imageUrl + ",\n" +
                "\tgenres: " + genres.toString() + ",\n" +
                "\tads: " + ads.toString() + ",\n" +
                "}";
    }
}