import java.util.*;

public class Deck {
    private Card[] deck;
    private int count = 0;
    public Deck(){
        this.deck = new Card[52];
        populateDeck();
        getTrumpCard();
    }
    public void printDeck(){
        for(int i = 0; i < 52; i++){
            System.out.println(this.deck[i].value + " of " + this.deck[i].suit);
        }
    }
    private void populateDeck(){
        for(int i = 0; i < 4; i++){
            Suit suit = Suit.values()[i];
            for(int j = 0; j < 13; j++){
                CardValue value = CardValue.values()[j];
                Card card = new Card(suit, value);
                this.deck[count++] = card;
            }
        }
    }
    //Fisher-Yates
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
    private void getTrumpCard(){
        int r = new Random().nextInt(deck.length);
        //this.deck[r].value.setValue(CardValue.Trump.getValue())
        System.out.println("Trump card is: " + this.deck[r].value + " of " + this.deck[r].suit);
        this.deck[r] = new Card(this.deck[r].suit, CardValue.Trump);
    }
    public Stack<Card> distributeCards(boolean even){
        Stack<Card> stack = new Stack<>();
        int i = even ? 0 : 1;
        for(int j = i; j < this.count; j = j + 2){
            stack.push(this.deck[j]);
        }
        return stack;
    }

}
