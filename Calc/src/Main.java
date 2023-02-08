import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.zip.DataFormatException;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;
    static String[] arab = {"10", "1", "2", "3", "4", "5", "6", "7", "8", "9",};
    static String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static void main(String[] args) throws IllegalArgumentException, DataFormatException {
        System.out.println("Введите выражение");
        String input = scanner.nextLine().replace(" ", "");
        char[] underChar = new char[10];
        for (int i = 0; i < input.length(); i++) {
            underChar[i] = input.charAt(i);
            if (underChar[i] == '+') {
                operation = '+';
            }
            if (underChar[i] == '-') {
                operation = '-';
            }
            if (underChar[i] == '*') {
                operation = '*';
            }
            if (underChar[i] == '/') {
                operation = '/';
            }
        }
        Main.calc(input);

    }


    static String calc(String input) throws DataFormatException {

        String[] part = input.split("[+-/*]");
        int l = part.length;

        String part1 = part[0];
        String part2 = part[1];

        if (part1.equals(arab) && part2.equals(roman)) throw new DataFormatException();
        if (part1.equals(roman) && part2.equals(arab)) throw new DataFormatException();
        if (l > 2) throw new DataFormatException();

        number1 = romanToNumber(part1);
        number2 = romanToNumber(part2);

        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = calculated(number1, number2, operation);

            String resultRoman = convertNumToRoman(result);
            System.out.println(resultRoman);
            System.exit(0);

        }
        number1 = Integer.parseInt(part1);
        number2 = Integer.parseInt(part2);
        result = calculated(number1, number2, operation);

        System.out.println(result);

        return String.valueOf(result);
    }

    public static String convertNumToRoman(int numArabian) {

        final String s = roman[numArabian];

        return s;
    }


    public static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    public static int calculated(int num1, int num2, char op) {
        if (number1 < 0 || number2 < 0) {
            throw new InputMismatchException();
        }
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }

}