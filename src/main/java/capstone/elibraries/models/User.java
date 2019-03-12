package capstone.elibraries.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    // user ratings are in a range from 0 to 5
    public static final double MAX_RATING = 5.0;
    public static final double MIN_RATING = 0.0;
    // max length of a phone number
    public static final int PHONE_CAP = 20;
    // max length of other vchar columns
    public static final int VCHAR_CAP = 128;

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = VCHAR_CAP)
    private String username;

    @Column(nullable = false, length = VCHAR_CAP)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = PHONE_CAP)
    private String phone;

    @Column
    public double rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
    private List<Ad> ads;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Address> addresses;

    @Transient
    private List<Transaction> transactions;

    public User(){
        // default
    }

    public long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public String getPassword(){
        return password;
    }

    public double getRating(){
        return rating;
    }

    public List<Ad> getAds(){
        return ads;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setRating(Double rating){
        this.rating = rating;
    }

    public void setAds(List<Ad> ads){
        this.ads = ads;
    }

    public void setAddresses(List<Address> addresses){
        this.addresses = addresses;
    }

    public void addAddress(Address address){
        if(this.addresses == null){
            this.addresses = new ArrayList<>(1);
        }
        this.addresses.add(address);
    }

    public void addAd(Ad ad){
        this.ads.add(ad);
    }

    public void addTransaction(Transaction trn){
        if(this.transactions == null){
            this.transactions = new ArrayList<>(1);
        }
        this.transactions.add(trn);
    }

    public String toString(){
        return "{\n" +
                "\tusername:" + username + ",\n" +
                "\temail:" + email + ",\n" +
                "\tphone:" + phone + ",\n" +
                "\tpassword:" + password + ",\n" +
                "\trating:" + rating + ",\n" +
                "\tads:" + ads.toString() + ",\n" +
                "}";
    }
}