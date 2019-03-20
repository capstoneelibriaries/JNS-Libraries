package capstone.elibraries.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "ads")
public class Ad {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double shipping;

    @Column
    private boolean tradable;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToOne @JoinColumn (name = "user_id")
    private User seller;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="ads_books",
            joinColumns={@JoinColumn(name="ad_id")},
            inverseJoinColumns={@JoinColumn(name="book_id")}
    )
    private List<Book> books;

    public Ad(){
        // default
    }

    public Ad(User seller, double price, double shipping){
        this.seller = seller;
        seller.addAd(this);
        this.price = price;
        this.shipping = shipping;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getShipping(){
        return shipping;
    }

    public void setShipping(double shipping){
        this.shipping = shipping;
    }

    public boolean isTradable(){
        return tradable;
    }

    public void setTradable(boolean tradable){
        this.tradable = tradable;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
    
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        if(this.books == null){
            this.books = new ArrayList<>(1);
        }
        this.books.add(book);
        book.addAd(this);
    }

    // To String methods and helpers

    private String booksToString(){
        if(this.books == null){
            return "none";
        }else{
            String bks = "[";
            for(Book book : books){
                bks = book.toString() + ",";
            }
            bks += "]";
            return bks;
        }
    }

    public String toString(){
        return "{\n" +
                "\t\"price\":\"" + this.price + "\",\n" +
                "\t\"shipping\":\"" + this.shipping + "\",\n" +
//                "\ttradable:" + this.tradable + "\n" +
                "\t\"books\":\"" + this.booksToString() + "\",\n" +
                "}";
    }


}