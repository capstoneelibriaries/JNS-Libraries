package capstone.elibraries.testhelpers;

public class DataGenerator {

    public static long randomLong(){
        return (long)(Math.abs(Math.random() * 1000));
    }

    private static char randomAscii(){
        return (char)(Math.abs(Math.random() * 64) + 32);
    }

    public static String randomString(int len){
        StringBuilder rand = new StringBuilder(len);
        for(int i = 0; i < len; i++){
            rand.append(randomAscii());
        }
        return rand.toString();
    }

}
