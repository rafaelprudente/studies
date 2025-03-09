package pt.com;

import java.time.LocalDateTime;

//Public Static Field
public class Singleton7 {
    private static final LocalDateTime localDateTime = LocalDateTime.now();
    public static final Singleton7 instance=new Singleton7();

    private Singleton7() {
    }

    public String showMessage() {
        return "Singleton6 instance created at: " + localDateTime;
    }
}
