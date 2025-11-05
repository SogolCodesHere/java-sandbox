import java.util.Scanner;

public class FizzBuzzApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringInput = "";
        int intInput = 0;

        //to keep asking the user
        while (true) {
            System.out.print("Enter a number to start the FizzBuzz Game (or type \"quit\" to exit): ");
            stringInput = scanner.nextLine();

            if (stringInput.equalsIgnoreCase("quit"))
                break;

            try {
                intInput = Integer.parseInt(stringInput); //Convert to int if possible

                if ((intInput % 5 == 0) && (intInput % 3 == 0))
                    System.out.println("FizzBuzz");
                else if (intInput % 5 == 0)
                    System.out.println("Fizz");
                else if (intInput % 3 == 0)
                    System.out.println("Buzz");
                else
                    System.out.println(stringInput);
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter either a valid integer number OR the word \"quit\"");
            }
        }
    }
}
