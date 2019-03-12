package capstone.elibraries.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double shipping;

    @Column
    private boolean trabable;

    @ManyToOne
    @JoinColumn (name = "user_id")
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

    public boolean isTrabable(){
        return trabable;
    }

    public void setTrabable(boolean trabable){
        this.trabable = trabable;
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

    public String toString(){
        return "{\n" +
                "\tid:" + this.id + "\n" +
                "\tprice:" + this.price + "\n" +
                "\tshipping:" + this.shipping + "\n" +
                "\ttradable:" + this.trabable + "\n" +
                "}";
    }
}