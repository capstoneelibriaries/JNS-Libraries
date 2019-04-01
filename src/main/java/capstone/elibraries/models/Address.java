package capstone.elibraries.models;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

@Entity @Table(name = "addresses")
public class Address implements Cloneable {

    @Id @GeneratedValue
    private long id;
    @ManyToOne @JoinColumn(name = "user_id", nullable = false)
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

    public Address(HttpServletRequest req, String name){
        this.streetAddr = req.getParameter(String.format("%s-streetAddr", name));
        this.subAddr = req.getParameter(String.format("%s-subAddr", name));
        this.country = req.getParameter(String.format("%s-country", name));
        this.city = req.getParameter(String.format("%s-city", name));
        this.state = req.getParameter(String.format("%s-state", name));
        this.zipcode = req.getParameter(String.format("%s-zipcode", name));
        if(name.equals("billing")){
            this.billing = true;
        }
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

    public void setEmpty(){
        this.streetAddr = "";
        this.subAddr = "";
        this.country = "";
        this.state = "";
        this.city = "";
        this.zipcode = "";
    }

    public Address asEmpty(){
        this.setEmpty();
        return this;
    }

    public boolean isComplete(){
        if(this.streetAddr == null || this.subAddr == null || this.country == null || this.city == null){
            return false;
        }else if(this.streetAddr.equals("") || this.country.equals("") || this.city.equals("")){
            return false;
        }else if(this.country.equals("United States") && (this.state.equals("") || this.zipcode.equals(""))){
            return false;
        }else{
            return true;
        }
    }

    public String toJson(){
        this.streetAddr = (this.streetAddr == null) ? "" : this.streetAddr;
        this.subAddr = (this.subAddr == null) ? "" : this.subAddr;
        this.country = (this.streetAddr == null) ? "" : this.streetAddr;
        this.city = (this.city == null) ? "" : this.city;
        this.state = (this.state == null) ? "" : this.state;
        this.zipcode = (this.zipcode == null) ? "" : this.zipcode;

        return String.format("{" +
                "\"id\":\"%s\"," +
                "\"user\":\"%s\"," +
                "\"billing\":\"%s\"," +
                "\"address1\":\"%s\"," +
                "\"address2\":\"%s\"," +
                "\"country\":\"%s\"," +
                "\"city\":\"%s\"," +
                "\"state\":\"%s\"," +
                "\"zipcode\":\"%s\"" +
                "}", this.id, this.user.getId(),
                this.billing, this.streetAddr, this.subAddr,
                this.country, this.city, this.state, this.zipcode);
    }

    @Override
    public Address clone(){
        Address clone = new Address();
        clone.setStreetAddr(this.streetAddr);
        clone.setSubAddr(this.subAddr);
        clone.setCountry(this.country);
        clone.setState(this.state);
        clone.setCity(this.city);
        clone.setZipcode(this.zipcode);
        return clone;
    }
}