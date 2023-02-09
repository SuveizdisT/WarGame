import java.util.Stack;

public class Game {
    /**
     * The method calculates result of the game
     * @param stack1 First player stack of cards
     * @param stack2 Second player stack of cards
     */
    public void start(Stack<Card> stack1, Stack<Card> stack2){
        int scorePile1 = 0, scorePile2 = 0;
        try{
            stack1.isEmpty(); stack2.isEmpty();
        }catch(Exception e){
            System.out.println("Stacks cannot be null");
        }

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            Card card1 = stack1.pop();
            Card card2 = stack2.pop();
            try {
                if (card1.value.checkTie(card2.value)) {
                    scorePile1++;
                    scorePile2++;
                } else if (card1.value.isFirstStronger(card2.value))
                    scorePile1 += 2;
                else scorePile2 += 2;
                System.out.println(card1.value + " vs " + card2.value + ": Score P1: " + scorePile1 + "  P2: " + scorePile2);

            }catch(Exception e){
                System.out.println("Cards cannot be null");
                break;
            }
        }

        if (scorePile1 > scorePile2)
            System.out.println("The winner is Player1. Score: " + scorePile1);
        else if (scorePile1 < scorePile2)
            System.out.println("The winner is Player2. Score: " + scorePile2);
        else System.out.println("Tie");
    }
}
