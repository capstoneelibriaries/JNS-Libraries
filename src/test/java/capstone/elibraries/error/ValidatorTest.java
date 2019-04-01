package capstone.elibraries.error;

import org.junit.Test;

import static capstone.elibraries.testhelpers.DataGenerator.randomLong;
import static capstone.elibraries.testhelpers.DataGenerator.randomString;
import static org.junit.Assert.*;

public class ValidatorTest {

    private ValidationException ex;

//    @Test
//    public void validateImageUrl() {
//    }

//    @Test
//    public void checkId() {
//    }

    @Test
    public void testIdOfZeroAlwaysInvalid(){
        ex = Validator.checkId(0);
        assert(ex != null);
    }

    @Test
    public void testNegetiveIdAlwaysInvalid(){
        ex = Validator.checkId(-1 * randomLong());
        assert(ex != null);
    }

//    @Test
//    public void checkNotNull() {
//    }

    @Test
    public void testCheckNotNullAlwaysInvalidOnNull(){
        ex = Validator.checkNotNull(null);
        assert(ex != null);
    }

    @Test
    public void testCheckNotNullNeverInvalidOnObject(){
        ex = Validator.checkNotNull(new Object());
        assert(ex == null);
    }

//    @Test
//    public void checkNotEmpty() {
//    }

    @Test
    public void testCheckNotEmptyAlwaysInvalidOnEmptyString(){
        ex = Validator.checkNotEmpty("");
        assert(ex != null);
    }

    @Test
    public void testCheckNotEmptyAlwaysValidOnNonEmptyString(){
        ex = Validator.checkNotEmpty(randomString((int)randomLong()));
        assert(ex == null);
    }

    @Test
    public void testNullAndEmptyChain() throws Exception {
        String str = null;

        ex = Validator.check(Validator.checkNotNull(str))
                .andCheck(Validator.checkNotEmpty(str))
                .done();

        assert(ex != null);
    }

    @Test
    public void testEmptyAndNullChain() throws Exception {
        String str = "";

        ex = Validator.check(Validator.checkNotEmpty(str))
                .andCheck(Validator.checkNotNull(str))
                .done();
    }

//    @Test
//    public void checkLenLessThan() {
//    }
//
//    @Test
//    public void checkLenEquals() {
//    }
//
//    @Test
//    public void checkLenGreaterThan() {
//    }
//
//    @Test
//    public void checkDoubleGreaterThan() {
//    }
//
//    @Test
//    public void checkDoubleLessThan() {
//    }
//
//    @Test
//    public void checkDescription() {
//    }
//
//    @Test
//    public void checkTitle() {
//    }
//
//    @Test
//    public void checkShipping() {
//    }
//
//    @Test
//    public void checkPrice() {
//    }
//
//    @Test
//    public void check() {
//    }
//
//    @Test
//    public void andCheck() {
//    }
//
//    @Test
//    public void done() {
//    }
}