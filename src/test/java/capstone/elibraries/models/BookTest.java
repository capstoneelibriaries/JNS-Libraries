package capstone.elibraries.models;

import org.junit.Test;

public class BookTest {

    /*
    * @Id @GeneratedValue
    private long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String synopsis;
    @Column
    private String isbn;
    @Column
    private byte wear;
    // The image url is not set by the user. It should be
    // set automatically by javascript on through from the
    // client
    @Column
    private String imageUrl;*/

    private Book book;

    @Test
    public void testIdGetterReturnsSetValue(){
        book = new Book();
        book.setId();
    }

}
