import java.util.Scanner;

public class Transportation {
    private Scanner scanner;

    public Transportation(Scanner scanner) {
        this.scanner = scanner;
    }

    public double calculateAirfare(String destination, String travelDate) {
        System.out.println("Choose your airfare class: (you must select a number i.e. 1 or 2)");
        System.out.println("1. First Class\n2. Coach");
        int classChoice = scanner.nextInt();

        //European flight different base prices from DC
        double basePrice = 0;
        switch (destination.toLowerCase()) {
            case "paris":
                if (classChoice == 1) {
                    basePrice = 800;
                } else {
                    basePrice = 400;
                }
                break;
            case "munich":
                if (classChoice == 1) {
                    basePrice = 800;
                } else {
                    basePrice = 600;
                }
                break;
            case "london":
                if (classChoice == 1) {
                    basePrice = 1000;
                } else {
                    basePrice = 500;
                }
                break;
            case "rome":
                if (classChoice == 1) {
                    basePrice = 1500;
                } else {
                    basePrice = 750;
                }
                break;
            default:
                System.out.println("Invalid destination selected.");
        }

        //Apply surge pricing for December and July
        //Splits the date into an array of strings so that month can be used to calculate surge pricing
        //Second index of the array is the month -> converts string month to an int
        int month = Integer.parseInt(travelDate.split("-")[1]);
        if (month == 12 || month == 7) {
            basePrice *= 1.25;
        }

        System.out.printf("Selected Airfare Cost per Traveler: $%.2f\n", basePrice);
        return basePrice;
    }

    public double askTravelInsurance(double airfare) {
        System.out.print("Would you like to add travel insurance, it will cost an additional 4%? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes") ? airfare * 0.04 : 0;
    }
}




