package org.example;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world!");

        // Palindrom Sayılar Testi
        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707));   // true
        System.out.println(isPalindrome(11212)); // false

        // Mükemmel Sayılar Testi
        System.out.println(isPerfectNumber(6));  // true
        System.out.println(isPerfectNumber(28)); // true
        System.out.println(isPerfectNumber(5));  // false
        System.out.println(isPerfectNumber(-1)); // false

        // Sayıları Kelimelere Dökme Testi
        numberToWords(123);   // "One Two Three"
        numberToWords(1010);  // "One Zero One Zero"
        numberToWords(-12);   // "Invalid Value"
    }

    // Palindrom Sayıyı Bulma
    public static boolean isPalindrome(int number) {
        int original = Math.abs(number); // Negatif sayılar için pozitif yapılıyor
        int reversed = 0;
        int temp = original;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reversed = reversed * 10 + lastDigit;
            temp /= 10;
        }

        return original == reversed;
    }

    // Mükemmel Sayıları Bulma
    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    // Sayıları Kelimelere Dök
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        int reversed = reverse(number);
        int digitCount = getDigitCount(number);
        StringBuilder result = new StringBuilder();

        while (digitCount > 0) {
            int digit = reversed % 10;
            switch (digit) {
                case 0 -> result.append("Zero ");
                case 1 -> result.append("One ");
                case 2 -> result.append("Two ");
                case 3 -> result.append("Three ");
                case 4 -> result.append("Four ");
                case 5 -> result.append("Five ");
                case 6 -> result.append("Six ");
                case 7 -> result.append("Seven ");
                case 8 -> result.append("Eight ");
                case 9 -> result.append("Nine ");
            }
            reversed /= 10;
            digitCount--;
        }

        return result.toString().trim(); // Fazla boşluğu kaldırır
    }


    // Yardımcı Metodlar
    private static int reverse(int number) {
        int reversed = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number /= 10;
        }

        return reversed;
    }

    private static int getDigitCount(int number) {
        if (number == 0) {
            return 1;
        }

        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }

        return count;
    }
}


