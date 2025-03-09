package pt.com;

import java.time.LocalDateTime;

//Thread Safe Implementation
public class Singleton3_My_Choice {
    private static final LocalDateTime localDateTime = LocalDateTime.now();
    private static Singleton3_My_Choice instance;

    private Singleton3_My_Choice() {
    }

    public static synchronized Singleton3_My_Choice getInstance() {
        if (instance == null) {
            instance = new Singleton3_My_Choice();
        }

        return instance;
    }

    public String showMessage() {
        return "Singleton3 instance created at: " + localDateTime;
    }
}
