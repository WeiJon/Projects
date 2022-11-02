package Fruitsalad;

import java.util.ArrayList;

public class Operation {

    ShoppingList shopList = new ShoppingList();

    public void currentList() {
        System.out.println("\n========= Shopping List =========\n");

        ArrayList<Ingredient> ingredients = shopList.getList();

        for (Ingredient ingredient : ingredients) {
            System.out.println((ingredients.lastIndexOf(ingredient) + 1) + " " + ingredient.getFruit() + " " + ingredient.getPrice() + "$");
        }
    }

    public void addItemToList() {
        System.out.print("""
                .................................

                Type in item to add it.
                Type "remove" to remove item.
                
                """);

        shopList.addItem();
    }
}
