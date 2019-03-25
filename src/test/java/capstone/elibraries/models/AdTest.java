package capstone.elibraries.models;

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
    public void adIdCannotBeNegative() {
        ad = new Ad();
        ad.setId(-1);
    }

    @Test
    public void adIdGetterReturnsSetValue(){
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
    public void adPriceCannotBeNegative() {
        ad = new Ad();
        ad.setPrice(-1.00);
    }

    @Test
    public void adPriceGetterReturnsSetValue(){
        double price = Math.abs(Math.random() * 100) + 1;

        ad = new Ad();
        ad.setPrice(price);

        assert(ad.getPrice() == price);
    }

    /*
    * shipping tests
    * */
    @Test(expected = NumberFormatException.class)
    public void adShippingCannotBeLessThanOne(){
        ad = new Ad();
        ad.setPrice(0.99);
    }

    @Test(expected = NumberFormatException.class)
    public void adShippingCannotBeNegative(){
        ad = new Ad();
        ad.setShipping(-2.00);
    }

    /*
    * title tests
    * */
    @Test(expected = NullPointerException.class)
    public void adTitleCannotBeNull(){
        ad = new Ad();
        ad.setTitle(null);
    }

    @Test(expected = Exception.class)
    public void adTitleCannotBeEmpty(){
        ad = new Ad();
        ad.setTitle("");
    }

    @Test
    public void adTitleReturnsInput(){
        String title = "Lorem Ipsum Dolor Set";

        ad = new Ad();
        ad.setTitle(title);

        assert(ad.getTitle().equals(title));
    }

    @Test(expected = Exception.class)
    public void adTitleCannotBeOversized(){
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
    public void adDescriptionCannotBeNull(){
        ad = new Ad();
        ad.setDescription(null);
    }

    @Test(expected = Exception.class)
    public void adDescriptionCannotBeEmpty(){
        ad = new Ad();
        ad.setDescription("");
    }

    @Test
    public void adDescriptionReturnsInput(){
        String description = "Lorem ipsum dolor sit amet" +
                ", consectetur adipiscing elit. Suspendisse" +
                " auctor imperdiet justo, vel luctus dui.";

        ad = new Ad();
        ad.setDescription(description);

        assert(ad.getDescription().equals(description));
    }

    @Test(expected = Exception.class)
    public void adDescriptionCannotBeOversized(){
        StringBuilder description = new StringBuilder(5000);
        for(int i = 0; i < 5000; i++){
            description.append((char) ((i % 64) + 32) );
        }

        ad = new Ad();
        ad.setDescription(description.toString());
    }

}