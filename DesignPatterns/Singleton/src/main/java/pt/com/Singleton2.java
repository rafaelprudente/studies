package pt.com;

import java.time.LocalDateTime;

//Bill Pugh Implementation
public class Singleton2 {
    private static final LocalDateTime localDateTime = LocalDateTime.now();

    private Singleton2() {
    }

    private static class Singleton2Helper {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return Singleton2Helper.INSTANCE;
    }

    public String showMessage() {
        return "Singleton2 instance created at: " + localDateTime;
    }
}
