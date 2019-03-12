package capstone.elibraries.models;

public class Ad {

    private long id;
    private double price;
    private double shipping;
    private boolean trabable;

    private User seller;
    private Book books;

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

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
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

    public String toString(){
        return "{\n" +
                "\tid:" + this.id + "\n" +
                "\tprice:" + this.price + "\n" +
                "\tshipping:" + this.shipping + "\n" +
                "\ttradable:" + this.trabable + "\n" +
                "}";
    }
}