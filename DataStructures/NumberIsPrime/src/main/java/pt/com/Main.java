package pt.com;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPrime(11) ? 11 + " is a prime number." : 11 + " is not a prime number.");
        System.out.println(isPrime(15) ? 15 + " is a prime number." : 15 + " is not a prime number.");
        System.out.println(isPrime(29) ? 29 + " is a prime number." : 29 + " is not a prime number.");
    }

    public static boolean isPrime(int num) {
        boolean isPrime = true;

        if (num <= 1) {
            isPrime = false; // Numbers less than or equal to 1 are not prime
        } else if (num <= 3) {
            isPrime = true; // 2 and 3 are prime
        } else if (num % 2 == 0 || num % 3 == 0) {
            isPrime = false; // Numbers divisible by 2 or 3 are not prime
        } else {
            // Check for prime using trial division up to the square root of the number
            for (int i = 5; i <= Math.sqrt(num); i = i + 6) {
                if (num % i == 0 || num % (i + 2) == 0) {
                    isPrime = false; // If number is divisible by i or i+2, it's not prime
                    break;
                }
            }
        }

        return isPrime;
    }
}