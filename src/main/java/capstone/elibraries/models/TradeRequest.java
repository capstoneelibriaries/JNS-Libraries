package capstone.elibraries.models;
import javax.persistence.*;

@Entity @Table(name = "trade_requests")
public class TradeRequest {

    @Id @GeneratedValue
    private long id;
    @OneToOne
    private User to;
    @OneToOne
    private User from;
    @OneToOne
    private Ad forSale;
    @OneToOne
    private Ad wanted;

    public TradeRequest(){
        // default
    }

    public TradeRequest(User to, User from, Ad forSale, Ad wanted) {
        this.to = to;
        this.from = from;
        this.forSale = forSale;
        this.wanted = wanted;
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