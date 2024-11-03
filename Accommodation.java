import java.util.*;

public class Accommodation {
    private Scanner scanner;
    private Map<String, Map<Integer, List<Hotel>>> hotelData;

    public Accommodation(Scanner scanner) {
        this.scanner = scanner;
        this.hotelData = new HashMap<>();
        initializeHotelData();
    }

    private void initializeHotelData() {
        // Paris hotels
        Map<Integer, List<Hotel>> parisHotels = new HashMap<>();
        
        parisHotels.put(1, Arrays.asList(
                new Hotel("Acacia Hotel", 1.9, 82, 7.4),
                new Hotel("Hotel Ferney Republique", 1.2, 94, 6),
                new Hotel("Le Figuier", 2.1, 71, 7.8),
                new Hotel("Hotel Liberty", 1.4, 68, 6),
                new Hotel("Montsouris Orleans Hotel", 3.9, 85, 7.8)
        ));
        parisHotels.put(2, Arrays.asList(
                new Hotel("Makom Pereire", 4.1, 119, 8.2),
                new Hotel("Hotel Castex", 2.2, 169, 8.2),
                new Hotel("Hotel Floride Etoile", 4.5, 164, 9),
                new Hotel("Hotel Fertel Etoile", 4.1, 124, 8.8),
                new Hotel("Beaugency Hotel", 3.5, 177, 8.2)
        ));
        parisHotels.put(3, Arrays.asList(
                new Hotel("Castille Paris - Starhotels Collezione", 1.4, 425, 8.8),
                new Hotel("Juliana Hotel Paris", 3.2, 355, 9.2),
                new Hotel("Le Cinq Codet", 3.5, 374, 9.2),
                new Hotel("Kimpton St Honore Paris", 1.8, 433, 9.2),
                new Hotel("La Clef Louvre Paris", 1.5, 446, 9.4)
        ));
        hotelData.put("Paris", parisHotels);
        //Munich hotel
        Map<Integer, List<Hotel>> munichHotels = new HashMap<>();
        munichHotels.put(1, Arrays.asList(
                new Hotel("Ibis Budget Ost Messe", 5.29, 66, 7.4),
                new Hotel("Ibis Budget Munchen Putzbrunn", 8.18, 60, 8.18),
                new Hotel("Ibis Budget Airport Erding", 18.7, 89, 8.2),
                new Hotel("Ibis Budget Munchen City", 2.4, 90, 8),
                new Hotel("Ibis Budget Munchen City Olympiapark", 3.75, 64, 7.8)
        ));
        munichHotels.put(2, Arrays.asList(
                new Hotel("Eurostars Book Hotel", 1.2, 130, 8.6),
                new Hotel("Hotel Concorde Munchen", 0.2, 185, 8.6),
                new Hotel("NH Collection Munchen Bavaria", 1, 173, 9),
                new Hotel("Mercure Munchen City Center", 4.1, 145, 9),
                new Hotel("Hotel Europa", 1.9, 146, 8.8)
        ));
        munichHotels.put(3, Arrays.asList(
                new Hotel("Hotel Bayerischer Hof", 0.7, 430, 8.8),
                new Hotel("Hotel Munchen Palace", 1.45, 324, 9.4),
                new Hotel("Platzl Hotel", 0.3, 337, 9.4),
                new Hotel("Rocco Forte The Charles Hotel", 1.2, 537, 9.6),
                new Hotel("Sofitel Munich Bayerpost", 1.3, 328, 8.8)
        ));
        
        hotelData.put("Munich", munichHotels);
        
        //london hotels
        Map<Integer, List<Hotel>> londonHotels = new HashMap<>();
        londonHotels.put(1, Arrays.asList(
                new Hotel("Thistle London Heathrow Terminal 5", 16.2, 81, 7.8),
                new Hotel("Red Lion Hotel Hillingdon", 15.6, 99, 9.2),
                new Hotel("RC Airport Rooms", 15.8, 81, 6.8),
                new Hotel("Love & Peace", 14.7, 82, 8),
                new Hotel("Heathrow Ensuites Rooms", 15.8, 68, 6)
        ));
        londonHotels.put(2, Arrays.asList(
                new Hotel("Point A Hotel Shoreitch", 2.4, 164, 8.2),
                new Hotel("Assembly Leicester Square", 0.3, 297, 8.2),
                new Hotel("Gainsborough Hotel", 2.7, 222, 8.4),
                new Hotel("Ruby Zoe Hotel", 4.1, 256, 9.4),
                new Hotel("Holiday Inn Hotel", 3.3, 210, 7.4)
        ));
        londonHotels.put(3, Arrays.asList(
                new Hotel("The Mayfair Townhouse", 1, 433, 9.2),
                new Hotel("Hilton London Bankside", 1.4, 321, 9.4),
                new Hotel("Middle Eight -Covent Garden", 0.8, 340, 9.4),
                new Hotel("Pan Pacific London", 2.4, 409, 9.8),
                new Hotel("Royal Lancaster London", 2.5, 357, 9.4)
        ));
        hotelData.put("London", londonHotels);
        // Rome hotels
        Map<Integer, List<Hotel>> romeHotels = new HashMap<>();
        romeHotels.put(1, Arrays.asList(
                new Hotel("Cressy", 1.2, 72, 7.4),
                new Hotel("Hotel Beauty", 1.2, 58, 5.4),
                new Hotel("Hotel Mosaic", 1.3, 80, 7.2),
                new Hotel("Hotel Giada", 1.4, 88, 5),
                new Hotel("Hotel Beautiful", 3.9, 78, 5)
        ));
        romeHotels.put(2, Arrays.asList(
                new Hotel("Hotel Caravita", 0.2, 179, 9),
                new Hotel("La Griffe Hotel", 0.8, 168, 7.6),
                new Hotel("Hotel Aniene", 4.2, 131, 8),
                new Hotel("Hotel Virgilo", 0.7, 129, 8.4),
                new Hotel("Hotel Navona", 0.5, 157, 8.8)
        ));
        romeHotels.put(3, Arrays.asList(
                new Hotel("NH Collection Roma Palazzo Cinquecento", 1.3, 317, 9),
                new Hotel("Rome Cavalier a Waldorf Astoria Hotel", 3.2, 362, 9.2),
                new Hotel("Baglioni Hotel Regina", 1, 403, 9),
                new Hotel("Aleph Rome Hotel Curio Collection", 0.9, 410, 9.4),
                new Hotel("Hotel Locarno", 1, 487, 9.6)
        ));
        hotelData.put("Rome", romeHotels);
    }    
        
    
  
