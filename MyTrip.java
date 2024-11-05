// MyTrip.java
import java.util.Scanner;

public class MyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to My Trip Planner!");

        // Create instances of each component
        BudgetManager budgetManager = new BudgetManager(scanner);
        Transportation transportation = new Transportation(scanner);
        Accommodation accommodation = new Accommodation(scanner);
        Excursion excursion = new Excursion(scanner);

        // Collect user information
        double budget = budgetManager.askBudget();
        String travelDate = budgetManager.askTravelDate();
        String destination = budgetManager.askDestination();

        // Prompt the user for the number of additional travelers
        System.out.print("How many additional travelers? ");
        int numTravelers = scanner.nextInt();

        // Calculate airfare cost
        double airfareCost = transportation.calculateAirfare(travelDate, destination) * (numTravelers + 1);
        double insuranceCost = transportation.askTravelInsurance(airfareCost);

        // Calculate accommodation cost
        Hotel selectedHotel = accommodation.calculateHotel(destination);
        if (selectedHotel != null) {
            double hotelCost = selectedHotel.getPrice() * (numTravelers + 1);
            System.out.printf("Total Accommodation Cost for %d travelers: $%.2f\n", numTravelers + 1, hotelCost);
        }

        // Remaining budget after airfare and accommodation
        double remainingBudget = budget - (airfareCost + insuranceCost);

        // Calculate excursion cost
        double excursionCost = excursion.calculateExcursions(destination, remainingBudget, numTravelers + 1);

        // Display total costs
        double totalCost = airfareCost + insuranceCost + excursionCost;
        System.out.printf("Total Trip Cost: $%.2f\n", totalCost);

        if (totalCost <= budget) {
            System.out.println("Your trip is within budget!");
        } else {
            System.out.println("You have exceeded your budget.");
        }
    }
}
