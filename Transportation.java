import java.util.Scanner;

public class Transportation {
    private Scanner scanner;

    public Transportation(Scanner scanner) {
        this.scanner = scanner;
    }

    public double calculateAirfare(String travelDate) {
        System.out.println("Choose your airfare class: (you must select a number i.e. 1 or 2)");
        System.out.println("1. First Class\n2. Coach");
        int classChoice = scanner.nextInt();

        //European flight base price from DC
        double basePrice;
        switch (classChoice) {
            case 1:
                basePrice = 1200;
                break;
            case 2:
                basePrice = 600;
                break;
            default:
                basePrice = 0;
                break;
        }

        //Splits the date into an array of strings so that month can be used to calculate surge pricing
        //Second index of the array is the month -> converts string month to an int
        int month = Integer.parseInt(travelDate.split("-")[1]);
        if (month == 12 || month == 7) { //Surge prices are December and July
            basePrice *= 1.25;
        }

        System.out.printf("Selected Airfare Cost: $%.2f\n", basePrice);
        return basePrice;
    }

    public double askTravelInsurance(double airfare) {
        System.out.print("Would you like to add travel insurance, it will cost an additional 4%? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes") ? airfare * 0.04 : 0;
    }
}

