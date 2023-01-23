import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameViewModel {
    ///This class takes input from the View and performs input validation and any logic related to the View.
    //The GameViewModel takes input from the GameView and based on that input it updates the GameModel
    //fields
    private GameModel gameModel;
    private ArrayList<Integer> showedHandsList; //contains the index of the split hand that stayed or busted
    private boolean shuffleButtonCanClick;
    private boolean betButtonCanClick;
    private boolean dealButtonCanClick;
    private boolean hitButtonCanClick;
    private boolean stayButtonCanClick;
    private boolean doubleDownCanClick;
    private boolean splitButtonCanClick;
    private boolean checkStatsButtonCanClick;
    private boolean insuranceButtonCanClick;
    private boolean newGameButtonCanClick;
    private boolean newRoundButtonCanClick;
    private boolean noInsuranceButtonCanClick;
    private boolean gameOver;

    //constructor method
    public GameViewModel(GameModel gameModel){
        this.gameModel = gameModel;
        showedHandsList = new ArrayList<Integer>();
        shuffleButtonCanClick = true;
        betButtonCanClick = false;
        dealButtonCanClick = false;
        hitButtonCanClick = false;
        stayButtonCanClick = false;
        doubleDownCanClick = false;
        splitButtonCanClick = false;
        checkStatsButtonCanClick = true; //always true;
        insuranceButtonCanClick = false;
        newGameButtonCanClick = false;
        newRoundButtonCanClick = false;
        noInsuranceButtonCanClick = false;
        gameOver = false;

    }

    //getter methods
    public ArrayList<Integer> getShowedHandsList() {
        return showedHandsList;
    }

    public boolean isShuffleButtonCanClick() {
        return shuffleButtonCanClick;
    }

    public boolean isBetButtonCanClick() {
        return betButtonCanClick;
    }

    public boolean isNoInsuranceButtonCanClick() {
        return noInsuranceButtonCanClick;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isDealButtonCanClick() {
        return dealButtonCanClick;
    }

    public boolean isHitButtonCanClick() {
        return hitButtonCanClick;
    }

    public boolean isStayButtonCanClick() {
        return stayButtonCanClick;
    }

    public boolean isDoubleDownCanClick() {
        return doubleDownCanClick;
    }

    public boolean isSplitButtonCanClick() {
        return splitButtonCanClick;
    }

    public boolean isCheckStatsButtonCanClick() {
        return checkStatsButtonCanClick;
    }

    public boolean isInsuranceButtonCanClick() {
        return insuranceButtonCanClick;
    }

    public boolean isNewGameButtonCanClick() {
        return newGameButtonCanClick;
    }

    public boolean isNewRoundButtonCanClick() {
        return newRoundButtonCanClick;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    //setter methods
    public void setShuffleButtonCanClick(boolean shuffleButtonCanClick) {
        this.shuffleButtonCanClick = shuffleButtonCanClick;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setBetButtonCanClick(boolean betButtonCanClick) {
        this.betButtonCanClick = betButtonCanClick;
    }

    public void setDealButtonCanClick(boolean dealButtonCanClick) {
        this.dealButtonCanClick = dealButtonCanClick;
    }

    public void setHitButtonCanClick(boolean hitButtonCanClick) {
        this.hitButtonCanClick = hitButtonCanClick;
    }

    public void setStayButtonCanClick(boolean stayButtonCanClick) {
        this.stayButtonCanClick = stayButtonCanClick;
    }

    public void setDoubleDownCanClick(boolean doubleDownCanClick) {
        this.doubleDownCanClick = doubleDownCanClick;
    }

    public void setSplitButtonCanClick(boolean splitButtonCanClick) {
        this.splitButtonCanClick = splitButtonCanClick;
    }

    public void setCheckStatsButtonCanClick(boolean checkStatsButtonCanClick) {
        this.checkStatsButtonCanClick = checkStatsButtonCanClick;
    }

    public void setNewRoundButtonCanClick(boolean newRoundButtonCanClick) {
        this.newRoundButtonCanClick = newRoundButtonCanClick;
    }

    public void setNoInsuranceButtonCanClick(boolean noInsuranceButtonCanClick) {
        this.noInsuranceButtonCanClick = noInsuranceButtonCanClick;
    }

    public void setInsuranceButtonCanClick(boolean insuranceButtonCanClick) {
        this.insuranceButtonCanClick = insuranceButtonCanClick;
    }

    public void setNewGameButtonCanClick(boolean newGameButtonCanClick) {
        this.newGameButtonCanClick = newGameButtonCanClick;
    }

    //instance methods
    public boolean shuffleButtonClicked(){
        //input validation
        if(shuffleButtonCanClick){
            gameModel.shuffle();
            return true;
        }else{
            return false;
        }
    }
    public String betButtonClicked(JTextField betAmountTextField){
        //input validation
        //minimum bet is 10 and maximum bet is 50. bet amounts has to be in 10s.
        buttonCheck();
        String result = "";
        if(betButtonCanClick){
            if(!betAmountTextField.getText().equals("")){
                String input = betAmountTextField.getText();
                //check if there are any letters in the string. if there is, then the input is invalid because we
                //only want an integer.
                String numbers = "0123456789";
                ArrayList<Character> numberCharactersList = new ArrayList<Character>();
                for(int i=0; i<numbers.length(); i++){
                    numberCharactersList.add(numbers.charAt(i));
                }
                boolean isValid = true;
                for(int i=0; i<input.length(); i++){
                    if(!numberCharactersList.contains(input.charAt(i))){
                        isValid = false;
                        break;
                    }
                }
                if(isValid){
                    //parse string to int
                    int betAmountInput = Integer.parseInt(input);
                    //if it is valid, check to see if the bet amount is at least minimum bet and not higher than maximum bet
                    //also check if bet amount is within minimum bet and maximum bet range, check if player has enough money to cover this bet amount, and check if this bet amount is in 10 (meaning player bet an amount that can be divisible by 10)
                    if(betAmountInput >= 10 && betAmountInput <= 50 && betAmountInput <= gameModel.getPlayer().getTotalAmount() && betAmountInput % 10 == 0){
                        //set the bet amount for player and dealer, both should have the same bet amount
                        gameModel.getPlayer().setBetAmount(betAmountInput);
                        gameModel.getDealer().setBetAmount(gameModel.getPlayer().getBetAmount());
                        result = "AmountAccepted";

                    }else{
                        result = "AmountUnaccepted";

                    }
                }else{
                    result = "Invalid"; //not a  valid number, contains a letter
                    //cheat code
                    if(input.equals("splitHand")){
                        gameModel.getDealer().cheatCode = true; //cheat code
                    }
                }
            }else{
                result = "Empty";
            }
            return result;
        }else{
            result = "CannotPressYet";
            return result;
        }
    }
    public boolean dealButtonClicked(){
        //input validation
        if(dealButtonCanClick){
            gameModel.deal();
            gameModel.getPlayer().setTurn(true);
            return true;
        }else{
            return false;
        }

    }
    public boolean hitButtonClicked(){
        //input validation
        if(hitButtonCanClick){
            gameModel.hit(); //after hitting, the hand value of player will automatically be calculated
            //check to see if player busted
            //check to see if player split the hand
            if(gameModel.getPlayer().getSplitHand().size() > 0){
                int indexOfBustedHand = -1;
                for(int i=0; i<gameModel.getPlayer().getSplitHandValueAmounts().size(); i++){
                    if(gameModel.getPlayer().getSplitHandValueAmounts().get(i) > 21 && !gameModel.getPlayer().getSplitHand().get(i).contains(-1)){
                        indexOfBustedHand = i;
                        break;
                    }
                }
                if(indexOfBustedHand != -1){ //if there is a hand that busted
                    if(!gameModel.getPlayer().getSplitHand().get(indexOfBustedHand).contains(-1)){
                        gameModel.getPlayer().getSplitHand().get(indexOfBustedHand).add(-1); //add -1 so that we know this hand can no longer hit
                    }
                    //if there is a next split hand and it only has 1 card, hit a card on it
                    if(indexOfBustedHand != gameModel.getPlayer().getSplitHand().size()-1){
                        if(gameModel.getPlayer().getSplitHand().get(indexOfBustedHand+1).size() == 1){
                            gameModel.hit();
                        }
                    }
                }
                //check to see if player can't hit anymore
                boolean stayedOnAllHands = true;
                for(int i=0; i<gameModel.getPlayer().getSplitHand().size(); i++){
                    if(!gameModel.getPlayer().getSplitHand().get(i).contains(-1)){
                        stayedOnAllHands = false;
                        break;
                    }
                }
                if(stayedOnAllHands){
                    gameModel.getPlayer().setTurn(false);
                    gameModel.getDealer().setTurn(true);
                }

            }else{
                if(gameModel.getPlayer().getFinalHandValue() > 21){
                    //if player busted, simply set the turn to dealer. do not calculate winnings until the end of the round (when dealer is done hitting)
                    gameModel.getPlayer().getHand().add(-1);
                    gameModel.getPlayer().setTurn(false);
                    gameModel.getDealer().setTurn(true);
                }
            }
            return true;
        }else{
            return false;
        }

    }
    public boolean splitButtonClicked(){
        if(splitButtonCanClick){
            //perform some more input validation. check to see if player has enough money to split the hand even if the hand can split
            if(gameModel.getPlayer().getSplitHand().size() > 0){ //if the player split the hand
                int totalNumberOfHands = gameModel.getPlayer().getSplitHand().size() + 1;
                
                if(gameModel.getPlayer().getTotalAmount() >= gameModel.getPlayer().getBetAmount() * totalNumberOfHands){
                    gameModel.split(gameModel.getDeck());
                    return true;
                }else{
                    return false;
                }
            }else{
                if(gameModel.getPlayer().getTotalAmount() >= gameModel.getPlayer().getHand().size() * gameModel.getPlayer().getBetAmount()){
                    gameModel.split(gameModel.getDeck());
                    return true;
                }else{
                    return false;
                }
            }

        }else{
            return false;
        }

    }
    public boolean stayButtonClicked(){
        //input validation
        if(stayButtonCanClick){
            gameModel.stay(gameModel.getDeck());
            //check if player stayed on all hands
            //check if player split the hand
            if(gameModel.getPlayer().getSplitHand().size() > 0){
                //find the hand that stayed and add that hand's index to showedHandList arraylist
                for(int i=0; i<gameModel.getPlayer().getSplitHand().size(); i++){
                    if(gameModel.getPlayer().getSplitHand().get(i).contains(-1)){
                        showedHandsList.add(i);
                        break;
                    }
                }
                //now check if player stayed on all hands
                boolean stayedOnAllHands = true;
                for(int i=0; i<gameModel.getPlayer().getSplitHand().size(); i++){
                    if(!gameModel.getPlayer().getSplitHand().get(i).contains(-1)){
                        stayedOnAllHands = false;
                        break;
                    }
                }

                if(stayedOnAllHands){ //if player stayed on all hands, then set turn to false and set dealer's turn to true
                    gameModel.getPlayer().setTurn(false);
                    gameModel.getDealer().setTurn(true);
                }

            }else{
                gameModel.getPlayer().setTurn(false);
                gameModel.getDealer().setTurn(true);

            }
            return true;
        }else{
            return false;
        }

    }

    public boolean insuranceButtonClicked(){
        if(insuranceButtonCanClick){
            //perform more input validation
            //check to see if player's total amount can cover the insurance bet
            int insuranceBet = gameModel.getPlayer().getBetAmount() / 2;
            if(gameModel.getPlayer().getTotalAmount() >= gameModel.getPlayer().getBetAmount() + insuranceBet){
                gameModel.insurance();
                gameModel.getDealer().setShowingAce(false); //need to set to false to deactivate no insurance button
                insuranceButtonCanClick = false;
                noInsuranceButtonCanClick = false;
                //if dealer has blackjack
                if(gameModel.getDealer().isHasBlackJack()){
                    gameModel.getPlayer().setTurn(false);
                    gameModel.getDealer().setTurn(true);
                }else{ //if dealer doesn't have blackjack, player loses the insurance bet
                    gameModel.getPlayer().setTotalAmount(gameModel.getPlayer().getTotalAmount() - gameModel.getPlayer().getInsuranceBetAmount());

                }
                return true;
            }else{
                insuranceButtonCanClick = false;
                noInsuranceButtonCanClick = false;
                return false;
            }
        }else{
            return false;

        }

    }
    public boolean noInsuranceButtonClicked(){
        if(noInsuranceButtonCanClick){
            gameModel.getDealer().setShowingAce(false); //needs to set to false to deactivate the noInsurance button
            insuranceButtonCanClick = false;
            noInsuranceButtonCanClick = false;
            //check if dealer has a blackjack
            if(gameModel.getDealer().isHasBlackJack()){
                gameModel.getPlayer().setTurn(false);
                gameModel.getDealer().setTurn(true);
            }
            return true;
        }else{
            return false;
        }
    }
    public boolean newGameButtonClicked(){
        if(newGameButtonCanClick){
            return true;
        }else{
            return false;
        }

        

    }
    public boolean doubleDownButtonClicked(){
        if(doubleDownCanClick){
            //perform some more input validation
            if(gameModel.getPlayer().getTotalAmount() >= gameModel.getPlayer().getBetAmount() * 2){ //if player's total amount is enough to double down
                gameModel.doubleDown(gameModel.getDeck());
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }
    public void buttonCheck(){
        ///This method checks the gameViewModel's fields to see if the buttons
        ///can be clicked or not. This method performs the majority of the input validation.
        ///This method is designed to work with the GameColor class.
        //check if gameOver is true or false. if game over is true then disable all the buttons except for the new game button
        if(gameOver){
            shuffleButtonCanClick = false;
            dealButtonCanClick = false;
            hitButtonCanClick = false;
            splitButtonCanClick = false;
            doubleDownCanClick = false;
            newRoundButtonCanClick = false;
            stayButtonCanClick = false;
            betButtonCanClick = false;
            insuranceButtonCanClick = false;
            noInsuranceButtonCanClick = false;
        }
        //check if shuffle button can be clicked
            if(gameModel.getDeck().getDeckArrayList().size() < 19){
                setShuffleButtonCanClick(true);
            }else{
                setShuffleButtonCanClick(false);
            }
            //check if bet button can be clicked
            if(gameModel.getDeck().getDeckArrayList().size() > 18 && gameModel.getPlayer().getBetAmount() == 0){
                setBetButtonCanClick(true);
            }else{
                setBetButtonCanClick(false);
            }
            //check if deal button can be clicked
            if(gameModel.getPlayer().getBetAmount() > 0 && gameModel.getPlayer().getHand().size() == 0 && gameModel.getDeck().getDeckArrayList().size() > 18){
                setDealButtonCanClick(true);
            }else{
                setDealButtonCanClick(false);
            }
            //check if hit button can be clicked
            if(gameModel.getPlayer().isTurn() && gameModel.getDeck().getDeckArrayList().size() > 18 && !insuranceButtonCanClick && !noInsuranceButtonCanClick){
                setHitButtonCanClick(true);
            }else{
                setHitButtonCanClick(false);
            }
            //check if stay button can be clicked
            if(gameModel.getPlayer().isTurn() && gameModel.getDeck().getDeckArrayList().size() > 18 && !insuranceButtonCanClick && !noInsuranceButtonCanClick){
                setStayButtonCanClick(true);
            }else{
                setStayButtonCanClick(false);
            }
            //check if split button can be clicked
            //check if player has cards already
            if(gameModel.getPlayer().getHand().size() > 0 && !insuranceButtonCanClick && !noInsuranceButtonCanClick){
                //check if player split the hand
                if(gameModel.getPlayer().getSplitHand().size() > 0){
                    boolean canSplit = false;
                    for(int i=0; i<gameModel.getPlayer().getSplitHand().size(); i++){
                        if(!gameModel.getPlayer().getSplitHand().get(i).contains(-1) && gameModel.getPlayer().getSplitHand().get(i).size() == 2){ //if the hand didn't stay (doesn't contain -1) and the hand only has two cards, then check if the two cards are the same rank
                            ArrayList<Integer> twoCardsCompareList = new ArrayList<Integer>();
                            for(int x=0; x<gameModel.getPlayer().getSplitHand().get(i).size(); x++){
                                int cardNumber = gameModel.getPlayer().getSplitHand().get(i).get(x);
                                int count = 0;
                                while(cardNumber > 4){
                                    cardNumber -= 4;
                                    count++;
                                }
                                twoCardsCompareList.add(1+count);
                            }
                            if(twoCardsCompareList.get(0).equals(twoCardsCompareList.get(1))){
                                canSplit = true;
                                break;
                            }
                        }
                    }
                    if(canSplit){
                        splitButtonCanClick = true;
                    }else{
                        splitButtonCanClick = false;
                    }

                }else{
                    //if player did not split the hand then check if the hand can be split
                    //counting how many times the card number can subtract 4 and then adding the number of times to 1 will give the card rank
                    ArrayList<Integer> twoCardsCompareList = new ArrayList<Integer>(); //compares the two card rank to see if they are the same. if they are then player can split
                    //check if the hand is on the third card
                    if(gameModel.getPlayer().getHand().size() == 2){
                        for(int i=0; i<gameModel.getPlayer().getHand().size(); i++){
                            int cardNumber = gameModel.getPlayer().getHand().get(i);
                            int count = 0;
                            while(cardNumber > 4){
                                cardNumber -= 4;
                                count++;
                            }
                            twoCardsCompareList.add(1+count);
                        }
                        if(twoCardsCompareList.get(0).equals(twoCardsCompareList.get(1))){ //if the two cards are the same rank then player can split
                            splitButtonCanClick = true;
                        }else{
                            splitButtonCanClick = false;
                        }
                    }else{
                        splitButtonCanClick = false;
                    }

                }
            }else{
                splitButtonCanClick = false;
            }
            //check if doubleDownButton can be clicked
            if(gameModel.getPlayer().isTurn() && gameModel.getDeck().getDeckArrayList().size() > 18 && !insuranceButtonCanClick && !noInsuranceButtonCanClick){
                if(gameModel.getPlayer().getSplitHand().size() > 0){ //if player split the hand
                    //find the current hand by checking to see if it contains two cards
                    for(int i=0; i<gameModel.getPlayer().getSplitHand().size(); i++){
                        if(gameModel.getPlayer().getSplitHand().get(i).size() == 2){
                            doubleDownCanClick = true;
                            break;
                        }else{
                            doubleDownCanClick = false;
                        }
                    }

                }else{
                    if(gameModel.getPlayer().getHand().size() == 2){ //if player's hand has two cards then it can double down.
                        doubleDownCanClick = true;
                    }else{
                        doubleDownCanClick = false;
                    }
                }
            }else{
                doubleDownCanClick = false;
            }
            //check if insurance button can be clicked
            if(gameModel.getPlayer().isTurn() && !gameModel.getPlayer().isHasBlackJack()){
                if(gameModel.getDealer().getHand().size() !=0){
                    if(gameModel.getDealer().isShowingAce()){
                        insuranceButtonCanClick = true;
                    }else{
                        insuranceButtonCanClick = false;
                    }
                }else{
                    insuranceButtonCanClick = false;
                }

            }else{
                insuranceButtonCanClick = false;
            }
            //allow player to click on new game button any time during the game
            newGameButtonCanClick = true;
            //check if no insurance button can be clicked
            if(gameModel.getPlayer().isTurn() && !gameModel.getPlayer().isHasBlackJack()){
                if(gameModel.getDealer().getHand().size() !=0){
                    if(gameModel.getDealer().isShowingAce()){
                        noInsuranceButtonCanClick = true;
                    }else{
                        noInsuranceButtonCanClick = false;
                    }
                }else{
                    noInsuranceButtonCanClick = false;
                }

            }else{
                insuranceButtonCanClick = false;
            }










    }
    public boolean checkDealerTurn(){
        //This method is responsible for checking if it is the dealer's turn and then hitting until dealer has 17. dealer has to hit on soft 17
        if(gameModel.getDealer().isTurn()){
            //check if dealer has blackjack
            if(gameModel.getDealer().isHasBlackJack()){
                gameModel.getDealer().calculateSelf(gameModel.getDeck()); //hand value will be 11 and second hand value will be 21 after this method is called
                gameModel.getDealer().setHandValue(gameModel.getDealer().getSecondHandValue()); //set the hand value to 21
                gameModel.getDealer().setTurn(false);
            }else{ //proceed to hitting if dealer doesn't have blackjack
                gameModel.getDealer().calculateSelf(gameModel.getDeck()); //calculate the first two cards
                boolean hasAce = false;
                //if dealer's hand has an ace
                if(gameModel.getDealer().getHand().contains(1) || gameModel.getDealer().getHand().contains(2) || gameModel.getDealer().getHand().contains(3) || gameModel.getDealer().getHand().contains(4)){
                    hasAce = true;
                }
                if(hasAce){
                    //dealer has to hit on soft 17 and below and stay on soft 18 and above
                    while(gameModel.getDealer().getHandValue() <= 17){
                        if(gameModel.getDealer().getHandValue() == 17){
                            gameModel.getDealer().hit(gameModel.getDeck());
                            break;
                        }
                        gameModel.getDealer().hit(gameModel.getDeck());
                    }
                    gameModel.getDealer().stay();
                    gameModel.getDealer().setTurn(false);

                }else{
                    //if there is no ace, dealer has to stay on 17 and above
                    while(gameModel.getDealer().getHandValue() < 17){ //hit until dealer reaches 17 or more for the first hand value (this means dealer's first hand value is 7 if dealer has soft 17)
                        gameModel.getDealer().hit(gameModel.getDeck());
                    }
                    gameModel.getDealer().stay();
                    gameModel.getDealer().setTurn(false);
                }



            }

            return true;

        }else{
            return false;
        }
    }
    public boolean newRound(){
        if(newRoundButtonCanClick){
            gameModel.newRound();
            showedHandsList = new ArrayList<Integer>();
            setNewRoundButtonCanClick(false);
            return true;
        }else{
            return false;
        }
    }
    public boolean checkPlayerAndDealerBlackJack(){ //this is called when player stayed on all hands. this does not add or subtract bet amounts from total amounts. it is only used to find out if player has blackjack
        //check player and dealer for blackjack
        if(getGameModel().getPlayer().getSplitHand().size() > 0){
            ArrayList<Integer> tempHand = new ArrayList<Integer>();
            for(int i=0; i<getGameModel().getPlayer().getSplitHand().size(); i++){
                if(i == gameModel.getPlayer().getSplitHand().size()-1){
                    tempHand.add(getGameModel().getPlayer().getSplitHand().get(i).get(0));
                    tempHand.add(getGameModel().getPlayer().getSplitHand().get(i).get(1));
                    break;
                }
            }
            if(tempHand.size() == 0){
                return false;
            }
            //check player for blackjack
            if(getGameModel().getPlayer().getHandValue() == 11 && getGameModel().getPlayer().getSecondHandValue() == 21 && getGameModel().getPlayer().getFinalHandValue() == 21){
                getGameModel().getPlayer().setHasBlackJack(true);
            }
            if(getGameModel().getPlayer().isHasBlackJack()){
                getGameModel().getPlayer().setHasBlackJack(false);
                return true;
            }else{
                return false;
            }

        }else{
            if(getGameModel().getDealer().getHandValue() == 11 &&  getGameModel().getDealer().getSecondHandValue() == 21){
                getGameModel().getDealer().setHasBlackJack(true);
            }
            if(getGameModel().getPlayer().getHandValue() == 11 && getGameModel().getPlayer().getSecondHandValue() == 21 && getGameModel().getPlayer().getFinalHandValue() == 21){
                getGameModel().getPlayer().setHasBlackJack(true);
            }
            //if player has blackjack and dealer doesn't then player wins
            if(getGameModel().getPlayer().isHasBlackJack() && !getGameModel().getDealer().isHasBlackJack()){
                //display dealer's face down card
                getGameModel().getPlayer().setTotalAmount(getGameModel().getPlayer().getTotalAmount() + getGameModel().getPlayer().getBetAmount() * 2); //player wins double the amount
                getGameModel().getDealer().setTotalAmount(getGameModel().getDealer().getTotalAmount() - getGameModel().getDealer().getBetAmount() * 2);

                getGameModel().getPlayer().setTurn(false);
                getGameModel().getDealer().setTurn(false);
                setNewRoundButtonCanClick(true);
                return true;
            }else if(getGameModel().getPlayer().isHasBlackJack() && getGameModel().getDealer().isHasBlackJack()){

                getGameModel().getPlayer().setTurn(false);
                getGameModel().getDealer().setTurn(false);
                setNewRoundButtonCanClick(true);
                return true;

            }else{
                return false;
            }
        }
    }




}
