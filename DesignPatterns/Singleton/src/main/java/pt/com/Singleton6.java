package pt.com;

import java.time.LocalDateTime;

//Lazy Initialization
public class Singleton6 {
    private static final LocalDateTime localDateTime = LocalDateTime.now();
    private static Singleton6 instance;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            instance = new Singleton6();
        }

        return instance;
    }

    public String showMessage() {
        return "Singleton6 instance created at: " + localDateTime;
    }
}
