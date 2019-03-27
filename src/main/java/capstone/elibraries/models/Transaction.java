package capstone.elibraries.models;

import capstone.elibraries.error.ValidationException;
import capstone.elibraries.error.Validator;

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

    @Transient
    ValidationException isvalid;

    public Transaction(){
        this.date = new Date();
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

    public void setBuyer(User buyer) throws ValidationException {

        isvalid = Validator.checkNotNull(buyer);
        if(isvalid != null){
            throw isvalid;
        }

        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) throws ValidationException {

        isvalid = Validator.checkNotNull(seller);
        if(isvalid != null){
            throw isvalid;
        }
        this.seller = seller;
    }

    public Ad getItem() {
        return sellerItem;
    }

    public void setItem(Ad item) throws ValidationException {

        isvalid = Validator.checkNotNull(item);
        if(isvalid != null){
            throw isvalid;
        }

        this.sellerItem = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) throws ValidationException {

        isvalid = Validator.checkNotNull(date);
        if(isvalid != null){
            throw isvalid;
        }

        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) throws ValidationException {

        isvalid = Validator.checkId(id);
        if(isvalid != null){
            throw isvalid;
        }

        this.id = id;
    }

    public TradeRequest getTrade() {
        return trade;
    }

    public void setTrade(TradeRequest trade) throws ValidationException {

        isvalid = Validator.checkNotNull(trade);
        if(isvalid != null){
            throw isvalid;
        }

        this.trade = trade;
    }
}