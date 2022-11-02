import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //I chose to divide the code into separate methods, seen below, within the Main class.

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> fruit = new ArrayList<>();
    static ArrayList<Double> price = new ArrayList<>();

    public static void main(String[] args) {

        //The methods are called in the main method, via the do-while loop.
        do {

            currentList();

            minMax();

            addToList();

        } while(true);
    }

    static void currentList() {

        //This method prints the header for the list and uses a for-loop to print out a numbered list
        // of any added items and the corresponding prices from the two arraylists we use.
        //Unless there's nothing added, in which case it prints out that the list is empty.
        System.out.println("\n========= Shopping List =========\n");
        boolean isEmpty = true;

        for (int i = 0; i < fruit.size(); i++) {
            if (fruit.get(i) != null) {
                System.out.println((i + 1) + ". " + fruit.get(i) + " $" + price.get(i));
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("Shopping list is empty.");
        }
    }

    static void minMax() {

        //These two for-loops goes through all available data in the price arraylist
        // from index 0 onwards and determines the lowest and highest value respectively,
        // and stores them in the two temporary variables minPrice and maxPrice.
        //The items in the fruit arraylist correlated to the min- and maxPrice are then determined,
        // and everything is printed using the format-output.
        if (fruit.size() != 0) {
            double minPrice = price.get(0);
            String minFruit = fruit.get(0);

            for (int i = 1; i < price.size(); i++) {
                if (minPrice > price.get(i)) {
                    minPrice = price.get(i);
                    minFruit = fruit.get(i);
                }
            }
            double maxPrice = price.get(0);
            String maxFruit = fruit.get(0);

            for (int i = 1; i < price.size(); i++) {
                if (maxPrice < price.get(i)) {
                    maxPrice = price.get(i);
                    maxFruit = fruit.get(i);
                }
            }
            System.out.printf("\nCheapest: %s ($%s).\n", minFruit, minPrice);
            System.out.printf("Most Expensive: %s ($%s).\n\n", maxFruit, maxPrice);
        }
        else {
            System.out.println();
        }
    }

    static void addToList() {

            //This method prints the instructions and prompts the user
            // to input an item followed by a price.
            //It then adds the information to the appropriate arraylist.
            //It also calls the method to remove items from the list
            // if the user wants to remove an item.
        System.out.print("""
                .................................

                Type in item to add it.
                Type "Remove" to remove item.
                
                """);

            System.out.print("Item: ");
            String inputFruit = scanner.nextLine();

            if (!inputFruit.equalsIgnoreCase("Remove")) {
                fruit.add(inputFruit);
                double inputPrice = 0.0;

                do {
                    System.out.print("Price: $");
                    if (scanner.hasNextDouble()) {
                        inputPrice = scanner.nextDouble();
                        price.add(inputPrice);
                        scanner.nextLine();
                    }else {
                        System.out.println("\nError: That's not a valid value.\n");
                        scanner.nextLine();
                    }
                } while (inputPrice <= 0.0);
            } else {
                removeFromList();
            }
    }

    static void removeFromList() {

        //This method is called if the user wants to remove an item and its price from the shopping list.
        //Since the items in the list are numbered the user is prompted
        // to type in the number corresponding to the desired item to remove.
        System.out.print("Remove number: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        if (num >= 1 && num <= fruit.size()) {
            fruit.remove(num - 1);
            price.remove(num - 1);
        }
        else {
            System.out.println("\n Error: There is no fruit with that number.");
        }
    }
}