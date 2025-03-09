package pt.com;

import java.time.LocalDateTime;

//Eager Initialization
public class Singleton5 {
    private static final LocalDateTime localDateTime = LocalDateTime.now();
    private static final Singleton5 instance = new Singleton5();

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        return instance;
    }

    public String showMessage() {
        return "Singleton5 instance created at: " + localDateTime;
    }
}
