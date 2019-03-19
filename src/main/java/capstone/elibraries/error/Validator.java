package capstone.elibraries.error;

public class Validator {

    public static boolean validateImageUrl(String imageUrl){
        if(imageUrl.endsWith(".jpeg") || imageUrl.endsWith(".jpg") || imageUrl.endsWith(".png")){
            return true;
        }
        return false;
    }

}
