package capstone.elibraries.error;

public class ValidationException extends ServerException {

    protected String input;
    protected String expected;

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

    public String toString(){
        return "{\n" +
                "\t\"input\":\"" + input + "\",\n" +
                "\t\"expected\":\"" + expected + "\",\n" +
                "\t\"response\":\"" + this.redirect + "\",\n" +
                "}";
    }
}
