package capstone.elibraries.models;

import capstone.elibraries.error.IsbnException;
import capstone.elibraries.error.ValidationException;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

import static capstone.elibraries.testhelpers.DataGenerator.randomLong;
import static capstone.elibraries.testhelpers.DataGenerator.randomString;

public class BookTest {

    /*
    @Column
    private String imageUrl;*/

    private Book book;

    /*
    * id tests
    * */
    @Test
    public void testIdGetterReturnsSetValue(){
        long id = randomLong();

        book = new Book();
        book.setId(id);

        assert(id == book.getId());
    }

    @Test(expected = NumberFormatException.class)
    public void testIdCannotBeNegative(){
        long id = -1 * randomLong();

        book = new Book();
        book.setId(id);
    }

    /*
    * title tests
    * */
    @Test(expected = NullPointerException.class)
    public void testTitleCannotBeNull(){
        book = new Book();
        book.setTitle(null);
    }

    @Test(expected = ValidationException.class)
    public void testTitleCannotBeEmpty(){
        book = new Book();
        book.setTitle("");
    }

    @Test
    public void testTitleGetterReturnsSetValue(){
        String title = "lorem ipsum";

        book = new Book();
        book.setTitle(title);

        assert(book.getTitle().equals(title));
    }

    /*
    * author tests
    * */
    @Test(expected = NullPointerException.class)
    public void testAuthorCannotBeNull(){
        book = new Book();
        book.setAuthor(null);
    }

    @Test(expected = ValidationException.class)
    public void testAuthorCannotBeEmpty(){
        book = new Book();
        book.setAuthor("");
    }

    @Test
    public void testAuthorGetterReturnsSetValue(){
        String author = randomString(50);
        book = new Book();
        book.setAuthor(author);

        assert(book.getAuthor().equals(author));
    }

    /*
    * Synopsis Tests
    * */
    @Test(expected = NullPointerException.class)
    public void testSynopsisCannotBeNull(){
        book = new Book();
        book.setSynopsis(null);
    }

    @Test
    public void testSynopsisCanBeEmpty(){
        book = new Book();
        book.setSynopsis("");

        assert(book.getSynopsis().equals(""));
    }

    @Test
    public void testSynopsisGetterReturnsSetValue(){
        String synopsis = randomString(100);

        book = new Book();
        book.setSynopsis(synopsis);

        assert(book.getSynopsis().equals(synopsis));
    }

    /*
    * Isbn Tests
    * */
    @Test(expected = IsbnException.class)
    public void testIsbnCannotBeNull() throws Exception {
        book = new Book();
        book.setIsbn(null);
    }

    @Test(expected = IsbnException.class)
    public void testIsbnCannotBeEmpty() throws Exception {
        book = new Book();
        book.setIsbn("");
    }

    @Test(expected = IsbnException.class)
    public void testIsbnCannotBeLessThanTen() throws Exception{
        book = new Book();
        book.setIsbn(randomString(9));
    }

    @Test(expected = IsbnException.class)
    public void testIsbnCannotBeGreaterThanThirteen() throws Exception {
        book = new Book();
        book.setIsbn(randomString(14));
    }

    @Test(expected = IsbnException.class)
    public void testIsbnCannotBeEleven() throws Exception {
        book = new Book();
        book.setIsbn(randomString(11));
    }

    @Test(expected = IsbnException.class)
    public void testIsbnCannotBeTwelve() throws Exception {
        book = new Book();
        book.setIsbn(randomString(12));
    }

    @Test
    public void testIsbnCanBeTenDigits() throws Exception {
        String isbn = "0011231234";

        book = new Book();
        book.setIsbn(isbn);

        assert(book.getIsbn().equals(isbn));
    }

    @Test
    public void testIsbnCanBeThirteenDigits() throws Exception {
        String isbn = "0011231234555";

        book = new Book();
        book.setIsbn(isbn);

        assert(book.getIsbn().equals(isbn));
    }

    /*
    * Wear test
    * */
    @Test
    public void testWearIsOneByDefault() throws Exception {

        book = new Book();
        assert(book.getWear() == 1);
    }

    @Test(expected = ValidationException.class)
    public void testWearCannotBeZero() throws Exception {
        book = new Book();
        book.setWear((byte)0);
    }

    @Test(expected = ValidationException.class)
    public void testWearCannotBeGreaterThanFive() throws Exception {
        book = new Book();
        book.setWear((byte) 6);
    }

    @Test
    public void testWearGetterReturnsSetValue() throws Exception {

        book = new Book();

        for(byte i = 1; i < 6; i++){
            book.setWear(i);
            assert(book.getWear() == i);
        }
    }

    /*
    * image url test
    * */
    private final String defImage = "/images/bookexample.jpeg";

    @Test
    public void testNullImageDefaultsToDefaultImage() throws Exception {

        book = new Book();
        book.setImageUrl(null);

        assert(book.getImageUrl().equals(defImage));
    }

    @Test
    public void testEmptyImageDefualtsToDefualtImage() throws Exception {

        book = new Book();
        book.setImageUrl("");

        assert(book.getImageUrl().equals(defImage));
    }
}
