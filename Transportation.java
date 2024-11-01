// Transportation.java
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

        double basePrice = switch (classChoice) {
            case 1 -> 1200;
            case 2 -> 600;
            default -> 0;
        };

        int month = Integer.parseInt(travelDate.split("-")[1]);
        if (month == 12 || month == 7) {
            basePrice *= 1.25;
        }

        System.out.printf("Selected Airfare Cost: $%.2f\n", basePrice);
        return basePrice;
    }
    
    public double calculateAirfare(String travelDate, String destination ) {
        System.out.println("Choose your airfare class: (you must select a number i.e. 1 or 2)");
        System.out.println("1. First Class\n2. Coach");
        int classChoice = scanner.nextInt();
        double basePrice = 0;
        if (destination=="Paris"){
        basePrice = switch (classChoice) {
            case 1 -> 800;
            case 2 -> 400;
            default -> 0;
        	};
        } else if (destination=="Munich") {
            basePrice = switch (classChoice) {
            case 1 -> 600;
            case 2 -> 1200;
            default -> 0;
            };
        } else if (destination=="London") {
            basePrice = switch (classChoice) {
            case 1 -> 1000;
            case 2 -> 500;
            default -> 0;
            };
        } else if (destination=="Rome") {
            basePrice = switch (classChoice) {
            case 1 -> 750;
            case 2 -> 1500;
            default -> 0;
            };
        }

        int month = Integer.parseInt(travelDate.split("-")[1]);
        if (month == 12 || month == 7) {
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

