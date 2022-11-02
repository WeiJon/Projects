
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberOfGames;
        int total = 0;
        int wins = 0;
        int winSwap = 0;
        int winNoSwap = 0;
        double swaps = 0;

        while (true) {
            System.out.print("""
                    
                    1 - To play game
                    2 - To generate games
                    
                    input: """);
            int gameMode = scanner.nextInt();
            System.out.print("\nNumber of games: ");
            numberOfGames = scanner.nextInt();

            switch (gameMode) {
                case 1 -> manualPlay(numberOfGames, random, scanner, wins, total);
                case 2 -> simulate(numberOfGames, random, swaps, winSwap, winNoSwap);
            }
        }
    }

    public static void simulate(int numberOfGames, Random random, double swaps, int winSwap, int winNoSwap) {
        for (int i = 0; i < numberOfGames; i++) {
            int randomDoor = random.nextInt(1, 4);
            int randomGuess = random.nextInt(1, 4);
            boolean swap = random.nextBoolean();
            boolean door1 = false;
            boolean door2 = false;
            boolean door3 = false;

            switch (randomDoor) {
                case 1 -> door1 = true;
                case 2 -> door2 = true;
                case 3 -> door3 = true;
            }

            if (swap) {
                swaps++;
            }
            if (swap && randomGuess != randomDoor) {
                winSwap++;
            }
            if (!swap && randomGuess == randomDoor) {
                winNoSwap++;
            }
        }
        double noSwaps = (numberOfGames - swaps);
        System.out.printf("\nYou won %d/%.0f(%.2f%%) games when you swapped doors!\n", winSwap, swaps, (winSwap/swaps * 100));
        System.out.printf("You won %d/%.0f(%.2f%%) games when you didn't swap!\n", winNoSwap, noSwaps , (winNoSwap / noSwaps * 100));
        System.out.println("\n----------------------------------------");

    }

    public static void manualPlay(int numberOfGames, Random random, Scanner scanner, int wins, int total) {
        String icon = "\u2588       ";
        String space = "        ";

        for (int i = 0; i < numberOfGames; i++) {
            int randomDoor = random.nextInt(1, 4);
            boolean randomShow = random.nextBoolean();
            boolean door1 = false;
            boolean door2 = false;
            boolean door3 = false;

            switch (randomDoor) {
                case 1 -> door1 = true;
                case 2 -> door2 = true;
                case 3 -> door3 = true;
            }

            System.out.println();
            System.out.println(1 + icon + 2 + icon + 3 + icon);
            System.out.print("Choose a door 1-3: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1 -> {
                    if (door1) {
                        if (randomShow) {
                            System.out.println(1 + icon + space + 3 + icon);
                        } else {
                            System.out.println(1+ icon + 2 + icon);
                        }
                    } else if (door2) {
                        System.out.println(1 + icon + space + 3 + icon);
                    } else {
                        System.out.println(1 + icon + 2 + icon);
                    }
                }
                case 2 -> {
                    if (door2) {
                        if (randomShow) {
                            System.out.println(space + 2 + icon + 3 + icon);
                        } else {
                            System.out.println(1 + icon + 2 + icon);
                        }
                    } else if (door1) {
                        System.out.println(1 + icon + 2 + icon);
                    } else {
                        System.out.println(space + 2 + icon + 3 + icon);
                    }
                }
                case 3 -> {
                    if (door3) {
                        if (randomShow) {
                            System.out.println(space + 2 + icon + 3 + icon);
                        } else {
                            System.out.println(1 + icon + space + 3 + icon);
                        }
                    } else if (door1) {
                        System.out.println(1 + icon + space + 3 + icon);
                    } else {
                        System.out.println(space + 2 + icon + 3 + icon);
                    }
                }
            }

            System.out.print("Swap door number " + choice + " for the other door? y/n: ");
            String swapDoor = scanner.nextLine();

            if ((swapDoor.equals("n") && choice == randomDoor) || swapDoor.equals("y") && choice != randomDoor) {
                System.out.println("Congratulations! You WON!\n");
                wins++;
            } else {
                System.out.println("You lost... Better luck next time.\n");
            }

            total++;
            System.out.printf("You have won %d/%d games.\n", wins, total);
            System.out.println("\n----------------------------------------");
        }
    }
}