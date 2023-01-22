import java.util.ArrayList;

public class Player implements PlayerAction{
    //fields
    private int totalAmount; //represents player's total cash amount
    private int betAmount; //represents player's current bet amount
    private int handValue; //represents the value of player's current hand
    private int secondHandValue; //represents the second value of player's current hand (in case there is an ace in the hand)
    private int finalHandValue; //represents the final value of player's hand if player has an ace
    private int insuranceBetAmount; //represents player's insurance bet amount
    private boolean turn; //represents player's turn
    private boolean hasBlackJack; //represents if player has blackjack or not
    private boolean hasInsurance;
    private ArrayList<Integer> hand; //represents player's hand. holds a list of integers and each integer represents a card (see the Deck class)
    private ArrayList<ArrayList<Integer>> splitHand; //represents player's hand if player decided to split. each arraylist of integers represents player's hand
    private ArrayList<Integer> splitBetAmount; //represents player's bet amount for each hand that was split
    private ArrayList<Integer> splitHandValueAmounts;
    //constructor method
    public Player(int totalAmount, int betAmount, boolean turn) {
        this.totalAmount = totalAmount;
        this.betAmount = betAmount;
        this.turn = turn;
        handValue = 0;
        secondHandValue = 0;
        finalHandValue = 0;
        insuranceBetAmount = 0;
        hasBlackJack = false;
        hasInsurance = false;
        hand = new ArrayList<Integer>();
        splitHand = new ArrayList<ArrayList<Integer>>();
        splitBetAmount = new ArrayList<Integer>();
        splitHandValueAmounts = new ArrayList<Integer>();
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

    public int getFinalHandValue() {
        return finalHandValue;
    }
    public int getInsuranceBetAmount() {
        return insuranceBetAmount;
    }

    public boolean isHasBlackJack() {
        return hasBlackJack;
    }

    public boolean isTurn() {
        return turn;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

    public ArrayList<ArrayList<Integer>> getSplitHand() {
        return splitHand;
    }

    public ArrayList<Integer> getSplitBetAmount() {
        return splitBetAmount;
    }

    public ArrayList<Integer> getSplitHandValueAmounts() {
        return splitHandValueAmounts;
    }

    //setter methods
    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
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

    public void setHasBlackJack(boolean hasBlackJack) {
        this.hasBlackJack = hasBlackJack;
    }

    public void setInsuranceBetAmount(int insuranceBetAmount) {
        this.insuranceBetAmount = insuranceBetAmount;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public void setHand(ArrayList<Integer> hand) {
        this.hand = hand;
    }

    public void setSplitHand(ArrayList<ArrayList<Integer>> splitHand) {
        this.splitHand = splitHand;
    }

    public void setSplitBetAmount(ArrayList<Integer> splitBetAmount) {
        this.splitBetAmount = splitBetAmount;
    }

    //instance methods

    @Override
    public void hit(Deck deck) {
        //first check if player split the hand
        if(splitHand.size() > 0){
            //check each arraylist in splitHand to see if it doesn't contain -1. if it doesn't, then the hit card
            //will go into that arraylist. if it does contain -1 it means the player stayed on that hand.
            for(int i=0; i<splitHand.size(); i++){
                if(!splitHand.get(i).contains(-1)){
                    if(Dealer.cheatCode == true){
                        if(i == 0){
                            splitHand.get(i).add(12);
                        }else if(i == 1){
                            splitHand.get(i).add(45);
                        }
                        break;
                    }else{
                        splitHand.get(i).add(deck.getDeckArrayList().get(0));
                        deck.getDeckArrayList().remove(0);
                        break;
                    }

                }
            }
        }else{
            hand.add(deck.getDeckArrayList().get(0));
            deck.getDeckArrayList().remove(0);
        }
        //calculate the hand value after hitting
        calculateHandValue(deck);

    }

    @Override
    public void stay(Deck deck) {
        //adds -1 to the current hand
        //check to see if player split the hand
        if(splitHand.size() > 0){
            for(int i=0; i<splitHand.size(); i++){
                if(!splitHand.get(i).contains(-1)){
                    splitHand.get(i).add(-1); //add -1 to stop the hand for being able to hit. this represents staying on a hand
                    break;
                }
            }

            //hit the next hand so that there is two cards in the next hand
            hit(deck);
        }else{
            hand.add(-1);
            //calculate the hand value after staying
            calculateHandValue(deck);

        }

    }

    @Override
    public void bet() {


    }

    @Override
    public void doubleDown(Deck deck) {
        betAmount = betAmount * 2;
        hit(deck);


    }

    @Override
    public void split(Deck deck) {
        //check if the hand is already split
        if(splitHand.size() > 0){
            for(int i=0; i<splitHand.size(); i++){
                if(!splitHand.get(i).contains(-1) && splitHand.get(i).size() == 2){
                    ArrayList<Integer> handList = new ArrayList<Integer>();
                    handList.add(splitHand.get(i).get(1)); //split the card into a seperate hand
                    splitHand.add(handList); //add the split hand into the split hand list
                    splitHand.get(i).remove(1); //remove the card from the current hand
                    break;
                }
            }
            //now hit the card so that the current hand has a second card
            hit(deck);
            //adjust the bet amount
            splitBetAmount = new ArrayList<Integer>();
            for(int i=0; i<splitHand.size(); i++){
                splitBetAmount.add(betAmount);
            }

        }else{
            //split the cards into seperate hands
            for(int i=0; i<hand.size(); i++){
                ArrayList<Integer> handList = new ArrayList<Integer>(); //represents an individual hand
                handList.add(hand.get(i));
                splitHand.add(handList);
            }
            //now hit the card so that the current hand has a second card
            hit(deck);
            //adjust the bet amount
            for(int i=0; i<splitHand.size(); i++){
                splitBetAmount.add(betAmount);
            }

        }

    }

    @Override
    public void checkStats() {

    }

    @Override
    public void insurance() {
        insuranceBetAmount = betAmount / 2;


    }

    @Override
    public void newGame() {

    }

    @Override
    public void calculateHandValue(Deck deck) {
        //check to see if player's hand is split or not
        //this method should be called at the end of the round (when player stays and dealer is done hitting)

        if(splitHand.size() > 0){
            //if the hand was split, calculate the hand value of each hand and add it to splitHandValueAmounts arraylist
            splitHandValueAmounts = new ArrayList<Integer>(); //every time this method is called it should update the splitHandValueAmounts with new values
            for(int i=0; i<splitHand.size(); i++){
                int value = 0;
                for(int x=0; x<splitHand.get(i).size(); x++){
                    if(splitHand.get(i).get(x) != -1 ){
                        value += deck.getCardStrengthsLinkedHashMap().get(splitHand.get(i).get(x));

                    }
                }
                //if the split hand contains an ace
                if(splitHand.get(i).contains(1) || splitHand.get(i).contains(2) || splitHand.get(i).contains(3) || splitHand.get(i).contains(4)){
                    int secondValue = value + 10;
                    if(secondValue <= 21){
                        value = secondValue;
                    }

                }
                splitHandValueAmounts.add(value);
            }


        }else{
            //increment the handValue with the values in the hand arraylist
            //at the same time check for any aces. if there is then there is a second hand value
            handValue = 0;
            boolean hasAce = false;
            for(int i=0; i<hand.size(); i++){
                if(hand.get(i) != -1){
                    handValue += deck.getCardStrengthsLinkedHashMap().get(hand.get(i));
                    if(hand.get(i) == 1 || hand.get(i) == 2 || hand.get(i) == 3 || hand.get(i) == 4){
                        hasAce = true;
                    }
                }
            }
            if(hasAce){
                secondHandValue = handValue + 10;
                if(secondHandValue > 21){
                    secondHandValue = 0;
                    finalHandValue = handValue;
                }else{
                    finalHandValue = secondHandValue;
                }
            }else{
                finalHandValue = handValue;
            }
        }
    }
    @Override
    public void resetData(){
        this.totalAmount = 1000;
        this.betAmount = 0;
        this.turn = false;
        handValue = 0;
        secondHandValue = 0;
        finalHandValue = 0;
        insuranceBetAmount = 0;
        hasBlackJack = false;
        hasInsurance = false;
        hand = new ArrayList<Integer>();
        splitHand = new ArrayList<ArrayList<Integer>>();
        splitBetAmount = new ArrayList<Integer>();
        splitHandValueAmounts = new ArrayList<Integer>();
    }
    public void newRound(){
        handValue = 0;
        secondHandValue = 0;
        finalHandValue = 0;
        betAmount = 0;
        insuranceBetAmount = 0;
        hasBlackJack = false;
        hasInsurance = false;
        hand = new ArrayList<Integer>();
        splitHand = new ArrayList<ArrayList<Integer>>();
        splitBetAmount = new ArrayList<Integer>();
        splitHandValueAmounts = new ArrayList<Integer>();
    }
    public void noInsurance(){ //delete this method
        for(int i=0; i<5; i++){

        }
    }
}
