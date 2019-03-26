package capstone.elibraries.models;

import capstone.elibraries.error.ValidationException;
import capstone.elibraries.testhelpers.DataGenerator;
import org.junit.Test;

import static capstone.elibraries.testhelpers.DataGenerator.randomLong;
import static capstone.elibraries.testhelpers.DataGenerator.randomString;

/*
* Tests for the User Class in isolation
* */
public class UserTest {

    private User user;

    /*
    * User Id tests
    * */
    @Test(expected = NumberFormatException.class)
    public void userIdCannotBeNegetive(){
        long badId = -1 * randomLong();

        user = new User();
        user.setId(badId);
    }

    @Test
    public void userIdGetterReturnsSetValue(){
        long id = randomLong();

        user = new User();
        user.setId(id);
        assert(user.getId() == id);
    }

    @Test
    public void userIdGetterReturnsZeroWhenNotInstantiated(){
        user = new User();
        assert(user.getId() == 0);
    }

    /*
    * User name tests
    * */
    @Test(expected = NullPointerException.class)
    public void userNameCannotBeNull(){
        user = new User();
        user.setUsername(null);
    }

    @Test(expected = ValidationException.class)
    public void userNameCannotBeEmpty(){
        user = new User();
        user.setUsername("");
    }

    @Test(expected = ValidationException.class)
    public void userNameCannotBeOversized(){
        user = new User();
        user.setUsername(randomString(200));
    }

    /*
    * User email tests
    * */
    @Test(expected = NullPointerException.class)
    public void userEmailCannotBeNull(){
        user = new User();
        user.setEmail(null);
    }

    @Test(expected = ValidationException.class)
    public void userEmailCannotBeEmpty(){
        user = new User();
        user.setEmail("");
    }

    @Test(expected = ValidationException.class)
    public void userEmailMustBeValidAddress(){
        user = new User();
        user.setEmail("loremipsumdolor");
    }

    @Test(expected = ValidationException.class)
    public void userEmailMustEndInDotString(){
        user = new User();
        user.setEmail("alice@email-com");
    }

    @Test(expected = Exception.class)
    public void userEmailMustHaveCharsBeforeAtSign(){
        user = new User();
        user.setEmail("@email.com");
    }

    @Test
    public void userEmailGetterRetunsSetValue(){
        String email = "bob@email.com";

        user = new User();
        user.setEmail(email);

        assert(user.getEmail().equals(email));
    }

    /*
    * Tests for phone input
    * */
    @Test(expected = ValidationException.class)
    public void userPhoneCannotBeEmpty(){
        user = new User();
        user.setPhone("");
    }

    @Test(expected = ValidationException.class)
    public void userPhoneCannotBeLessThanTenNumbers(){
        user = new User();
        user.setPhone("120333476");
    }

    @Test(expected = ValidationException.class)
    public void userPhoneDoesNotAcceptLetters(){
        user = new User();
        user.setPhone("210444AABF");
    }

    @Test
    public void userPhoneAcceptsRemovesDashes(){
        user = new User();
        user.setPhone("1-210-322-7722");

        assert(user.getPhone().equals("12103227722"));
    }

    @Test
    public void userPhoneAcceptsAndRemovesPeriods(){
        user = new User();
        user.setPhone("1.210.332.7722");

        assert(user.getPhone().equals("1203327722"));
    }

    @Test
    public void userPhoneAcceptsAndRemovedParenthesis(){
        user = new User();
        user.setPhone("1-(210)-332-7722");

        assert(user.getPhone().equals("1203327722"));
    }
}
