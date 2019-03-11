package models;

public class TradeRequest {

    private long id;
    private User to;
    private User from;
    private Ad forSale;
    private Ad wanted;


    public TradeRequest(){
        // default
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public Ad getForSale() {
        return forSale;
    }

    public void setForSale(Ad forSale) {
        this.forSale = forSale;
    }

    public Ad getWanted() {
        return wanted;
    }

    public void setWanted(Ad wanted) {
        this.wanted = wanted;
    }

}