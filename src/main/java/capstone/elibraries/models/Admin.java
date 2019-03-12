package capstone.elibraries.models;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class Admin extends User {

    public Admin(){
        // default
    }

    public String toString(){
        return "";
    }
}