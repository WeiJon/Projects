package Fruitsalad;

public class Ingredient {

    private String fruit;
    private Double price;

    public Ingredient(String fruit, Double price) {
        this.fruit = fruit;
        this.price = price;
    }

    public String getFruit() {
        return fruit;
    }

    public Double getPrice() {
        return price;
    }
}