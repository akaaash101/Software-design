import java.util.Scanner;
import java.util.Random;

/*
*Akaash Saini
*991635803
*/


public class cards {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Random random = new Random();
            String[] suits = { "hearts", "diamonds", "spades", "clubs" };
            String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

            Card[] hand = new Card[7];
            for (int i = 0; i < hand.length; i++) {
                int suitIndex = random.nextInt(suits.length);
                int rankIndex = random.nextInt(ranks.length);
                hand[i] = new Card(ranks[rankIndex], suits[suitIndex]);
            }

            System.out.println("Your hand: ");
            for (int i = 0; i < hand.length; i++) {
                System.out.println(hand[i].toString());
            }

            System.out.println("Pick a card (rank and suit): ");
            String rank = input.next();
            String suit = input.next();
            boolean found = false;
            for (int i = 0; i < hand.length; i++) {
                if (hand[i].getRank().equalsIgnoreCase(rank) && hand[i].getSuit().equalsIgnoreCase(suit)) {
                    System.out.println("You picked: " + hand[i].toString());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Card not found in hand.");
            }
        }
    }
}

class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
