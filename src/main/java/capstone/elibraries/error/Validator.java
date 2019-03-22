package capstone.elibraries.error;

public class Validator {

    public static boolean validateImageUrl(String imageUrl) {
        if (imageUrl.endsWith(".jpeg") || imageUrl.endsWith(".jpg") || imageUrl.endsWith(".png")) {
            return true;
        }
        return false;
    }

    public static boolean validateEmail(String email) {
        if (email.contains("@") ||
                email.contains(".com") ||
                email.endsWith(".com") ||
                email.endsWith(".net") ||
                email.endsWith(".org") ||
                email.endsWith(".gov") ||
                email.endsWith(".edu")) {
            return true;
        } else if (email.startsWith("@") ||
                email.startsWith(".") ||
                email.startsWith(",") ||
                email.startsWith(";") ||
                email.startsWith(":") ||
                email.contains("@.") ||
                email.contains("`") ||
                email.contains("~")
        ) {
            return false;
        }
        return false;
    }



}
