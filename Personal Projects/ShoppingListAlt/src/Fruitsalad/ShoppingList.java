package Fruitsalad;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {

    private ArrayList<Ingredient> ingredientArrayList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ShoppingList() {
        ingredientArrayList.add(new Ingredient("Apple", 1.32));
        ingredientArrayList.add(new Ingredient("Banana", 0.99));
        ingredientArrayList.add(new Ingredient("Melon", 2.12));
    }

    public ArrayList<Ingredient> getList() {
        boolean isEmpty = true;
        ArrayList<Ingredient> itemFound = new ArrayList<>();

        for (Ingredient ingredient : ingredientArrayList) {
            if (ingredient != null) {
                itemFound.add(ingredient);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("Shopping list is empty.");
        }
        return itemFound;
    }

    public void addItem() {
        System.out.print("Item: ");
        String inputFruit = scanner.nextLine();

        if (!inputFruit.equalsIgnoreCase("remove")) {
            System.out.print("Price: $");
            Double inputPrice = scanner.nextDouble();
            ingredientArrayList.add(new Ingredient(inputFruit, inputPrice));
            scanner.nextLine();

        }else {
            removeFromList();
        }
    }

    public void removeFromList() {
        System.out.print("Remove number: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        if (num >= 1 && num <= ingredientArrayList.size()) {
            ingredientArrayList.remove(num - 1);
        }
        else {
            System.out.println("\n Error: There is no fruit with that number.");
        }
    }
}
