package models;

import java.util.List;

public class Book {

    private long id;
    private String title;
    private String author;
    private String snyopsis;
    private String isbn;
    private byte wear;
    private List<Genre> genres;

    public Book(){
        // default
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSnyopsis() {
        return snyopsis;
    }

    public void setSnyopsis(String snyopsis) {
        this.snyopsis = snyopsis;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public byte getWear() {
        return wear;
    }

    public void setWear(byte wear) {
        this.wear = wear;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

}