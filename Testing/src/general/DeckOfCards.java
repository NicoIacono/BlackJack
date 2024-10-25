package general;

public class DeckOfCards {

    private String[] deck;
    private int cardsLeft;

    public DeckOfCards() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        deck = new String[52];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }

        cardsLeft = 52;
    }

    public String drawCard() {
        if (cardsLeft == 0)
            return "No cards left in the deck!";
        
        int randomIndex = (int)(Math.random() * deck.length);
        String drawnCard = deck[randomIndex];

        for (int i = randomIndex; i < cardsLeft - 1; i++) {
            deck[i] = deck[i + 1];
        }

        cardsLeft--; 
        return drawnCard;
    }
}