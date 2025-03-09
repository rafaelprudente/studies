package pt.com;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Hello") ? "is palindrome" : "is not palindrome");
        System.out.println(isPalindrome("ovo") ? "is palindrome" : "is not palindrome");
    }

    private static boolean isPalindrome(String str) {
        boolean isPalindrome = true;

        int sourceLength = str.length();

        for (int i = 0; i < sourceLength - 1; i++) {
            if (str.charAt(i) != str.charAt((sourceLength - 1 - i))) {
                isPalindrome= false;
                break;
            }
        }

        return isPalindrome;
    }
}