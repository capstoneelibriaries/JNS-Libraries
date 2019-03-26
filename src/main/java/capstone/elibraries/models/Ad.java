package capstone.elibraries.models;

import capstone.elibraries.error.ValidationException;
import capstone.elibraries.error.Validator;

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

    @Column(nullable = false, length = 128, name = "ad_title")
    private String adTitle;

    @Column(nullable = false, length = 512)
    private String description;

    @ManyToOne @JoinColumn (name = "user_id", nullable = false)
    private User seller;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="ads_books",
            joinColumns={@JoinColumn(name="ad_id")},
            inverseJoinColumns={@JoinColumn(name="book_id")}
    )
    private List<Book> books;

    @Transient
    ValidationException isvalid;

    public Ad(){
        this.books = new ArrayList<>(0);
        // DEFAULT
    }

    public Ad(User seller, String title, String description, double price, double shipping)
        throws ValidationException
    {
        this();
        this.seller = seller;
        this.adTitle = title;
        this.description = description;
        seller.addAd(this);
        this.price = price;
        this.shipping = shipping;
    }

    public long getId(){
        return id;
    }

    public void setId(long id) throws ValidationException {

        isvalid = Validator.checkId(id);
        if(isvalid != null){
            throw isvalid;
        }

        this.id = id;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price) throws ValidationException {

        isvalid = Validator.checkPrice(price);
        if(isvalid != null){
            throw isvalid;
        }

        this.price = price;
    }

    public double getShipping(){
        return shipping;
    }

    public void setShipping(double shipping) throws ValidationException {

        isvalid = Validator.checkShipping(shipping);
        if(isvalid != null){
            throw isvalid;
        }

        this.shipping = shipping;
    }

    public boolean isTradable(){
        return tradable;
    }

    public void setTradable(boolean tradable){
        this.tradable = tradable;
    }

    public void setTitle(String title) throws ValidationException {

        isvalid = Validator.checkTitle(title);
        if(isvalid != null){
            throw isvalid;
        }

        this.adTitle = title;
    }

    public String getTitle(){
        return this.adTitle;
    }

    public void setDescription(String description) throws ValidationException {

        isvalid = Validator.checkDescription(description);
        if(isvalid != null){
            throw isvalid;
        }
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

    public void addBook(Book book) throws ValidationException {

        isvalid = Validator.checkNotNull(book);
        if(isvalid != null){
            throw isvalid;
        }

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