package pt.com;

import java.time.LocalDateTime;

//Enum Implementation
public enum Singleton1 {
    INSTANCE;

    private final LocalDateTime localDateTime;

    private Singleton1() {
        localDateTime = LocalDateTime.now();
    }

    public String showMessage() {
        return "Singleton1 instance created at: " + localDateTime;
    }
}
