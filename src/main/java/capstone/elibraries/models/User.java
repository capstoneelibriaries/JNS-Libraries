package capstone.elibraries.models;

import capstone.elibraries.error.ValidationException;
import capstone.elibraries.error.Validator;

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

    @Column
    boolean isAdmin;

    @Column(nullable = false, length = VCHAR_CAP)
    private String username;

    @Column(nullable = false, length = VCHAR_CAP)
    private String email;

    @Column(nullable = false)
    private String password;
    private String confirmPassword;


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

    @Transient
    private ValidationException isvalid;

    public User(){
        // default
    }

    public User(User copy){
        this.id = copy.id;
        this.isAdmin = copy.isAdmin;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
        this.phone = copy.phone;
        this.rating = copy.rating;
        this.ads = copy.ads;
        this.addresses = copy.addresses;
        this.transactions = copy.transactions;
    }

    public User(boolean isAdmin,
                String username, String email, String password, String phone,
                double rating, List<Ad> ads,
                List<Address> address,
                List<Transaction> transactions)
    {
        this.isAdmin = isAdmin;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.rating = rating;
        this.ads = ads;
        this.addresses = address;
        this.transactions = transactions;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId(){
        return id;
    }

    public boolean isAdmin(){
        return isAdmin;
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

    public String getConfirmPassword(){
        return confirmPassword;
    }

    public double getRating(){
        return rating;
    }

    public List<Ad> getAds(){
        return ads;
    }

    public List<Address> getAddresses(){
        return addresses;
    }

    public Address getBillingAddress(){
        if(this.addresses == null){
            return null;
        }else{
            for(Address addr : this.addresses){
                if(addr.isBilling()){
                    return addr;
                }
            }
            return null;
        }
    }

    public Address getShippingAddress(){
        if(this.addresses == null){
            return null;
        }else{
            for(Address addr : this.addresses){
                if(!addr.isBilling()){
                    return addr;
                }
            }
            return null;
        }
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAdmin(boolean val){
        this.isAdmin = val;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setRating(Double rating){
        this.rating = rating;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public void setAddresses(List<Address> address){
        if(this.addresses == null){
            this.addresses = new ArrayList<>(2);
        }

        this.addresses = address;
        for(Address addr : address){
            addr.setUser(this);
        }
    }

    public void addAd(Ad ad) {
        if(this.ads == null){
            this.ads = new ArrayList<>(1);
        }
        this.ads.add(ad);
    }

    public void addTransaction(Transaction trn) {
        if(this.transactions == null){
            this.transactions = new ArrayList<>(1);
        }
        this.transactions.add(trn);
    }

    public boolean hasAddress(){
        if(this.addresses == null || this.addresses.get(0) == null || this.addresses.get(1) == null){
            return false;
        }
        return !(this.addresses.get(0).isComplete() && this.addresses.get(1).isComplete());
    }

    public boolean equals(User other){
        return (this.id == other.id) &&
                (this.username.equals(other.username)) &&
                (this.email.equals(other.email));
    }
}