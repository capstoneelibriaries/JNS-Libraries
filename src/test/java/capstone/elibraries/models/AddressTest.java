package capstone.elibraries.models;

import capstone.elibraries.error.ValidationException;
import org.junit.Test;

import static capstone.elibraries.testhelpers.DataGenerator.randomLong;
import static org.junit.Assert.*;

public class AddressTest {

    private Address addr;

//    @Test
//    public void getId() {
//    }
//
//    @Test
//    public void setId() {
//    }

    @Test(expected = ValidationException.class)
    public void testIdCannotBeNegetive() {
        addr = new Address();
        addr.setId(-1 * randomLong());
    }

//    @Test
//    public void getUser() {
//    }
//
//    @Test
//    public void setUser() {
//    }

    @Test(expected = ValidationException.class)
    public void testUserCanotBeNull(){
        addr = new Address();
        addr.setUser(null);
    }

//    @Test
//    public void isBilling() {
//    }
//
//    @Test
//    public void setBilling() {
//    }
//
//    @Test
//    public void getStreetAddr() {
//    }
//
//    @Test
//    public void setStreetAddr() {
//    }

    @Test(expected = ValidationException.class)
    public void testStreetAddrCannotBeNull(){
        addr = new Address();
        addr.setStreetAddr(null);
    }

    @Test(expected = ValidationException.class)
    public void testStreetAddrCannotBeEmpty(){
        addr = new Address();
        addr.setStreetAddr("");
    }

//    @Test
//    public void getSubAddr() {
//    }
//
//    @Test
//    public void setSubAddr() {
//    }

    @Test
    public void testSubAddrReturnsEmptyStringOnNUllInput(){
        addr = new Address();
        addr.setSubAddr(null);

        assert(addr.getStreetAddr().equals(""));
    }

//    @Test
//    public void getCountry() {
//    }
//
//    @Test
//    public void setCountry() {
//    }

    @Test(expected = ValidationException.class)
    public void testCountryCannotBeNull(){
        addr = new Address();
        addr.setCountry(null);
    }

    @Test(expected = ValidationException.class)
    public void testCountryCannotBeEmpty(){
        addr = new Address();
        addr.setCountry("");
    }

//    @Test
//    public void getCity() {
//    }
//
//    @Test
//    public void setCity() {
//    }

    @Test
    public void testCityCannotBeNull(){
        addr = new Address();
        addr.setCity(null);
    }

    @Test
    public void testCityCannotBeEmpty(){
        addr = new Address();
        addr.setCity("");
    }

//    @Test
//    public void getState() {
//    }
//
//    @Test
//    public void setState() {
//    }

    @Test(expected = ValidationException.class)
    public void testStateCannotBeEmptyIfCountryIsUS(){
        addr = new Address();
        addr.setCountry("United States");
        addr.setState("");
    }

    @Test(expected = ValidationException.class)
    public void testStateIsEmptyIfSetToNull(){
        addr = new Address();
        addr.setState(null);

        assert(addr.getState().equals(""));
    }

//    @Test
//    public void getZipcode() {
//    }
//
//    @Test
//    public void setZipcode() {
//    }

    @Test
    public void testZipCodeReturnsEmptyIfSetToNull(){
        addr = new Address();
        addr.setZipcode(null);

        assert(addr.getZipcode().equals(""));
    }

//    @Test
//    public void toString() {
//    }
}