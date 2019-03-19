package capstone.elibraries.error;

public class AuthenticationException extends ValidationException {

    public AuthenticationException(String input, String expected) {
        super(input, expected);
    }

}
