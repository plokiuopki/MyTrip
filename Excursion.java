// Excursion.java
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
        double[] distances;
        double[] ratings;

        switch (destination) {
            case "Paris" -> {
                options = new String[]{"Mont Saint Michel Day - $120, 234 mi, rated 4.7", 
                						"Eiffel Tower Summit - $58, 19 mi, rated 3.8", 
                						"Louvre - $70, 16 mi, rated 4 ", 
                						"Seine Dinner Cruise - $72, 17 mi, rated 3.6",
                						"Foundation Monet in Giverny - $140, 57 mi, rated 4.5"};
                costs = new double[]{120, 58, 70, 72, 140};
                distances = new double[] {234, 19, 16, 17, 57};
                ratings = new double[] {4.7,3.8,4,3.6,4.5};
            }
            case "Munich" -> {
                options = new String[]{"Neuschwanstein Castle Tour - $75, 89 mi, rated 4.8",
                						"Bohemian and Saxon Switzerland Day Trip - $163, 304 mi, rated 4.9", 
                						"Rothenburg Day Tour - $82, 141 mi, rated 4.4", 
                						"Berchtesgaden and Eagle’s Nest Day Trip - $70, 119 mi, rated 3.9",
                						"Dachau Concentration Camp - $52, 17 mi, rated 4.3"};
                costs = new double[]{75, 163, 82, 70};
                distances = new double[] {89, 304, 141, 119, 17};
                ratings = new double[] {4.8, 4.9, 4.4, 3.9, 4.3};
            }
            case "London" -> {
                options = new String[]{"Stonehenge, Windsor Castle - $131, 72 mi, rated 4.6", 
                						"Big Bus Tour & River Cruise - $51, 16 mi, rated 3.8 ", 
                						"Guided Tour in Buckingham - $113, 15 mi, rated  4.2", 
                						"Harry Potter Warner Bros. Studio Tour - $144, 22 mi, rated 4.7",
                						"Tower of London and Crown Jewels - $46, 20 mi, rated 4.5"};
                costs = new double[]{131, 51, 113, 144};
                distances = new double[] {72, 16, 15, 22, 20};
                ratings = new double[] {4.6, 3.8, 4.2, 4.7, 4.5};
            }
            case "Rome" -> {
                options = new String[]{"Vatican Tour - $98, 16 mi, rated 4.7", 
                						"Colosseum Arena Floor Guided Tour - $61, 17 mi, rated 4.3", 
                						"Amalfi Coast Day Trip - $120, 170mi, rated  4.9", 
                						"Pompeii Guided Tour with Lunch - $229, 160mi, rated 4.4",
                						"Tuscany day trip with lunch - $110, 180mi, rated 4.2"};
                costs = new double[]{98, 61, 120, 229};
            }
            default -> {
                options = new String[0];
                costs = new double[0];
            }
        }

        int choice;
        do {
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

