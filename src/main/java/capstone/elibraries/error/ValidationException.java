package capstone.elibraries.error;

public class ValidationException extends ServerException {

    private String input;
    private String expected;

    public ValidationException(String input, String expected){
        this(null, input, expected);
    }

    public ValidationException(String redirect, String input, String expected){
        super(redirect);
        this.input = input;
        this.expected = expected;
    }

    public String getInput(){
        return this.input;
    }

    public String getExpected(){
        return this.expected;
    }

}
