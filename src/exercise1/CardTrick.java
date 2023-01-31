package exercise1;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card. 
 * To be used as starting code in Exercise
 *
 * @author dancye
 * @author Paul Bonenfant Jan 25, 2022 
 * @author Jack Clayton Jan 31, 2022
 */
public class CardTrick {
    
    public static void main(String[] args) {
        /*
         * Complete the CardTrick class so that it models a “hand” of seven cards as an array
         * which is filled with random cards (you will have to create an algorithm that 
         * chooses random number values and random suits from the suits array (hint use Math.Random)
         */
        Card[] hand = new Card[7];

        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            Random valueRandom = new Random();
            //card.setValue(insert call to random number generator here)
            card.setValue(valueRandom.nextInt(13) + 1);
            //card.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            // Hint: You can use Random -> random.nextInt(n) to get a random number between 0 and n-1 (inclusive)
            //       Don't worry about duplicates at this point
            card.setSuit(Card.SUITS[valueRandom.nextInt(4)]);
            hand[i] = card;
        }

        // insert code to ask the user for Card value and suit, create their card
        // and search the hand here.

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of the card you're thinking of: ");
        int value = input.nextInt();
        System.out.println("Enter the suit of the card you're thinking of: ");
        int suit = input.nextInt();
        Card userCard = new Card();
        userCard.setValue(value);
        userCard.setSuit(Card.SUITS[suit]);
        input.close();
        // Hint: You can ask for values 1 to 10, and then
        //       11 for jack, 12 for queen, etc. (remember arrays are 0-based though)
        //       1 for Hearts, 2 for Diamonds, etc. (remember arrays are 0-based though)
        // 
        // Then loop through the cards in the array to see if there's a match.
        // If the guess is successful, invoke the printInfo() method below.
        
        boolean found = false;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].getValue() == userCard.getValue() && hand[i].getSuit() == userCard.getSuit()) {
                found = true;
                break;
            }
        }
        if (found) {
            printInfo();
        } else {
            System.out.println("Sorry, wrong card.");
        }
        
    }

    /**
     * A simple method to print out personal information. Follow the instructions to 
     * replace this information with your own.
     * @author Paul Bonenfant Jan 2022
     */
    private static void printInfo() {
    
        System.out.println("Congratulations, you guessed right!");
        System.out.println();
        
        System.out.println("My name is in Slate is John Clayton, but I go by Jack");
        System.out.println();
        
        System.out.println("My career ambitions:");
        System.out.println("-- Something involving Linux server management");
        System.out.println("-- Have a semester just as successful as last");
	System.out.println();	

        System.out.println("My hobbies:");
        System.out.println("-- Computer hardware");
        System.out.println("-- Docker containers");
        System.out.println("-- YouTube");
        System.out.println("-- Cooking");

        System.out.println();
        
    
    }

}