    public Hotel calculateHotel(String destination) {
        System.out.println("Choose your hotel rating:\n1. 1-2 Stars\n2. 3-4 Stars\n3. 5 Stars");
        int ratingChoice = scanner.nextInt();

        // Retrieve hotel options based on destination
        Map<Integer, List<Hotel>> cityHotels = hotelData.get(destination);
        if (cityHotels == null) {
            System.out.println("No hotels available for this destination.");
            return null;
        }

        List<Hotel> hotels = cityHotels.get(ratingChoice);
        if (hotels == null || hotels.isEmpty()) {
            System.out.println("No hotels available for this rating.");
            return null;
        }

        // Display hotel options
        for (int i = 0; i < hotels.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, hotels.get(i));
        }
        
        System.out.print("Choose a hotel by number: ");
        int hotelChoice = scanner.nextInt();
        if (hotelChoice < 1 || hotelChoice > hotels.size()) {
            System.out.println("Invalid choice.");
            return null;
        }

        Hotel selectedHotel = hotels.get(hotelChoice - 1);
        System.out.print("How many nights will you stay? ");
        int nights = scanner.nextInt();
        double totalCost = selectedHotel.getPrice() * nights;

        System.out.printf("Total Hotel Cost for %s: $%.2f\n", selectedHotel.getName(), totalCost);
        return selectedHotel;
    }
}
