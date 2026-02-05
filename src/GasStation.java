import java.util.Scanner;

public class GasStation {

    public static String beforeOrAfter(String userInput) {
        String input = userInput.toLowerCase();

        if (input.equals("before") || input.equals("after")) {
            return input;
        } else {
            System.err.println("Error: invalid input");
            return "invalid";
        }
    }

    public static double getGrade(String grade) {
        if (grade.equalsIgnoreCase("regular")) {
            return 2.50;
        } else if (grade.equalsIgnoreCase("mid-grade")) {
            return 3.00;
        } else if (grade.equalsIgnoreCase("premium")) {
            return 3.50;
        } else {
            return -1; // Use -1 to indicate an error
        }
    }


    public static double calculateTotalCost(double gallons, double price) {
        if (gallons > 0) {
            return gallons * price;
        } else {
            System.err.println("Gallons must be greater than 0");
            return gallons;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Pay before or after\n > ");
        String userInput = sc.nextLine();
        String paymentType = beforeOrAfter(userInput);

        if (paymentType.equals("before")) {
            System.out.print("How much are you spending?\n > ");
            double money = sc.nextDouble();
            sc.nextLine();


            System.out.println("What grade?");
            System.out.println("- Regular $2.50/gal");
            System.out.println("- Mid-grade $3.00/gal");
            System.out.println("- Premium $3.50/gal");
            System.out.print("> ");
            String grade = sc.nextLine();

            double price = getGrade(grade);
            if (price > 0) {
                double gallons = money / price;
                System.out.println("Thank you for your purchase!");
                System.out.println("Payment: " + userInput);
                System.out.printf("Amount spent: $%.2f%n", money);
                System.out.printf("Gallons purchased: %.2f%n", gallons);

            } else {
                System.out.println("Invalid fuel grade entered.");
            }


        } else if (paymentType.equals("after")) {

            System.out.println("What grade?");
            System.out.println("- Regular $2.50/gal");
            System.out.println("- Mid-grade $3.00/gal");
            System.out.println("- Premium $3.50/gal");
            System.out.print("> ");
            String grade = sc.nextLine();

            double price = getGrade(grade);

            System.out.print("How many gallons of gas did you pump?\n > ");
            double gallons = sc.nextDouble();
            sc.nextLine();

            double totalPrice = calculateTotalCost(gallons, price);

            if (price > 0) {
                System.out.println("Thank you for your purchase!");
                System.out.println("Payment: " + userInput);
                System.out.printf("Amount spent: $%.2f%n", totalPrice);
                System.out.printf("Gallons purchased: %.2f%n", gallons);
            } else {
                System.out.println("Invalid fuel grade.");
            }
        }
        sc.close();
    }
}

