package capstone.elibraries.models;

import java.util.Date;
import javax.persistence.*;

@Entity @Table(name = "transactions")
public class Transaction {

    @Id @GeneratedValue
    private long id;
    @Transient
    private User buyer;
    @Transient
    private User seller;
    @OneToOne
    private Ad item;
    @OneToOne
    private TradeRequest trade;
    @Column
    private Date date;

    public Transaction(){
        //default
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
        return item;
    }

    public void setItem(Ad item) {
        this.item = item;
    }

    public TradeRequest getTradeRequest() {
        return trade;
    }

    public void setTradeRequest(TradeRequest trade) {
        this.trade = trade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}