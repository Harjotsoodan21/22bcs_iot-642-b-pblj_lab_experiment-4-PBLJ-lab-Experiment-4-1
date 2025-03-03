Experiment 4.2: Card Collection System

Objective:
Develop a Java program that collects and stores playing cards to help users find all the cards of a given symbol (suit).
The program should utilize the Collection interface (such as ArrayList, HashSet, or HashMap) to manage the card data efficiently.

Understanding the Problem Statement

1. Card Structure:
Each card consists of a symbol (suit) and a value (rank).

Example card representations:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

2. Operations Required:
Add Cards → Store card details in a collection.
Find Cards by Symbol (Suit) → Retrieve all cards belonging to a specific suit (e.g., all "Hearts").
Display All Cards → Show all stored cards.

3. Collections Usage:
ArrayList: To store cards in an ordered manner.
HashSet: To prevent duplicate cards.
HashMap<String, List<Card>>: To organize cards based on suits for faster lookup.


Test Cases

Test Case 1: No Cards Initially
Input:
Display All Cards
Expected Output:
No cards found.

Test Case 2: Adding Cards
Input:
Add Card: Ace of Spades
Add Card: King of Hearts
Add Card: 10 of Diamonds
Add Card: 5 of Clubs
Expected Output:
Card added: Ace of Spades
Card added: King of Hearts
Card added: 10 of Diamonds
Card added: 5 of Clubs

Test Case 3: Finding Cards by Suit
Input:
Find All Cards of Suit: Hearts
Expected Output:
King of Hearts

Test Case 4: Searching Suit with No Cards
Input:
Find All Cards of Suit: Diamonds
(If no Diamonds were added)
Expected Output:
No cards found for Diamonds.

Test Case 5: Displaying All Cards
Input:
Display All Cards
Expected Output:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

Test Case 6: Preventing Duplicate Cards
Input:
Add Card: King of Hearts
Expected Output:
Error: Card "King of Hearts" already exists.

Test Case 7: Removing a Card
Input:
Remove Card: 10 of Diamonds
Expected Output:
Card removed: 10 of Diamonds
  program code :
  import java.util.*;

class Card {
    String suit;
    String rank;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

 
    public String toString() {
        return rank + " of " + suit;
    }

   
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return rank.equals(card.rank) && suit.equals(card.suit);
    }


    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}

public class CardCollectionSystem {
    private static Map<String, List<Card>> cardMap = new HashMap<>();
    private static Set<Card> cardSet = new HashSet<>();

    public static void addCard(String rank, String suit) {
        Card newCard = new Card(rank, suit);
        if (cardSet.contains(newCard)) {
            System.out.println("Error: Card \"" + newCard + "\" already exists.");
            return;
        }
        cardSet.add(newCard);
        cardMap.putIfAbsent(suit, new ArrayList<>());
        cardMap.get(suit).add(newCard);
        System.out.println("Card added: " + newCard);
    }

    public static void findCardsBySuit(String suit) {
        if (cardMap.containsKey(suit) && !cardMap.get(suit).isEmpty()) {
            cardMap.get(suit).forEach(System.out::println);
        } else {
            System.out.println("No cards found for " + suit + ".");
        }
    }

    public static void displayAllCards() {
        if (cardSet.isEmpty()) {
            System.out.println("No cards found.");
        } else {
            cardSet.forEach(System.out::println);
        }
    }

    public static void removeCard(String rank, String suit) {
        Card cardToRemove = new Card(rank, suit);
        if (cardSet.remove(cardToRemove)) {
            cardMap.get(suit).remove(cardToRemove);
            if (cardMap.get(suit).isEmpty()) {
                cardMap.remove(suit);
            }
            System.out.println("Card removed: " + cardToRemove);
        } else {
            System.out.println("Error: Card \"" + cardToRemove + "\" not found.");
        }
    }

    public static void main(String[] args) {
        addCard("Ace", "Spades");
        addCard("King", "Hearts");
        addCard("10", "Diamonds");
        addCard("5", "Clubs");
        
        displayAllCards();
        
        findCardsBySuit("Hearts");
        findCardsBySuit("Diamonds");
        
        removeCard("10", "Diamonds");
        displayAllCards();
        
        addCard("King", "Hearts"); // Duplicate test
    }
}
