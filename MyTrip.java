import java.util.Scanner;

public class MyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to My Trip Planner!");

        //Creates instances of each class so it can be used to calculate overall trip cost
        BudgetManager budgetManager = new BudgetManager(scanner);
        Transportation transportation = new Transportation(scanner);
        Accommodation accommodation = new Accommodation(scanner);
        Excursion excursion = new Excursion(scanner);

        //Assigns new variables for collected user information
        double budget = budgetManager.askBudget();
        String travelDate = budgetManager.askTravelDate();
        String destination = budgetManager.askDestination();

        //Prompt the user for the number of additional travelers (up to 3 additional)
        System.out.print("How many additional travelers are joining you (up to 3)? ");
        int additionalTravelers = Math.min(3, scanner.nextInt());
        int totalTravelers = 1 + additionalTravelers; // Including the primary traveler

        //Assigns new variables for calculated travel costs
        double airfare = transportation.calculateAirfare(destination, travelDate) * totalTravelers; //Multiply by total travelers
        double insurance = transportation.askTravelInsurance(airfare);
        double hotelCost = accommodation.calculateHotel();
        double excursionCost = excursion.calculateExcursions(destination, budget - (airfare + insurance + hotelCost), totalTravelers);

        //Display final itinerary to user
        budgetManager.printItinerary(travelDate, budget, destination, airfare, insurance, hotelCost, excursionCost);
    }
}


