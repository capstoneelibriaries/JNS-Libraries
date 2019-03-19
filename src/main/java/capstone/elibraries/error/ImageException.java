package capstone.elibraries.error;

public class ImageException extends ValidationException {

    public ImageException(String input, String expected){
        super(null, input, expected);
    }

}
