package capstone.elibraries.models;

import org.junit.Test;

/*
* Tests for the User Class in isolation
* */
public class UserTest {

    private User user;

    private long randomLong(){
        return (long)(Math.abs(Math.random() * 1000));
    }

    private char randomAscii(){
        return (char)(Math.abs(Math.random() * 64) + 32);
    }

    private String randomString(int len){
        StringBuilder rand = new StringBuilder(len);
        for(int i = 0; i < len; i++){
            rand.append(randomAscii());
        }
        return rand.toString();
    }

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

    @Test(expected = Exception.class)
    public void userNameCannotBeEmpty(){
        user = new User();
        user.setUsername("");
    }

    @Test(expected = Exception.class)
    public void userNameCannotBeOversized(){
        user = new User();
        user.setUsername(randomString(200));
    }
}
