package capstone.elibraries.models;

import java.util.Date;
import javax.persistence.*;

@Entity @Table(name = "transactions")
public class Transaction {

    @Id @GeneratedValue
    private long id;
    @OneToOne
    private User buyer;
    @OneToOne
    private User seller;
    @OneToOne
    private Ad sellerItem;
    @OneToOne
    private TradeRequest trade;
    @Column
    private Date date;

    public Transaction(){
        //default
    }

    public Transaction(User buyer, User seller, Ad sellerItem, TradeRequest trade, Date date) {
        this.buyer = buyer;
        this.seller = seller;
        this.sellerItem = sellerItem;
        this.trade = trade;
        this.date = date;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Ad getItem() {
        return sellerItem;
    }

    public void setItem(Ad item) {
        this.sellerItem = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TradeRequest getTrade() {
        return trade;
    }

    public void setTrade(TradeRequest trade) {
        this.trade = trade;
    }
}