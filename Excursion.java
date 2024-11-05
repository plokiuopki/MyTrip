// Excursion.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Excursion {
    private Scanner scanner;
    private List<ExcursionOption>options;

    public Excursion(Scanner scanner) {
        this.scanner = scanner;
        this.options = new ArrayList<>();
    }
    
    //Inner class to represent an excursion option with reviews, distance, and price
    
    private static class ExcursionOption{
    	String name;
    	double price;
    	double reviews;
    	double distance;
    	
    	ExcursionOption(String name, double price, double reviews, double distance){
    		this.name = name;
    		this.price = price;
    		this.reviews = reviews;
    		this.distance = distance;
    	}
    	
    	@Override
    	public String toString() {
    		return name + " -" + " Price: $" + price + ", Rating: " + reviews + ", Distance: " + distance + "mi";
    	}
    }
    //Method to populate excursion options based on the destination
    
    private void populateExcursions(String destination) {
    	options.clear();//Clear previous options
    	switch (destination) {
    	case "Paris" :
    		options.add(new ExcursionOption("Mont Saint Michel Day", 120, 4.7, 180));
    		options.add(new ExcursionOption("Eiffel Tower Summit", 58, 3.8, 19));
    		options.add(new ExcursionOption("Louvre", 70, 4, 16));
    		options.add(new ExcursionOption("Seine Dinner Cruise", 72, 3.6, 17));
    		options.add(new ExcursionOption("Foundation Monet in Giverny", 140, 4.5, 57));
    		break;
    	case "Munich" :
    		options.add(new ExcursionOption("Neuschwanstein Castle Tour", 75, 4.6, 120));
    		options.add(new ExcursionOption("Bohemian and Saxon Switzerland Day Trip", 163, 4.9, 150));
    		options.add(new ExcursionOption("Rothenburg Day Tour", 82, 4.5, 75));
    		options.add(new ExcursionOption("Berchtesgaden and Eagle’s Nest Day Trip", 70, 3.9, 119));
    		options.add(new ExcursionOption("Dachau Concentration Camp", 52, 4.3, 17));
    		break;
    	case "London" :
    		options.add(new ExcursionOption("Stonehenge, Windsor Castle", 131, 4.6, 72));
    		options.add(new ExcursionOption("Big Bus Tour & River Cruise", 51, 3.8, 16));
    		options.add(new ExcursionOption("Guided Tour in Buckingham", 113, 4.2, 15));
    		options.add(new ExcursionOption("Harry Potter Warner Bros. Studio Tour", 144, 4.7, 22));
    		options.add(new ExcursionOption("Tower of London and Crown Jewels", 46, 4.5, 20));
    		break;
    	case "Rome" :
	    	options.add(new ExcursionOption("Vatican Tour", 98, 4.7, 16));
	    	options.add(new ExcursionOption("Colosseum Arena Floor Guided Tour", 61, 4.3, 17));
	    	options.add(new ExcursionOption("Amalfi Coast Day Trip", 120, 4.9, 170));
	    	options.add(new ExcursionOption("Pompeii Guided Tour with Lunch", 229, 4.4, 160));
	    	options.add(new ExcursionOption("Tuscany day trip with lunch", 110, 4.2, 180));
	    	break;
    	}
    }
    //Sorts excursions by price, reviews, or distance
    private void sortExcursions(String sortBy, boolean ascending) {
    	for (int i=0; i<options.size()-1; i++) {
    		for (int j=0; j<options.size()-i-1;j++) {
    			boolean shouldSwap = false;
    			
    			//Sort by price, reviews, or distance depending on user's choice
    			if(sortBy.equals("price")) {
    				if(ascending) {
    					if(options.get(j).price > options.get(j+1).price) {
    						shouldSwap = true;
    					}
    				} else {
    					if(options.get(j).price < options.get(j+1).price) {
    						shouldSwap = true;
    					}
    				}
    			}else if(sortBy.equals("reviews")) {
    				if(ascending) {
    					if(options.get(j).reviews > options.get(j+1).reviews) {
    						shouldSwap = true;
    					}
    				} else {
    					if(options.get(j).reviews < options.get(j+1).reviews) {
    						shouldSwap = true;
    					}
    				}
    			}else if(sortBy.equals("distance")) {
    				if(ascending) {
    					if(options.get(j).distance > options.get(j+1).distance) {
    						shouldSwap = true;
    					}
    				} else {
    					if(options.get(j).distance < options.get(j+1).distance) {
    						shouldSwap = true;
    					}
    				}
    			}
    			
    			if (shouldSwap) {
    				//Swsp options[j] and options[j+1]
    				ExcursionOption temp = options.get(j);
    				options.set(j, options.get(j+1));
    				options.set(j+1, temp);
    			
    			}
    		}
    	}
    }
    						

    
    //Method to calculate the total excursion cost
    public double calculateExcursions(String destination, double remainingBudget, int numTravelers) {
        double excursionCost = 0;
        populateExcursions(destination);
        
        //Ask user if they want to sort excursions
        System.out.print("Would you like to sort excursions? (yes/no); ");
        String sortChoice = scanner.next();
        if(sortChoice.equalsIgnoreCase("yes")) {
        	System.out.print("Sort by: 1. Price 2. Reviews 3. Distance: ");
        	int sortByOption = scanner.nextInt();
        	System.out.print("Order: 1. Ascending 2. Descending: ");
        	int sortOrder = scanner.nextInt();
        	//Sort based on the user's choice
        	switch(sortByOption) {
        		case 1 -> sortExcursions("price", sortOrder == 1);
        		case 2 -> sortExcursions("reviews", sortOrder == 1);
        		case 3 -> sortExcursions("distance", sortOrder == 1);
        		default -> System.out.println("Invalid sort option.");
        	}
        }

        System.out.println("Available Excursions:");
        for(int i=0;i<options.size();i++) {
        	System.out.println((i+1)+"."+ options.get(i));
        }
    
        
        //Allow user to select excursions until budget is exhausted
        int choice;
        do {
        	System.out.print("Enter the number of the excursion to add(0 to finish):");
        	choice=scanner.nextInt();
        	
        	if(choice>0 && choice<=options.size()) {
        		ExcursionOption selectedOption = options.get(choice-1);
        		double cost = selectedOption.price * numTravelers;
        		if(excursionCost + cost > remainingBudget) {
        			System.out.println("Sorry, you don'thave enough budget for this excursion.");
        		} else {
        			excursionCost += cost;
        			System.out.printf("Added %s for $%.2f (Total: $%.2f)\n",
        					selectedOption.name, cost, excursionCost);
        		}
            } else if (choice != 0) {
            	System.out.println("Invalid choice.");
            } 
        }while (choice != 0);
        
    	System.out.printf("Total Excursion Cost: $%.2f\n", excursionCost);
    	return excursionCost;
    }
    
}
    
    }
}

