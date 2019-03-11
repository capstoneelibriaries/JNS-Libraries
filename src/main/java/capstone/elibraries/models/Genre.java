package capstone.elibraries.models;

public class Genre {

    private String genre;

    public Genre(){
        // default
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String toString(){
        return this.genre;
    }
}