package capstone.elibraries.error;

public class IsbnException extends ValidationException {

    public IsbnException(String input, String expected){
        this(null, input, expected);
    }

    public IsbnException(String redirect, String input, String expected){
        super(redirect, input, expected);
    }

}
