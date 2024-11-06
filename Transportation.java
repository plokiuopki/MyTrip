import java.util.Scanner;

public class Transportation {
    private Scanner scanner;

    public Transportation(Scanner scanner) {
        this.scanner = scanner;
    }

    public double calcAir(String destination, String travelDate) {
        System.out.println("Choose your airfare class: (you must select a number i.e. 1 or 2)");
        System.out.println("1. First Class\n2. Coach");
        int chooseClass = scanner.nextInt();

        //all flights are round trip to Europe and prices are calculated from DC
        double basePri = 0;
        switch (destination.toLowerCase()) {
            case "paris":
                basePri = (chooseClass == 1) ? 800 : 400;
                break;
            case "munich":
                basePri = (chooseClass == 1) ? 800 : 600;
                break;
            case "london":
                basePri = (chooseClass == 1) ? 1000 : 500;
                break;
            case "rome":
                basePri = (chooseClass == 1) ? 1500 : 750;
                break;
            default:
                System.out.println("Invalid destination selected.");
                return 0;
        }

        //checks if date is properly formatted (ex:"YYYY-MM-DD")
        //applies surge pricing for December and July
        //splits the date into an array of strings so that month can be used to calculate surge pricing
        //second index of the array is the month -> converts string month to an int
        String[] dateParts = travelDate.split("-");
        if (dateParts.length > 1) {
            int month = Integer.parseInt(dateParts[1]);
            if (month == 12 || month == 7) {
                basePri *= 1.25; //surge pricing
            }
        } else {
            System.out.println("Invalid date format. Surge pricing not applied.");
        }

        System.out.printf("Selected Airfare Cost per Traveler: $%.2f\n", basePri);
        return basePri;
    }

    public double askTravelInsurance(double airfare) {
        System.out.print("Would you like to add travel insurance, it will cost an additional 4%? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes") ? airfare * 0.04 : 0; //calculates 4% travelers insurance if elected
    }
}
