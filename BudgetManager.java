// BudgetManager.java
import java.util.Scanner;

public class BudgetManager {
    private Scanner scanner;

    public BudgetManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public double askBudget() {
        System.out.print("Enter your trip budget: $");
        return scanner.nextDouble();
    }


    public String askTravelDate() {
        System.out.print("Enter your travel date (YYYY-MM-DD): ");
        return scanner.next();
    }

    public String askDestination() {
        System.out.println("Select your destination (all trips start from Washington DC, you must select a number i.e. 1 or 4):");
        System.out.println("1. Paris\n2. Munich\n3. London\n4. Rome");
        int choice = scanner.nextInt();

        return switch (choice) {
            case 1 -> "Paris";
            case 2 -> "Munich";
            case 3 -> "London";
            case 4 -> "Rome";
            default -> "";
        };
    }

    public void printItinerary(String travelDate, String destination, double airfare, double insurance, double hotelCost, double excursionCost) {
        System.out.println("\n--- Your Final Itinerary ---");
        System.out.println("Travel Date: " + travelDate);
        System.out.println("Destination: " + destination);
        System.out.printf("Airfare: $%.2f\n", airfare);
        System.out.printf("Travel Insurance: $%.2f\n", insurance);
        System.out.printf("Hotel Cost: $%.2f\n", hotelCost);
        System.out.printf("Excursions Cost: $%.2f\n", excursionCost);
        System.out.printf("Total Cost: $%.2f\n", airfare + insurance + hotelCost + excursionCost);
        System.out.println("\nReminder: Bring all important documents such as passports, visa, etc., and personal care items like toiletries.");
    }
}
