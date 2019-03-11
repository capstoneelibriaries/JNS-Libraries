package capstone.elibraries.models;

import java.util.Date;

public class Transaction {

    public Transaction(){
        //default
    }

    private User buyer;
    private User seller;
    private Ad item;
    private TradeRequest trade;
    private Date date;

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

    public TradeRequest getTrade() {
        return trade;
    }

    public void setTrade(TradeRequest trade) {
        this.trade = trade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}