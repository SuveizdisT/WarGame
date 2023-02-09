import java.util.*;

public class Deck {
    private Card[] deck;
    private int count = 0;
    public Deck(){
        this.deck = new Card[52];
        populateDeck();
        getTrumpCard();
    }

    /**
     * The method prints all deck cards
     */
    public void printDeck(){
        for(int i = 0; i < 52; i++){
            if(this.deck[i] == null)
                break;
            else System.out.println(this.deck[i].value + " of " + this.deck[i].suit);
        }
    }

    /**
     * The method fills the selected deck with cards
     */
    private void populateDeck(){
        for(int i = 0; i < Suit.values().length; i++){
            Suit suit = Suit.values()[i];
            for(int j = 0; j < CardValue.values().length-1; j++){
                CardValue value = CardValue.values()[j];
                Card card = new Card(suit, value);
                this.deck[count++] = card;
            }
        }
    }

    /**
     * The method shuffles the deck using the Fisher-Yates algorithm
     */
    public void shuffle(){
        int n = deck.length;
        Random r = new Random();
        for(int i = n-1; i > 0; i--){
            int j = r.nextInt(i+1);

            Card temp = this.deck[i];
            this.deck[i] = this.deck[j];
            this.deck[j] = temp;
        }
    }

    /**
     * The method randomly selects a trump card from a deck of cards
     */
    private void getTrumpCard(){
        int r = new Random().nextInt(deck.length);
        if(this.deck[r] == null)
            doNothing();
        else {
            System.out.println("Trump card is: " + this.deck[r].value + " of " + this.deck[r].suit);
            this.deck[r] = new Card(this.deck[r].suit, CardValue.Trump);
        }
    }

    /**
     * The method distributes cards to the player.
     * @param even boolean value
     * @return Player stack of cards
     */
    public Stack<Card> distributeCards(boolean even){
        Stack<Card> stack = new Stack<>();
        int i = even ? 0 : 1;
        for(int j = i; j < this.count; j = j + 2){
            stack.push(this.deck[j]);
        }
        return stack;
    }
    private void doNothing(){};
}
