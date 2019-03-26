package capstone.elibraries.models;

import capstone.elibraries.error.ValidationException;
import org.junit.Test;

/*
* Tests for the Ad Class in isolation
* */

public class AdTest {

    private Ad ad;

    /*
    * id tests
    * */
    @Test(expected = NumberFormatException.class)
    public void adIdCannotBeNegative() throws Exception {
        ad = new Ad();
        ad.setId(-1);
    }

    @Test
    public void adIdGetterReturnsSetValue() throws Exception {
        // always use random numbers for these types of tests
        long id = (long)Math.abs(Math.random() * 100) + 1;

        ad = new Ad();
        ad.setId(id);
        assert(ad.getId() == id);
    }

    /*
    * price tests
    * */
    @Test(expected = NumberFormatException.class)
    public void adPriceCannotBeNegative() throws Exception {
        ad = new Ad();
        ad.setPrice(-1.00);
    }

    @Test
    public void adPriceGetterReturnsSetValue() throws Exception {
        double price = Math.abs(Math.random() * 100) + 1;

        ad = new Ad();
        ad.setPrice(price);

        assert(ad.getPrice() == price);
    }

    /*
    * shipping tests
    * */
    @Test(expected = NumberFormatException.class)
    public void adShippingCannotBeLessThanOne() throws Exception {
        ad = new Ad();
        ad.setPrice(0.99);
    }

    @Test(expected = NumberFormatException.class)
    public void adShippingCannotBeNegative() throws Exception {
        ad = new Ad();
        ad.setShipping(-2.00);
    }

    /*
    * title tests
    * */
    @Test(expected = NullPointerException.class)
    public void adTitleCannotBeNull() throws Exception {
        ad = new Ad();
        ad.setTitle(null);
    }

    @Test(expected = ValidationException.class)
    public void adTitleCannotBeEmpty() throws Exception {
        ad = new Ad();
        ad.setTitle("");
    }

    @Test
    public void adTitleReturnsInput() throws Exception {
        String title = "Lorem Ipsum Dolor Set";

        ad = new Ad();
        ad.setTitle(title);

        assert(ad.getTitle().equals(title));
    }

    @Test(expected = ValidationException.class)
    public void adTitleCannotBeOversized() throws Exception {
        StringBuilder oversizedTitle = new StringBuilder(2000);
        for(int i = 0; i < 2000; i++){
            oversizedTitle.append((char) ((i % 64) + 32) );
        }

        ad = new Ad();
        ad.setTitle(oversizedTitle.toString());
    }

    /*
    * description tests
    * */
    @Test(expected = NullPointerException.class)
    public void adDescriptionCannotBeNull() throws Exception {
        ad = new Ad();
        ad.setDescription(null);
    }

    @Test(expected = ValidationException.class)
    public void adDescriptionCannotBeEmpty() throws Exception {
        ad = new Ad();
        ad.setDescription("");
    }

    @Test
    public void adDescriptionReturnsInput() throws Exception {
        String description = "Lorem ipsum dolor sit amet" +
                ", consectetur adipiscing elit. Suspendisse" +
                " auctor imperdiet justo, vel luctus dui.";

        ad = new Ad();
        ad.setDescription(description);

        assert(ad.getDescription().equals(description));
    }

    @Test(expected = ValidationException.class)
    public void adDescriptionCannotBeOversized() throws Exception {
        StringBuilder description = new StringBuilder(5000);
        for(int i = 0; i < 5000; i++){
            description.append((char) ((i % 64) + 32) );
        }

        ad = new Ad();
        ad.setDescription(description.toString());
    }

}