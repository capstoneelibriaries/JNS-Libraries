package capstone.elibraries.models;
import capstone.elibraries.error.ValidationException;
import capstone.elibraries.error.Validator;

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
    @Column(name = "pending")
    private boolean pending;

    @Transient
    private ValidationException isvalid;

    public TradeRequest(){
        // default
    }

    public TradeRequest(User to, User from, Ad forSale, Ad wanted, boolean pending) {
        this.to = to;
        this.from = from;
        this.forSale = forSale;
        this.wanted = wanted;
        this.pending = pending;
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

    public User getTo() {
        return to;
    }

    public void setTo(User to) throws ValidationException {

        isvalid = Validator.checkNotNull(to);
        if(isvalid != null){
            throw isvalid;
        }

        this.to = to;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) throws ValidationException {

        isvalid = Validator.checkNotNull(from);
        if(isvalid != null){
            throw isvalid;
        }

        this.from = from;
    }

    public Ad getForSale() {
        return forSale;
    }

    public void setForSale(Ad forSale) throws ValidationException {

        isvalid = Validator.checkNotNull(forSale);
        if(isvalid != null){
            throw isvalid;
        }

        this.forSale = forSale;
    }

    public Ad getWanted() {
        return wanted;
    }

    public void setWanted(Ad wanted) throws ValidationException {

        isvalid = Validator.checkNotNull(wanted);
        if(isvalid != null){
            throw isvalid;
        }

        this.wanted = wanted;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }
}