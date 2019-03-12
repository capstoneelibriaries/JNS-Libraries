package capstone.elibraries.models;

import javax.persistence.*;

@Entity @Table(name = "addresses")
public class Address {

    @Id @GeneratedValue
    private long id;
    @ManyToOne @JoinColumn(name = "addresses")
    private User user;
    @Column
    private boolean billing;
    @Column
    private String streetAddr;
    @Column
    private String subAddr;
    @Column
    private String country;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zipcode;

    public Address(){
        // default
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isBilling() {
        return billing;
    }

    public void setBilling(boolean billing) {
        this.billing = billing;
    }

    public String getStreetAddr() {
        return streetAddr;
    }

    public void setStreetAddr(String streetAddr) {
        this.streetAddr = streetAddr;
    }

    public String getSubAddr() {
        return subAddr;
    }

    public void setSubAddr(String subAddr) {
        this.subAddr = subAddr;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String toString(){
        return "{\n" +
                "\tid:" + id + "\n" +
                "\tuser:" + user.toString() + "\n" +
                "\tbilling:" + billing + "\n" +
                "\taddress1:" + streetAddr + "\n" +
                "\taddress2:" + subAddr + "\n" +
                "\tcountry:" + country + "\n" +
                "\tcity:" + city + "\n" +
                "\tstate:" + state + "\n" +
                "\tzipcode:" + zipcode + "\n" +
                "}";
    }

}