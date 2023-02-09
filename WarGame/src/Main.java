import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.printDeck();
        System.out.println("--------------------");
        Stack<Card> player1 = deck.distributeCards(true);
        Stack<Card> player2 = deck.distributeCards(false);
        Game game = new Game();
        game.start(player1, player2);

    }
}