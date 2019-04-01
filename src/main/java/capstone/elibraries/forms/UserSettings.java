package capstone.elibraries.forms;

import capstone.elibraries.models.User;

public class UserSettings {

    private String username;
    private String email;
    private String phone;
    private String newpass;
    private String confnewpass;

    public UserSettings(){
        // default
    }

    public UserSettings(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.newpass = "";
        this.confnewpass = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getConfnewpass() {
        return confnewpass;
    }

    public void setConfnewpass(String confnewpass) {
        this.confnewpass = confnewpass;
    }

}
