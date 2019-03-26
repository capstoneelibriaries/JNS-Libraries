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

}
