package bai6_4;

import java.util.Scanner;

public class Bai6_4 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month;
        int year;

        while (true) {
            System.out.print("Month: ");
            month = scanner.nextLine().trim();

            System.out.print("Year: ");
            String yearInput = scanner.nextLine().trim();

            if (!yearInput.matches("\\d{4}")) {
                System.out.println("Invalid year");
                continue;
            }

            year = Integer.parseInt(yearInput);

            int day = getDay(month, year);

            if (day > 0) {
                System.out.println("Number of days in month " + month + " year " + year + " is: " + day);
                break;
            } else {
                System.out.println("Invalid month or year. Please enter again.");
            }
        }

        scanner.close();
    }

    public static int getDay(String monthInput, int year) {
        int monthNumber = getMonthNumber(monthInput);

        if (monthNumber == -1) {
            return -1;
        }

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        int[] daysInCommonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysInLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return isLeapYear ? daysInLeapYear[monthNumber - 1] : daysInCommonYear[monthNumber - 1];
    }

    public static int getMonthNumber(String monthInput) {
        monthInput = monthInput.toLowerCase();

        switch (monthInput) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
                return 1;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                return 2;
            case "march":
            case "mar.":
            case "mar":
            case "3":
                return 3;
            case "april":
            case "apr.":
            case "apr":
            case "4":
                return 4;
            case "may":
            case "5":
                return 5;
            case "june":
            case "jun":
            case "6":
                return 6;
            case "july":
            case "jul":
            case "7":
                return 7;
            case "august":
            case "aug.":
            case "aug":
            case "8":
                return 8;
            case "september":
            case "sept.":
            case "sep":
            case "9":
                return 9;
            case "october":
            case "oct.":
            case "oct":
            case "10":
                return 10;
            case "november":
            case "nov.":
            case "nov":
            case "11":
                return 11;
            case "december":
            case "dec.":
            case "dec":
            case "12":
                return 12;
            default:
                return -1;
        }
    }

}
