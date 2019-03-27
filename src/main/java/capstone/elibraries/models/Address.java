package capstone.elibraries.models;

import capstone.elibraries.error.ValidationException;
import capstone.elibraries.error.Validator;

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

    @Transient
    private ValidationException isvalid;

    public Address(){
        // default
    }

    public long getId() {
        return id;
    }

    public void setId(long id) throws ValidationException {

        Validator.throwIf(Validator.checkId(id));

        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) throws ValidationException {

        Validator.throwIf(Validator.checkNotNull(user));

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

    public void setStreetAddr(String streetAddr) throws ValidationException {

        Validator.throwIf(Validator.checkNotNullAndNotEmpty(streetAddr));

        this.streetAddr = streetAddr;
    }

    public String getSubAddr() {
        return subAddr;
    }

    public void setSubAddr(String subAddr) {
        if(subAddr == null){
            subAddr = "";
        }

        this.subAddr = subAddr;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws ValidationException{

        Validator.throwIf(Validator.checkNotNullAndNotEmpty(country));

        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws ValidationException {

        Validator.throwIf(Validator.checkNotNullAndNotEmpty(city));

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

        if(zipcode == null){
            zipcode = "";
        }

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