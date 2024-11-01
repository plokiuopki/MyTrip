import java.util.Scanner;

public class Accommodation {
    private Scanner scanner;

    public Accommodation(Scanner scanner) {
        this.scanner = scanner;
    }

    public double calculateHotel() {
        System.out.println("Choose your hotel rating: (you must select a number i.e. 1 or 2)");
        System.out.println("1. 1-2 Stars ($100 per night)\n2. 3 Stars ($200 per night)\n3. 4-5 Stars ($400 per night)");
        int hotelChoice = scanner.nextInt();

        double hotelCost;
        switch (hotelChoice) {
            case 1:
                hotelCost = 100;
                break;
            case 2:
                hotelCost = 200;
                break;
            case 3:
                hotelCost = 400;
                break;
            default:
                hotelCost = 0;
                break;
        }

        System.out.print("How many nights will you stay? ");
        int nights = scanner.nextInt();

        System.out.print("How many rooms would you like to book? ");
        int rooms = scanner.nextInt();

        hotelCost *= nights * rooms; //Calculates the total cost based on rooms and nights
        System.out.printf("Total Hotel Cost: $%.2f\n", hotelCost);
        return hotelCost;
    }
}


