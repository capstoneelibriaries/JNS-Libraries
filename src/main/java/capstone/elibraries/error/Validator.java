package capstone.elibraries.error;

public class Validator {

    public static boolean validateImageUrl(String imageUrl){
        if(imageUrl.endsWith(".jpeg") || imageUrl.endsWith(".jpg") || imageUrl.endsWith(".png")){
            return true;
        }
        return false;
    }

    public static ValidationException validateId(long id){
        if(id < 1){
            return new ValidationException("id greater than 1", "id of " + id);
        }else{
            return null;
        }
    }
}
