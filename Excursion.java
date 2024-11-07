//used arraylist to store excursion options
//used bubble sort to sort excursions
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Scanner;

public class Excursion {
    private Scanner scanner;
    private List<ExcursionOption> options;
    private Queue<Integer> selectedExcursions; // Queue to manage selected excursions

    public Excursion(Scanner scanner) {
        this.scanner = scanner;
        this.options = new ArrayList<>(); //using arraylist to list excursion options
        this.selectedExcursions = new LinkedList<>();
    }

    //private class used for excursion options which allows override of the name, price, reviews and distance names
    private static class ExcursionOption {
        String name;
        double price;
        double reviews;
        double distance;

        ExcursionOption(String name, double price, double reviews, double distance) {
            this.name = name;
            this.price = price;
            this.reviews = reviews;
            this.distance = distance;
        }


        public String toString() {
            return name + " - Price: $" + price + ", Rating: " + reviews + ", Distance: " + distance + " mi";
        }
    }

    //method displays excursions based on their destination
    private void showExcursions(String destination) {
        options.clear(); //clears previous options to allow use to keep adding excursions until break "0" is input to end
        switch (destination) {
            case "Paris": //adds paris excursions to the arraylist
                options.add(new ExcursionOption("Mont Saint Michel Day Trip", 120, 4.7, 180));
                options.add(new ExcursionOption("Eiffel Tower Summit", 58, 3.8, 19));
                options.add(new ExcursionOption("Louvre Museum", 70, 4.0, 16));
                options.add(new ExcursionOption("Seine River Dinner Cruise", 72, 3.6, 17));
                options.add(new ExcursionOption("Monet’s Gardens in Giverny", 140, 4.5, 57));
                break;
            case "Munich": //adds munich excursions to the arraylist
                options.add(new ExcursionOption("Neuschwanstein Castle Tour", 75, 4.6, 120));
                options.add(new ExcursionOption("Bohemian Switzerland Day Trip", 163, 4.9, 150));
                options.add(new ExcursionOption("Rothenburg Day Tour", 82, 4.5, 75));
                options.add(new ExcursionOption("Eagle’s Nest Day Trip", 70, 3.9, 119));
                options.add(new ExcursionOption("Dachau Concentration Camp", 52, 4.3, 17));
                break;
            case "London": //adds london excursions to the arraylist
                options.add(new ExcursionOption("Stonehenge & Windsor Castle", 131, 4.6, 72));
                options.add(new ExcursionOption("Big Bus Tour & River Cruise", 51, 3.8, 16));
                options.add(new ExcursionOption("Buckingham Palace Guided Tour", 113, 4.2, 15));
                options.add(new ExcursionOption("Harry Potter Studio Tour", 144, 4.7, 22));
                options.add(new ExcursionOption("Tower of London Tour", 46, 4.5, 20));
                break;
            case "Rome": //adds rome excursions to the arraylist
                options.add(new ExcursionOption("Vatican Museums Tour", 98, 4.7, 16));
                options.add(new ExcursionOption("Colosseum Guided Tour", 61, 4.3, 17));
                options.add(new ExcursionOption("Amalfi Coast Day Trip", 120, 4.9, 170));
                options.add(new ExcursionOption("Pompeii Day Trip", 229, 4.4, 160));
                options.add(new ExcursionOption("Tuscany Day Trip", 110, 4.2, 180));
                break;
            default:
                System.out.println("No excursions available for this destination.");
                break;
        }
    }

    //using a Bubble Sort to allow user to sort through excursion (options arraylist) options by price, review rate or distance and in ascending or descending order
    private void sortExcursions(String sortBy, boolean ascending) {
        for (int i = 0; i < options.size() - 1; i++) {
            for (int j = 0; j < options.size() - i - 1; j++) {
                boolean swap = false;

                if (sortBy.equals("price")) {
                    if (ascending ? options.get(j).price > options.get(j + 1).price
                            : options.get(j).price < options.get(j + 1).price) {
                        swap = true;
                    }
                } else if (sortBy.equals("reviews")) {
                    if (ascending ? options.get(j).reviews > options.get(j + 1).reviews
                            : options.get(j).reviews < options.get(j + 1).reviews) {
                        swap = true;
                    }
                } else if (sortBy.equals("distance")) {
                    if (ascending ? options.get(j).distance > options.get(j + 1).distance
                            : options.get(j).distance < options.get(j + 1).distance) {
                        swap = true;
                    }
                }

                if (swap) {
                    ExcursionOption temp = options.get(j);
                    options.set(j, options.get(j + 1));
                    options.set(j + 1, temp);
                }
            }
        }
    }

    //method calculates the total excursion cost for all travelers
    public double calcExcurs(String destination, double remainingBudget, int numTravelers) {
        double excursionCost = 0;
        showExcursions(destination);

        //displays message for user to elect how they would like their excursions to be sorted
        System.out.print("Would you like to sort excursions by price, reviews, or distance? (yes/no): ");
        String sortChoice = scanner.next();
        if (sortChoice.equalsIgnoreCase("yes")) {
            System.out.print("Sort by: 1. Price 2. Reviews 3. Distance: ");
            int sortByOption = scanner.nextInt();
            System.out.print("Order: 1. Ascending 2. Descending: ");
            int sortOrder = scanner.nextInt();

            switch (sortByOption) {
                case 1:
                    sortExcursions("price", sortOrder == 1);
                    break;
                case 2:
                    sortExcursions("reviews", sortOrder == 1);
                    break;
                case 3:
                    sortExcursions("distance", sortOrder == 1);
                    break;
                default:
                    System.out.println("Invalid sort option.");
                    break;
            }
        }

        System.out.println("Available Excursions:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        //user can select as many excursions as they want until they run out of budget, then they will not be allowed to select more i.e. add to their total cost
        int choice;
        do {
            System.out.print("Enter the number of the excursion to add, -1 to remove an excursion, or 0 to finish: ");
            choice = scanner.nextInt();

            if (choice > 0 && choice <= options.size()) { // Add excursion
                ExcursionOption selectedOption = options.get(choice - 1);
                double cost = selectedOption.price * numTravelers;
                if (excursionCost + cost > remainingBudget) {
                    System.out.println("Sorry, you don't have enough budget for this excursion.");
                } else {
                    excursionCost += cost;
                    selectedExcursions.add(choice - 1);
                    System.out.printf("Added %s for $%.2f (Total: $%.2f)\n",
                            selectedOption.name, cost, excursionCost);
                }
            } else if (choice == -1) { // Remove excursion
                if (selectedExcursions.isEmpty()) {
                    System.out.println("No excursions selected to remove.");
                } else {
                    System.out.print("Enter the number of the excursion to remove: ");
                    int removeChoice = scanner.nextInt();
                    
                    if (removeChoice > 0 && removeChoice <= options.size() && selectedExcursions.contains(removeChoice - 1)) {
                        ExcursionOption removedOption = options.get(removeChoice - 1);
                        double refund = removedOption.price * numTravelers;
                        excursionCost -= refund;
                        selectedExcursions.remove(removeChoice - 1);
                        System.out.printf("Removed %s (Refund: $%.2f, New Total: $%.2f)\n",
                                removedOption.name, refund, excursionCost);
                    } else {
                        System.out.println("Excursion not selected or invalid choice.");
                    }
                }
            } else if (choice != 0) { // Invalid choice
                System.out.println("Invalid choice. Please select an excursion within the valid range.");
            }
        } while (choice != 0);

        System.out.printf("Total Excursion Cost: $%.2f\n", excursionCost);
        return excursionCost;
    }
}



