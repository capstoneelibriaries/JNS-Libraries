package capstone.elibraries.models;

import capstone.elibraries.error.ValidationException;
import org.junit.Test;

import static capstone.elibraries.testhelpers.DataGenerator.randomLong;
import static org.junit.Assert.*;

public class TradeRequestTest {

    private TradeRequest tr;

//    @Test
//    public void getId() {
//    }
//
//    @Test
//    public void setId() {
//    }

    @Test(expected = ValidationException.class)
    public void testIdCannotBeNegetive() throws Exception {
        tr = new TradeRequest();
        tr.setId(-1 * randomLong());
    }

//    @Test
//    public void getTo() {
//    }
//
//    @Test
//    public void setTo() {
//    }

    @Test(expected = ValidationException.class)
    public void testToCannotBeNull() throws Exception {
        tr = new TradeRequest();
        tr.setTo(null);
    }

//    @Test
//    public void getFrom() {
//    }
//
//    @Test
//    public void setFrom() {
//    }

    @Test(expected = ValidationException.class)
    public void testFromCannotBeNull() throws Exception {
        tr = new TradeRequest();
        tr.setFrom(null);
    }

//    @Test
//    public void getForSale() {
//    }
//
//    @Test
//    public void setForSale() {
//    }

    @Test(expected = ValidationException.class)
    public void testForSaleCannotBeNull() throws Exception {
        tr = new TradeRequest();
        tr.setForSale(null);
    }

//    @Test
//    public void getWanted() {
//    }
//
//    @Test
//    public void setWanted() {
//    }

    @Test(expected = ValidationException.class)
    public void testWantedCannotBeNull() throws Exception {
        tr = new TradeRequest();
        tr.setWanted(null);
    }

//    @Test
//    public void isPending() {
//    }
//
//    @Test
//    public void setPending() {
//    }

    @Test
    public void testIsPendingGetterReturnsSetValue() throws Exception {
        tr = new TradeRequest();
        tr.setPending(true);
        assert(tr.isPending());
    }
}