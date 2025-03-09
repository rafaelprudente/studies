package pt.com;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(reverseString("Hello, World!"));
    }

    private static String reverseString(String str) {
        String response = "";

        for (char c : str.toCharArray()) {
            response = c + response;
        }

        return response;
    }
}