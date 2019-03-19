package capstone.elibraries.error;

public class ServerException extends Exception {

    private String redirect;

    public ServerException(){
        this.redirect = "404";
    }

    public ServerException(String redirect){
        if(redirect == null){
            this.redirect = "404";
        }else{
            this.redirect = redirect;
        }
    }

    public void setRedirect(String redirect){
        this.redirect = redirect;
    }

    public void setRedirect(int httpStatus){
        this.redirect = "" + httpStatus;
    }

    public String getRedirect(){
        return this.redirect;
    }

}
