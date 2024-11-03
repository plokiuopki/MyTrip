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
        //boolean travelingAlone = budgetManager.askTravelingAlone();

        // Calculate costs
        double airfare = transportation.calculateAirfare(travelDate, destination);
        double insurance = transportation.askTravelInsurance(airfare);
        
        // Get hotel information and calculate hotel cost
        Hotel selectedHotel = accommodation.calculateHotel(destination);
        double hotelCost = selectedHotel != null ? selectedHotel.getPrice() : 0;
        
      //double hotelCost = accommodation.calculateHotel();
        double excursionCost = excursion.calculateExcursions(destination, budget - (airfare + insurance + hotelCost));
       
        // Display final itinerary
        budgetManager.printItinerary(travelDate, destination, airfare, insurance, hotelCost, excursionCost);
    }
}

