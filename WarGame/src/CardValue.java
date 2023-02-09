public enum CardValue {
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(11),
    Queen(12),
    King(13),
    Ace(14),
    Trump(20);

    private int cardValue;
    CardValue(int value){
        this.cardValue = value;
    }
    public int getValue(){
        return this.cardValue;
    }
    public void setValue(int value){
        this.cardValue = value;
    }
    public boolean isFirstStronger(CardValue second){
        return this.cardValue > second.cardValue;
    }
    public boolean checkTie(CardValue second){
        return this.cardValue == second.cardValue;
    }
}
