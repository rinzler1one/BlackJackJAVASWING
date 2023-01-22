import java.util.ArrayList;

public class Dealer implements DealerAction {
    //fields
    public static boolean cheatCode;
    private int totalAmount; //represents dealer's total cash amount
    private int betAmount; //represents dealer's current bet amount
    private int handValue; //represents dealer's hand value of current hand
    private int secondHandValue; //represent dealer's second hand value of current hand (in case dealer has an ace in the hand)
    private boolean turn; //represent dealer's turn or not
    private boolean hasBlackJack; //represent if dealer has blackjack or not
    private boolean showingAce; //represent if dealer is showing ace or not
    private ArrayList<Integer> hand; //represent dealer's hand. each integer in this arraylist represents a card (see Deck class)
    //constructor method
    public Dealer(int totalAmount, int betAmount, boolean turn) {
        this.totalAmount = totalAmount;
        this.betAmount = betAmount;
        this.turn = turn;
        cheatCode = false;
        hasBlackJack = false;
        showingAce = false;
        handValue = 0;
        secondHandValue = 0;
        hand = new ArrayList<Integer>();
    }
    //getter methods
    public int getTotalAmount() {

        return totalAmount;
    }

    public int getBetAmount() {

        return betAmount;
    }

    public int getHandValue() {

        return handValue;
    }

    public int getSecondHandValue() {

        return secondHandValue;
    }

    public boolean isTurn() {

        return turn;
    }

    public boolean isHasBlackJack() {

        return hasBlackJack;
    }

    public ArrayList<Integer> getHand() {

        return hand;
    }

    public boolean isShowingAce() {
        return showingAce;
    }

    //setter methods
    public void setTotalAmount(int totalAmount) {

        this.totalAmount = totalAmount;
    }

    public void setShowingAce(boolean showingAce) {
        this.showingAce = showingAce;
    }

    public void setBetAmount(int betAmount) {

        this.betAmount = betAmount;
    }

    public void setHandValue(int handValue) {

        this.handValue = handValue;
    }

    public void setSecondHandValue(int secondHandValue) {

        this.secondHandValue = secondHandValue;
    }

    public void setTurn(boolean turn) {

        this.turn = turn;
    }

    public void setHasBlackJack(boolean hasBlackJack) {

        this.hasBlackJack = hasBlackJack;
    }

    public void setHand(ArrayList<Integer> hand) {

        this.hand = hand;
    }
    //instance methods

    @Override
    public void hit(Deck deck) {
        hand.add(deck.getDeckArrayList().get(0));
        deck.getDeckArrayList().remove(0);
        calculateSelf(deck);
    }

    @Override
    public void stay() {
        hand.add(-1);
    }

    @Override
    public void bet() {

    }

    @Override
    public void shuffle(Deck deck) {
        deck.setDeckArrayList(new ArrayList<Integer>());
        //pick a random number between 1 and 52, check if it is not in the used number list, if it is not then add it
        //to the deckArrayList field of the deck object and loop until the deckArrayList field contains 52 different numbers
        //which represents individual cards in a deck.
        ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
        int min = 1;
        int max = 52;
        while(deck.getDeckArrayList().size() < 52){
            int randomNum = (int)(Math.random() * (max - min + 1)) + min;
            if(!usedNumbers.contains(randomNum)){
                deck.getDeckArrayList().add(randomNum);
                usedNumbers.add(randomNum);
            }
        }




    }

    @Override
    public void deal(Player player, Deck deck) {
        if(cheatCode){ //cheat code
            player.getHand().add(5);
            player.getHand().add(6);
            hand.add(42);
            hand.add(32);
            //calculate hand value after initial cards are dealt
            player.calculateHandValue(deck);
        }else{
            //deal first card to player
            player.getHand().add(deck.getDeckArrayList().get(0));
            deck.getDeckArrayList().remove(0);
            //deal second card to dealer
            hand.add(deck.getDeckArrayList().get(0));
            deck.getDeckArrayList().remove(0);
            //deal third card to player
            player.getHand().add(deck.getDeckArrayList().get(0));
            deck.getDeckArrayList().remove(0);
            //deal fourth card to dealer
            hand.add(deck.getDeckArrayList().get(0));
            deck.getDeckArrayList().remove(0);
            //calculate hand value after initial cards are dealt
            player.calculateHandValue(deck);
        }

    }

    @Override
    public void calculatePlayerHand(Player player, Deck deck) {

    }

    @Override
    public void calculateSelf(Deck deck) {
        boolean hasAce = false;
        handValue = 0;
        secondHandValue = 0;
        for(int i=0; i<hand.size(); i++){
            handValue += deck.getCardStrengthsLinkedHashMap().get(hand.get(i));
            if(hand.get(i) == 1 || hand.get(i) == 2 || hand.get(i) == 3 || hand.get(i) == 4){
                hasAce = true;
            }
        }
        if(hasAce){
            secondHandValue = handValue + 10;
            if(secondHandValue > 21){
                secondHandValue = 0;
            }else{
                handValue = secondHandValue;
            }
        }


    }
    @Override
    public void resetData(){
        this.totalAmount = 1000;
        this.betAmount = 0;
        this.turn = false;
        cheatCode = false;
        hasBlackJack = false;
        showingAce = false;
        handValue = 0;
        secondHandValue = 0;
        hand = new ArrayList<Integer>();

    }
    public void newRound(){
        this.betAmount = 0;
        this.turn = false;
        cheatCode = false;
        hasBlackJack = false;
        showingAce = false;
        handValue = 0;
        secondHandValue = 0;
        hand = new ArrayList<Integer>();
    }
    public void checkIfShowingAce(){
        //This method should only be called right after the initial cards are dealt. This method is used to check
        //if dealer is showing an ace so that the insurance and no insurance buttons can be activated
        if(hand.get(1) == 1 || hand.get(1) == 2 || hand.get(1) == 3 || hand.get(1) == 4){
            showingAce = true;
        }else{
            showingAce = false;
        }
    }
}
