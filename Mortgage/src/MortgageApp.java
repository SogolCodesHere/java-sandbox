/* Mortgage Calculator, but the Princinpal should be between $1K - $1M) */

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MortgageApp {
    public static void main(String[] args) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0, periodYears = 0, numberOfPayments;
        float annualInterestRate = 0.0F, monthlyInterestRate;
        double mortgageInt;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Principal (between $1K - $1M): ");
            try {
                principal = scanner.nextInt();

                if ((principal >= 1000) && (principal <= 1_000_000))
                    break;
                System.out.println("Type in a number between $1,000 - $1,000,000. ");

            } catch (InputMismatchException e) {
                System.out.println("Type in a VALID integer number. ");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.print("Annual Interest Rate (between 0 - (equal to) 30): ");
            try {
                annualInterestRate = scanner.nextFloat();

                if ((annualInterestRate > 0) && (annualInterestRate <= 30))
                    break;
                System.out.println("Type in a number greater than 0 and less than or equal to 30. ");
            } catch (InputMismatchException e) {
                System.out.println("Type in a VALID float number. ");
                scanner.nextLine();
            }
        }
        monthlyInterestRate = annualInterestRate / MONTH_IN_YEAR / PERCENT;

        while (true) {
            System.out.print("Period (Years betwen 1 -30): ");
            try {
                periodYears = scanner.nextInt();

                if ((periodYears >= 1) && (periodYears <= 30))
                    break;
                System.out.println("Type in a number from 1 to 30.");

            } catch (InputMismatchException e) {
                System.out.println("Type in a VALID integer number. ");
                scanner.nextLine();
            }
        }
            numberOfPayments = periodYears * MONTH_IN_YEAR;

            mortgageInt = principal
                    * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

            String mortgageString = NumberFormat.getCurrencyInstance().format(mortgageInt);
            System.out.println("Mortgage: " + mortgageString);

    }
}
