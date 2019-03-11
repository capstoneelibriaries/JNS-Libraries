package models;

public class Ad {

    private long id;
    private double price;
    private double shipping;
    private boolean trabable;

    private User seller;

    public Ad(){
        // default
    }

    public long getId(){
        return id;
    }

    public double getPrice(){
        return price;
    }

    public double getShipping(){
        return shipping;
    }

    public double getTotal(){
        return price + shipping;
    }

    public boolean isTrabable(){
        return trabable;
    }

    public User getSeller(){
        return seller;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setShipping(double shipping){
        this.shipping = shipping;
    }

    public void setTrabable(boolean trabable){
        this.trabable = trabable;
    }

    public void setSeller(User seller){
        this.seller = seller;
    }
}