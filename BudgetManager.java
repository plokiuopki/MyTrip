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

    public String askTravelDate() { //Makes sure user can only add real date
        while (true) {
            System.out.print("Enter your travel date (YYYY-MM-DD): ");
            String travelDate = scanner.next();

            //Split string into array separated by -
            String[] dateParts = travelDate.split("-");
            if (dateParts.length != 3) { //Makes sure a year month and day are properly entered to proceed
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                continue;
            }

            try {
                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[2]);

                // Check month and day range
                if (year < 2024) {
                    System.out.println("Invalid year. Please enter a year that is 2024 or later.");
                } else if (month < 1 || month > 12) {
                    System.out.println("Invalid month. Please enter a month between 1 and 12.");
                } else if (day < 1 || day > 31) {
                    System.out.println("Invalid day. Please enter a day between 1 and 31.");
                } else {
                    return travelDate;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid date. Please ensure you enter numbers for YYYY, MM, and DD.");
            }
        }
    }

    public String askDestination() {
        System.out.println("Select your destination (all trips start from Washington DC, you must select a number i.e. 1 or 4):");
        System.out.println("1. Paris\n2. Munich\n3. London\n4. Rome");
        int choice = scanner.nextInt();

        String destination;
        switch (choice) {
            case 1:
                destination = "Paris";
                break;
            case 2:
                destination = "Munich";
                break;
            case 3:
                destination = "London";
                break;
            case 4:
                destination = "Rome";
                break;
            default:
                destination = "";
                break;
        }
        return destination;
    }

    public void printItinerary(String travelDate, double budget, String destination, double airfare, double insurance, double hotelCost, double excursionCost) {
        System.out.println("\n--- Your Final Itinerary ---");
        System.out.println("Travel Date: " + travelDate);
        System.out.println("Destination: " + destination);
        System.out.printf("Airfare: $%.2f\n", airfare);
        System.out.printf("Travel Insurance: $%.2f\n", insurance);
        System.out.printf("Hotel Cost: $%.2f\n", hotelCost);
        System.out.printf("Excursions Cost: $%.2f\n", excursionCost);
        System.out.printf("Total Cost: $%.2f\n", airfare + insurance + hotelCost + excursionCost);
        System.out.printf("\nRemaining Budget: $%.2f\n", budget - (airfare + insurance + hotelCost + excursionCost));
        System.out.println("\nReminder: Bring all important documents such as passports, visa, etc., and personal care items like toiletries.");
    }
}


