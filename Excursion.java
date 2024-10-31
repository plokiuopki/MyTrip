import java.util.Scanner;

public class Excursion {
    private Scanner scanner;

    public Excursion(Scanner scanner) {
        this.scanner = scanner;
    }

    public double calculateExcursions(String destination, double remainingBudget) {
        double excursionCost = 0;

        System.out.println("Select excursions for " + destination + " (enter 0 to stop): you must select a number i.e. 1 or 4");

        String[] options;
        double[] costs;

        switch (destination) {
            case "Paris":
                options = new String[]{"Mont Saint Michel Day - $120", "Eiffel Tower Summit - $58", "Louvre - $70", "Seine Dinner Cruise - $72"};
                costs = new double[]{120, 58, 70, 72};
                break;
            case "Munich":
                options = new String[]{"Neuschwanstein Castle Tour - $75", "Bohemian and Saxon Switzerland Day Trip - $163", "Rothenburg Day Tour - $82", "Berchtesgaden and Eagle’s Nest Day Trip - $70"};
                costs = new double[]{75, 163, 82, 70};
                break;
            case "London":
                options = new String[]{"Stonehenge, Windsor Castle - $131", "Big Bus Tour & River Cruise - $51", "Guided Tour in Buckingham - $113", "Harry Potter Warner Bros. Studio Tour - $144"};
                costs = new double[]{131, 51, 113, 144};
                break;
            case "Rome":
                options = new String[]{"Vatican Tour - $98", "Colosseum Arena Floor Guided Tour - $61", "Pompeii, Amalfi Coast Day Trip - $120", "Pompeii Guided Tour with Lunch - $229"};
                costs = new double[]{98, 61, 120, 229};
                break;
            default:
                options = new String[0];
                costs = new double[0];
                break;
        }

        int choice;
        do { // Allows user to select infinite amount of excursions until their budget runs out
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Enter the number of the excursion to add (0 to finish): ");
            choice = scanner.nextInt();

            if (choice > 0 && choice <= options.length) {
                double cost = costs[choice - 1];
                if (excursionCost + cost > remainingBudget) {
                    System.out.println("Sorry, you don’t have enough budget for this excursion.");
                } else {
                    excursionCost += cost;
                    System.out.printf("Added excursion: %s, Cost: $%.2f\n", options[choice - 1], cost);
                }
            }
        } while (choice != 0);

        return excursionCost;
    }
}

