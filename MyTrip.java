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

        //Assigns new variables for calculated travel costs
        double airfare = transportation.calculateAirfare(destination, travelDate);
        double insurance = transportation.askTravelInsurance(airfare);
        double hotelCost = accommodation.calculateHotel();
        double excursionCost = excursion.calculateExcursions(destination, budget - (airfare + insurance + hotelCost));

        //Display final itinerary to user
        budgetManager.printItinerary(travelDate, budget, destination, airfare, insurance, hotelCost, excursionCost);
    }
}
