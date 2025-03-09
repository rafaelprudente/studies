package pt.com;

import java.time.LocalDateTime;

//Static Block Initialization
public class Singleton4 {
    private static final LocalDateTime localDateTime = LocalDateTime.now();
    private static final Singleton4 instance;

    private Singleton4() {
    }

    static {
        instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return instance;
    }

    public String showMessage() {
        return "Singleton4 instance created at: " + localDateTime;
    }
}
