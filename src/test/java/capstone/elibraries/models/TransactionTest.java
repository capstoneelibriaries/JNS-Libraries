package capstone.elibraries.models;

import capstone.elibraries.error.ValidationException;
import org.junit.Test;

import static capstone.elibraries.testhelpers.DataGenerator.randomLong;
import static org.junit.Assert.*;

public class TransactionTest {

    private Transaction trn;

//    @Test
//    public void getBuyer() {
//    }
//
//    @Test
//    public void setBuyer() {
//    }

    @Test(expected = ValidationException.class)
    public void testBuyerCannotBeNull() throws Exception{
        trn = new Transaction();
        trn.setBuyer(null);
    }

//    @Test
//    public void getSeller() {
//    }
//
//    @Test
//    public void setSeller() {
//    }

    @Test(expected = ValidationException.class)
    public void testSellerCannotBeNull() throws Exception {
        trn = new Transaction();
        trn.setSeller(null);
    }

//    @Test
//    public void getItem() {
//    }
//
//    @Test
//    public void setItem() {
//    }

    @Test(expected = ValidationException.class)
    public void testItemCannotBeNull() throws Exception {
        trn = new Transaction();
        trn.setItem(null);
    }

//    @Test
//    public void getDate() {
//    }
//
//    @Test
//    public void setDate() {
//    }

    @Test
    public void testDateIsSetByDefault() throws Exception {
        trn = new Transaction();

        assert(!trn.getDate().equals(null));
    }

    @Test(expected = ValidationException.class)
    public void testDateCannotBeNull() throws Exception {
        trn = new Transaction();
        trn.setDate(null);
    }

//    @Test
//    public void getId() {
//    }
//
//    @Test
//    public void setId() {
//    }

    @Test(expected = ValidationException.class)
    public void testIdCannotBeNegetive() throws Exception {
        trn = new Transaction();
        trn.setId(-1 * randomLong());
    }

//    @Test
//    public void getTrade() {
//    }
//
//    @Test
//    public void setTrade() {
//    }

    @Test(expected = ValidationException.class)
    public void testTradeCannotBeNull() throws Exception {
        trn = new Transaction();
        trn.setTrade(null);
    }
}