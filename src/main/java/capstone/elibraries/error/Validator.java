package capstone.elibraries.error;

public class Validator {

    public static boolean validateImageUrl(String imageUrl){
        if(imageUrl.endsWith(".jpeg") || imageUrl.endsWith(".jpg") || imageUrl.endsWith(".png")){
            return true;
        }
        return false;
    }

    public static ValidationException checkId(long id){
        if(id < 1){
            return new ValidationException("id of " + id, "id greater than 1");
        }else{
            return null;
        }
    }

    public static ValidationException checkNotNull(Object obj){
        if(obj == null){
            return new ValidationException("null", "not null");
        }else{
            return null;
        }
    }

    public static ValidationException checkNotEmpty(String str){
        if(str.equals("")){
            return new ValidationException("empty string", "some text");
        }else{
            return null;
        }
    }

    public static ValidationException checkLenLessThan(String str, int len){
        if(!(str.length() < len)){
            return new ValidationException(
                    "string of length less than " + len,
                    "string of length " + str.length()
             );
        }
        return null;
    }

    public static ValidationException checkLenEquals(String str, int len){
        if(str.length() != len){
            return new ValidationException(
                    "string of length " + len,
                    "string of length " + str.length()
            );
        }
        return null;
    }

    public static ValidationException checkLenGreaterThan(String str, int len){
        if(!(str.length() > len)){
            return new ValidationException(
                    "string of length " + len,
                    "string of length " + str.length()
            );
        }
        return null;
    }

    public static ValidationException checkDoubleGreaterThan(double val, double compare){
        if(!(val > compare)){
            return new ValidationException(
                    "value greater than " + compare,
                    "value of " + val
            );
        }
        return null;
    }

    public static ValidationException checkDoubleLessThan(double val, double compare){
        if(!(val < compare)){
            return new ValidationException(
                    "value less than " + compare,
                    "value of " + val
            );
        }
        return null;
    }

    public static ValidationException checkDescription(String description) {
        return check(checkNotNull(description))
                .andCheck(checkNotEmpty(description))
                .done();
    }

    public static ValidationException checkTitle(String title) {
        return check(checkNotNull(title))
                .andCheck(checkNotEmpty(title))
                .done();
    }

    public static ValidationException checkShipping(double shipping) {
        return check(checkDoubleGreaterThan(shipping, 0.00))
                .andCheck(checkDoubleLessThan(shipping,9999.99))
                .done();
    }

    public static ValidationException checkPrice(double price) {
        return check(checkDoubleGreaterThan(price, 0.99))
                .andCheck(checkDoubleLessThan(price, 9999.99))
                .done();
    }

    public static Validator check(ValidationException e){
        return new Validator(e);
    }

    private ValidationException ex;

    public Validator(ValidationException e){
        this.ex = e;
    }

    public Validator andCheck(ValidationException e){
        if(this.ex == null && e != null){
            this.ex = e;
        }
        return this;
    }

    public ValidationException done(){
        return this.ex;
    }
}
