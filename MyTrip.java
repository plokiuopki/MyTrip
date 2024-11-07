import java.util.Scanner;

public class MyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to My Trip Planner!");

        BudgetManager budgetManager = new BudgetManager(scanner);
        Transportation transportation = new Transportation(scanner);
        Accommodation accommodation = new Accommodation(scanner);
        Excursion excursion = new Excursion(scanner);

        //gets important info from the user to begin trip planning
        double budget = budgetManager.theBudget();
        String travelDate = budgetManager.askDate();
        String destination = budgetManager.askDestination();

        if (destination.isEmpty()) {
            System.out.println("Invalid destination selected. Exiting program.");
            return; //this makes sure that a valid destination is selected
        }

        //gives the user the option to travel with multiple people
        System.out.print("How many additional travelers? ");
        int numTravelers = scanner.nextInt();

        //calculates airfare for the user and their potential guests, gives an additional option to elect travel insurance
        double airCost = transportation.calcAir(destination, travelDate) * (numTravelers + 1);
        double insurCost = transportation.askTravelInsurance(airCost);

        //calculates the price of the hotel based on the user's selected preferences
        Hotel selectedHotel = accommodation.calculateHotel(destination);
        double hotelPri = 0;
        if (selectedHotel != null) {
            hotelPri = accommodation.GetTotalHotelCost() * (numTravelers + 1);
            System.out.printf("Total Accommodation Cost for %d travelers: $%.2f\n", numTravelers + 1, hotelPri);
        } else {
            System.out.println("No suitable accommodation was selected.");
        }

        //lets the user know how much of their original budget is left after all expenses
        double remainingBudget = budget - (airCost + insurCost);

        //calculates all elected excursions for the user and their guests
        double excursionCost = excursion.calcExcurs(destination, remainingBudget, numTravelers + 1);

        //displays total cost of all expenses
        double totalCost = airCost + insurCost + hotelPri + excursionCost;
        System.out.printf("Total Trip Cost: $%.2f\n", totalCost);

        if (totalCost <= budget) {
            System.out.println("Your trip is within budget!");
        } else {
            System.out.println("You have exceeded your budget.");
        }

        //combines all costs and displays an itinerary the user can reference quickly
        budgetManager.printItinerary(travelDate, budget, destination, airCost, insurCost, hotelPri, excursionCost);
    }
}

